import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppFX extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("App.fxml")));
			stage.setScene(scene);
			stage.setTitle("Analisador léxico para a linguagem LMS");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("Icon.png")));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
