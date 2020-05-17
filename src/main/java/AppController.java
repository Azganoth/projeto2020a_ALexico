import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class AppController implements Initializable {

	@FXML
	private TextArea programSourceCode;

	@FXML
	private TableView<Token> programDescription;

	@FXML
	private TableColumn<Token, Integer> tokenCode;

	@FXML
	private TableColumn<Token, String> tokenValue;

	@FXML
	private TableColumn<Token, String> tokenDescription;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tokenCode.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getCode()).asObject());
		tokenValue
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
		tokenDescription.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
	}

	@FXML
	private void describeProgram() {
		Lexer lexer = new Lexer(programSourceCode.getText());
		programDescription.setItems(FXCollections.observableList(lexer.describeSourceCode()));
	}

}
