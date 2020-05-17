import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Representa uma descrição de um token da linguagem LMS.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TokenDescription {

	SPECIAL_SYMBOL("Símbolo especial"), //
	RESERVED_WORD("Palavra reservada"), //
	IDENTIFIER("Identificador"), //
	LITERAL("Literal"), //
	NUMBER("Número inteiro"), //
	NEGATION_OPERATOR("Operador de negação"), //
	MULTI_DIV_OPERATOR("Operador de multiplicação/divisão"), //
	LOGIC_OPERATOR("Operador lógico"), //
	ADD_SUB_OPERATOR("Operador de adição/subtração"), //
	RELATIONAL_OPERATOR("Operador relacional"), //
	ASSIGNMENT("Atribuição"), //
	EOL("Fim de arquivo"); //

	/**
	 * A descrição de um token.
	 */
	private String description;

	@Override
	public String toString() {
		return this.description;
	}

}
