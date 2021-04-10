package comp3111.popnames;

import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class Testcase6 extends ApplicationTest  {
	private Scene s;
	private TextArea t;
	private ToggleButton btn;
	
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
	}
	@Test
	public void testButtonT6X1() {	
		clickOn("#tabApp3");
//		clickOn("#T6X1");
		clickOn("#task_six_btn_getresult");
		sleep(1000);
		String s1 = t.getText();
		
		btn=(ToggleButton)s.lookup("#T6X1");
		String s2 = btn.getText();
		System.out.println(s1);
		System.out.println(s2);
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testButtonT6X2() {	
		clickOn("#tabApp3");
		clickOn("#T6X2");
		clickOn("#task_six_btn_getresult");
		sleep(1000);
		String s1 = t.getText();
		
		btn=(ToggleButton)s.lookup("#T6X2");
		String s2 = btn.getText();
		System.out.println(s1);
		System.out.println(s2);
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testButtonT6NN() {	
		clickOn("#tabApp3");
		clickOn("#T6X1");
		clickOn("#task_six_btn_getresult");
		sleep(1000);
		String s1 = t.getText();
		
		btn=(ToggleButton)s.lookup("#T6X1");
		String s2 = btn.getText();
		System.out.println(s1);
		System.out.println(s2);
		assertFalse(s1.equals(s2));
	}

}
