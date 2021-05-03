package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class JavaFXTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	private TextField textfieldNameF;
	private TextField textfieldYear;
	private TextField textfieldNameM;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
		textfieldNameF=(TextField) s.lookup("#textfieldNameF");
		textfieldYear=(TextField) s.lookup("#textfieldYear");
		textfieldNameM=(TextField) s.lookup("#textfieldNameM");
	}

    
	@Test
	public void testButtonRankTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		sleep(100);
		String s1 = t.getText();
		clickOn("#buttonRankM");
		sleep(100);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	public void testButtonRankFalse() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		sleep(100);
		String s1 = t.getText();
		clickOn("#buttonRankF");
		sleep(100);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
	}
	
	
	@Test
	public void testTextAreaConsole() {	
		t.setText("David");
		String s = t.getText();
		assertTrue(s.equals("David"));
	}
	@Test
	public void test1() {	
			textfieldNameF.setText("Mary");
			textfieldNameM.setText("Mary");
			textfieldYear.setText("2000");
			sleep(100);
			clickOn("#buttonRankM");
			clickOn("#buttonRankF");
			clickOn("#buttonTopM");
			clickOn("#buttonTopF");
			clickOn("#buttonSummary");
	}@Test
	public void test2() {	
		textfieldNameF.setText("Maaary");
		textfieldNameM.setText("Maaary");
		textfieldYear.setText("2000");
		sleep(100);
		clickOn("#buttonRankM");
		clickOn("#buttonRankF");
		clickOn("#buttonTopM");
		clickOn("#buttonTopF");
		clickOn("#buttonSummary");
}
		
}
