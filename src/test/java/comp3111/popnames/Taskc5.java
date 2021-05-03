package comp3111.popnames;

import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Taskc5 extends ApplicationTest {
	private Scene s;
	private TextArea t;
	private ToggleButton btn;

	private TextField tsk6namei;
	private TextField tsk6namet;
	private TextField tsk6yob;
	private Button tsk6ans;
	
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/ui.fxml"));
		VBox root = (VBox) loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Popular Names");
		stage.show();
		s = scene;
		t = (TextArea) s.lookup("#textAreaConsole");
		tsk6namei = (TextField) s.lookup("#tsk6namei");
		tsk6namet = (TextField) s.lookup("#tsk6namet");
		tsk6yob = (TextField) s.lookup("#tsk6yob");

	}
}
