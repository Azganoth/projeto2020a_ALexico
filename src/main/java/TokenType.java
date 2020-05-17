import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representa um tipo de token da linguagem LMS.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TokenType {

	PROGRAM(1, TokenDescription.RESERVED_WORD), // PROGRAM
	LABEL(2, TokenDescription.RESERVED_WORD), // LABEL
	CONST(3, TokenDescription.RESERVED_WORD), // CONST
	VAR(4, TokenDescription.RESERVED_WORD), // VAR
	PROCEDURE(5, TokenDescription.RESERVED_WORD), // PROCEDURE
	BEGIN(6, TokenDescription.RESERVED_WORD), // BEGIN
	END(7, TokenDescription.RESERVED_WORD), // END
	INTEGER(8, TokenDescription.RESERVED_WORD), // INTEGER
	ARRAY(9, TokenDescription.RESERVED_WORD), // ARRAY
	OF(10, TokenDescription.RESERVED_WORD), // OF
	CALL(11, TokenDescription.RESERVED_WORD), // CALL
	GOTO(12, TokenDescription.RESERVED_WORD), // GOTO
	IF(13, TokenDescription.RESERVED_WORD), // IF
	THEN(14, TokenDescription.RESERVED_WORD), // THEN
	ELSE(15, TokenDescription.RESERVED_WORD), // ELSE
	WHILE(16, TokenDescription.RESERVED_WORD), // WHILE
	DO(17, TokenDescription.RESERVED_WORD), // DO
	REPEAT(18, TokenDescription.RESERVED_WORD), // REPEAT
	UNTIL(19, TokenDescription.RESERVED_WORD), // UNTIL
	READLN(20, TokenDescription.RESERVED_WORD), // READLN
	WRITELN(21, TokenDescription.RESERVED_WORD), // WRITELN
	OR(22, TokenDescription.LOGIC_OPERATOR), // OR
	AND(23, TokenDescription.LOGIC_OPERATOR), // AND
	NOT(24, TokenDescription.NEGATION_OPERATOR), // NOT
	IDENTIFIER(25, TokenDescription.IDENTIFIER), // [a-zA-Z][a-zA-Z0-9]*
	NUMBER(26, TokenDescription.NUMBER), // [-]?[0-9]{1,5}
	FOR(27, TokenDescription.RESERVED_WORD), // FOR
	TO(28, TokenDescription.RESERVED_WORD), // TO
	CASE(29, TokenDescription.RESERVED_WORD), // CASE
	PLUS(30, TokenDescription.ADD_SUB_OPERATOR), // +
	MINUS(31, TokenDescription.ADD_SUB_OPERATOR), // -
	TIMES(32, TokenDescription.MULTI_DIV_OPERATOR), // *
	DIV(33, TokenDescription.MULTI_DIV_OPERATOR), // /
	LEFT_BRACKET(34, TokenDescription.SPECIAL_SYMBOL), // [
	RIGHT_BRACKET(35, TokenDescription.SPECIAL_SYMBOL), // ]
	LEFT_PAREN(36, TokenDescription.SPECIAL_SYMBOL), // (
	RIGHT_PAREN(37, TokenDescription.SPECIAL_SYMBOL), // )
	DEFINITION(38, TokenDescription.ASSIGNMENT), // :=
	COLON(39, TokenDescription.SPECIAL_SYMBOL), // :
	EQUAL(40, TokenDescription.RELATIONAL_OPERATOR), // =
	GREATER(41, TokenDescription.RELATIONAL_OPERATOR), // >
	GREATER_EQUAL(42, TokenDescription.RELATIONAL_OPERATOR), // >=
	LESS(43, TokenDescription.RELATIONAL_OPERATOR), // <
	LESS_EQUAL(44, TokenDescription.RELATIONAL_OPERATOR), // <=
	EQUIVALENT(45, TokenDescription.RELATIONAL_OPERATOR), // <>
	COMMA(46, TokenDescription.SPECIAL_SYMBOL), // ,
	SEMICOLON(47, TokenDescription.SPECIAL_SYMBOL), // ;
	LITERAL(48, TokenDescription.LITERAL), // ["][^"]*["]
	DOT(49, TokenDescription.SPECIAL_SYMBOL), // .
	DOUBLE_DOT(50, TokenDescription.SPECIAL_SYMBOL), // ..
	EOL(51, TokenDescription.EOL); // $

	/**
	 * O código de um token.
	 */
	private int code;

	/**
	 * A descrição de um token.
	 */
	private TokenDescription description;

}
