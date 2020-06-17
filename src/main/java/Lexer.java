import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa um analisador léxico da linguagem LMS.
 */
public class Lexer {

	/**
	 * Dicionário de símbolos speciais da linguagem LMS.
	 */
	private final static Map<String, TokenType> SPECIAL_SYMBOLS = new HashMap<String, TokenType>();

	/**
	 * Dicionário de palavras reservadas da linguagem LMS.
	 */
	private final static Map<String, TokenType> RESERVED_WORDS = new HashMap<String, TokenType>();

	/**
	 * Dicionário de operadores da linguagem LMS.
	 */
	private final static Map<String, TokenType> OPERATORS = new HashMap<String, TokenType>();

	static {
		// #region Popular os dicionários da linguagem LMS.
		SPECIAL_SYMBOLS.put("[", TokenType.LEFT_BRACKET);
		SPECIAL_SYMBOLS.put("]", TokenType.RIGHT_BRACKET);
		SPECIAL_SYMBOLS.put("(", TokenType.LEFT_PAREN);
		SPECIAL_SYMBOLS.put(")", TokenType.RIGHT_PAREN);
		SPECIAL_SYMBOLS.put(":", TokenType.COLON);
		SPECIAL_SYMBOLS.put(",", TokenType.COMMA);
		SPECIAL_SYMBOLS.put(";", TokenType.SEMICOLON);
		SPECIAL_SYMBOLS.put(".", TokenType.DOT);
		SPECIAL_SYMBOLS.put("..", TokenType.DOUBLE_DOT);

		RESERVED_WORDS.put("PROGRAM", TokenType.PROGRAM);
		RESERVED_WORDS.put("LABEL", TokenType.LABEL);
		RESERVED_WORDS.put("CONST", TokenType.CONST);
		RESERVED_WORDS.put("VAR", TokenType.VAR);
		RESERVED_WORDS.put("PROCEDURE", TokenType.PROCEDURE);
		RESERVED_WORDS.put("BEGIN", TokenType.BEGIN);
		RESERVED_WORDS.put("END", TokenType.END);
		RESERVED_WORDS.put("INTEGER", TokenType.INTEGER);
		RESERVED_WORDS.put("ARRAY", TokenType.ARRAY);
		RESERVED_WORDS.put("OF", TokenType.OF);
		RESERVED_WORDS.put("CALL", TokenType.CALL);
		RESERVED_WORDS.put("GOTO", TokenType.GOTO);
		RESERVED_WORDS.put("IF", TokenType.IF);
		RESERVED_WORDS.put("THEN", TokenType.THEN);
		RESERVED_WORDS.put("ELSE", TokenType.ELSE);
		RESERVED_WORDS.put("WHILE", TokenType.WHILE);
		RESERVED_WORDS.put("DO", TokenType.DO);
		RESERVED_WORDS.put("REPEAT", TokenType.REPEAT);
		RESERVED_WORDS.put("UNTIL", TokenType.UNTIL);
		RESERVED_WORDS.put("READLN", TokenType.READLN);
		RESERVED_WORDS.put("WRITELN", TokenType.WRITELN);
		RESERVED_WORDS.put("OR", TokenType.OR);
		RESERVED_WORDS.put("AND", TokenType.AND);
		RESERVED_WORDS.put("NOT", TokenType.NOT);
		RESERVED_WORDS.put("FOR", TokenType.FOR);
		RESERVED_WORDS.put("TO", TokenType.TO);
		RESERVED_WORDS.put("CASE", TokenType.CASE);

		OPERATORS.put("+", TokenType.PLUS);
		OPERATORS.put("-", TokenType.MINUS);
		OPERATORS.put("*", TokenType.TIMES);
		OPERATORS.put("/", TokenType.DIV);
		OPERATORS.put("=", TokenType.EQUAL);
		OPERATORS.put(">", TokenType.GREATER);
		OPERATORS.put(">=", TokenType.GREATER_EQUAL);
		OPERATORS.put("<", TokenType.LESS);
		OPERATORS.put("<=", TokenType.LESS_EQUAL);
		OPERATORS.put("<>", TokenType.EQUIVALENT);
		// #endregion
	}

	/**
	 * O código-fonte.
	 */
	private final String sourceCode;

	/**
	 * A posição do ponteiro.
	 */
	private int pointer = 0;

