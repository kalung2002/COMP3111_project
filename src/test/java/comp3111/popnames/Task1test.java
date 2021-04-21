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
import javafx.fxml.FXMLLoader;

public class Task1test extends ApplicationTest {

	private Scene s;
	private TextArea t;
	private TextField year;
	private TextField topN;
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
		year = (TextField)s.lookup("#Text1_year");
		topN = (TextField)s.lookup("#Text1_name");
	}


	@Test
	public void testButtonTaskoneTrue() {
		clickOn("#tabReport1");
		
		clickOn("#Task1button");
		String s1 = t.getText();
		System.out.println("how are");
		clickOn("#Task1button");
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
		
		
	}
	@Test
	public void testinput() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 2192, "F");
    	assertFalse(name.equals("Paul"));
		
		
	}
	@Test
	public void test_yearinput() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
//		
		year.setText("2010");
		String s1 = year.getText();
		int x = Integer.parseInt(s1);
		assertTrue(x > 0);
	}
	@Test
	public void test_Ninput() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
//		
		topN.setText("1");
		String s1 = topN.getText();
		int x = Integer.parseInt(s1);
		assertTrue(x > 0);
	}

}