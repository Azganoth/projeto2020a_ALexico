import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Representa um token da linguagem LMS.
 */
@AllArgsConstructor
@Getter
@ToString
public class Token {

	/**
	 * O tipo de um token.
	 */
	private TokenType type;

	/**
	 * O valor de um token.
	 */
	private String value;

	public int getCode() {
		return this.type.getCode();
	}

	public String getDescription() {
		return this.type.getDescription().toString();
	}

}