	public Lexer(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	/**
	 * Retorna o caractére embaixo do ponteiro, sem consumi-lo. Retorna {@code '\u005Cu0000'} caso o
	 * ponteiro esteja fora dos limites do código-fonte.
	 *
	 * @return o caractére embaixo do ponteiro ou {@code '\u0000'}
	 */
	private char peek() {
		try {
			return sourceCode.charAt(pointer);
		} catch (IndexOutOfBoundsException e) {
			return Character.MIN_VALUE;
		}
	}

	/**
	 * Retorna o caractére embaixo do ponteiro especificado, sem consumi-lo. Retorna
	 * {@code '\u005Cu0000'} caso o ponteiro esteja fora dos limites do código-fonte.
	 *
	 * @return o caractére embaixo do ponteiro ou {@code '\u0000'}
	 */
	private char peek(int pointer) {
		try {
			return sourceCode.charAt(pointer);
		} catch (IndexOutOfBoundsException e) {
			return Character.MIN_VALUE;
		}
	}

	/**
	 * Pula o caractére embaixo do ponteiro, movendo o ponteiro para o próximo caractére.
	 */
	private void skip() {
		pointer += 1;
	}

	/**
	 * Pula os espaços em branco, movendo o ponteiro para o próximo caractére que não seja um espaço
	 * em branco.
	 */
	private void skipWhitespaces() {
		while (Character.isWhitespace(peek())) {
			skip();
		}
	}

	/**
	 * Consome o caractére embaixo do ponteiro, retornando o caractére e movendo o ponteiro para o
	 * próximo caractére.
	 */
	private char consume() {
		skip();
		return peek(pointer - 1);
	}

	/**
	 * Consome o próximo token válido do código-fonte a partir do ponteiro.
	 *
	 * @return o próximo token válido do código-fonte ou {@code null} caso o ponteiro esteja fora dos
	 *         limites do código-fonte
	 */
	private Token consumeToken() {
		skipWhitespaces();

		if (pointer < sourceCode.length()) {
			char firstChar = peek();

			// Símbolo especial (Qualquer um)
			// Comentário ([(][*][^*]*[*][)])
			// Atribuição (:=)
			TokenType specialSymbolType = SPECIAL_SYMBOLS.get(Character.toString(firstChar));

			if (specialSymbolType != null) {
				String tokenValue = Character.toString(consume());

				if (firstChar == '(' && peek() == '*') {
					skip();

					while (peek() != Character.MIN_VALUE && peek() != '*' && peek(pointer + 1) != ')') {
						skip();
					}

					if (peek() == '*') {
						skip();

						if (peek() == ')') {
							skip();
						}
					}

					return consumeToken();
				}

				if (peek() == '.') {
					tokenValue += consume();
					return new Token(TokenType.DOUBLE_DOT, tokenValue);
				}

				if (firstChar == ':' && peek() == '=') {
					tokenValue += consume();
					return new Token(TokenType.DEFINITION, tokenValue);
				}

				return new Token(specialSymbolType, tokenValue);
			}

			// Palavra reservada (Qualquer uma)
			// Identificador ([a-zA-Z][a-zA-Z0-9]*)
			if (Character.isLetter(firstChar)) {
				String tokenValue = Character.toString(consume());

				while (Character.isLetterOrDigit(peek())) {
					tokenValue += consume();
				}

				TokenType reservedWordType = RESERVED_WORDS.get(tokenValue.toUpperCase());

				if (reservedWordType != null) {
					return new Token(reservedWordType, tokenValue);
				}

				if (tokenValue.length() <= 30) {
					return new Token(TokenType.IDENTIFIER, tokenValue);
				}

				return consumeToken();
			}

			// Número inteiro (0 até 32767)
			if (Character.isDigit(firstChar)) {
				String tokenValue = Character.toString(consume());

				while (Character.isDigit(peek())) {
					tokenValue += consume();
				}

				if (tokenValue.length() <= 5 && Integer.parseInt(tokenValue) <= 32767) {
					return new Token(TokenType.NUMBER, tokenValue);
				}

				return consumeToken();
			}

			// Literal (["][^"]*["])
			if (firstChar == '"') {
				String tokenValue = Character.toString(consume());

				while (peek() != Character.MIN_VALUE && peek() != '"') {
					tokenValue += consume();
				}

				if (peek() == '"') {
					tokenValue += consume();
					return new Token(TokenType.LITERAL, tokenValue);
				}

				return consumeToken();
			}

			// Operador (Qualquer um)
			// Número inteiro (-32767 até 0)
			TokenType operatorType = OPERATORS.get(Character.toString(firstChar));

			if (operatorType != null) {
				String tokenValue = Character.toString(consume());

				if (firstChar == '>' && peek() == '=') {
					tokenValue += consume();
					return new Token(TokenType.GREATER_EQUAL, tokenValue);
				}

				if (firstChar == '<') {
					if (peek() == '=') {
						tokenValue += consume();
						return new Token(TokenType.LESS_EQUAL, tokenValue);
					}

					if (peek() == '>') {
						tokenValue += consume();
						return new Token(TokenType.EQUIVALENT, tokenValue);
					}
				}

				if (firstChar == '-') {
					while (Character.isDigit(peek())) {
						tokenValue += consume();
					}

					if (tokenValue.equals("-")) {
						return new Token(TokenType.MINUS, tokenValue);
					}

					if (tokenValue.length() <= 6 && Integer.parseInt(tokenValue) <= 0) {
						return new Token(TokenType.NUMBER, tokenValue);
					}

					return consumeToken();
				}

				return new Token(operatorType, tokenValue);
			}

			// Fim de arquivo
			if (firstChar == '$') {
				return new Token(TokenType.EOL, Character.toString(consume()));
			}

			skip(); // ignora o caractére inválido para a linguagem LMS
			return consumeToken();
		}

		return null;
	}

	/**
	 * Descreve um código-fonte de acordo com a linguagem LMS, listando todos os tokens válidos
	 * encontrados.
	 *
	 * @return todos os tokens válidos encontrados no código-fonte
	 */
	public List<Token> describeSourceCode() {
		List<Token> tokens = new ArrayList<>();

		Token token = consumeToken();
		while (token != null) {
			tokens.add(token);
			token = consumeToken();
		}

		return tokens;
	}

}
