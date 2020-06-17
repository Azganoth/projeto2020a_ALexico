/**
 * Representa um token da linguagem LMS.
 */
public class Token {

	public Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * O tipo de um token.
	 */
	private TokenType type;

	/**
	 * O valor de um token.
	 */
	private String value;

	public TokenType getType() {
		return this.type;
	}

	public String getValue() {
		return this.value;
	}

	public int getCode() {
		return this.type.getCode();
	}

	public String getDescription() {
		return this.type.getDescription().toString();
	}

}
