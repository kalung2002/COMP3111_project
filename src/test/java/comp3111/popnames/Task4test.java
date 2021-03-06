package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Task4test extends ApplicationTest {

	private Scene s;
	private TextArea t;
	private TextField DadName;
	private TextField MomName;
	private TextField DadYOB;
	private TextField MomYoB;
	private ToggleButton Algorbtn;
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

		MomName = (TextField)s.lookup("#tsk4namet");
		DadName = (TextField)s.lookup("#tsk4namei");
		MomYoB = (TextField)s.lookup("#tsk4yobt");
		DadYOB = (TextField)s.lookup("#tsk4yobi");
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		
	}
//	@Test
//	public void ts() {
////    	AnalyzeNames a = new AnalyzeNames();
////    	String name = a.getName(2019, 2192, "F");
////    	assertFalse(name.equals("Paul"));
//
////		Algorbtn = (ToggleButton)s.lookup("#T4X1");
////		sleep(100);
////		clickOn("#tabApp1");
////		MomYoB.setText("2000");
////		DadYOB.setText("2015");		
////		MomName.setText("SDSDDS");
////		DadName.setText("SSSS");
////		sleep(100);
////		Algorbtn.setSelected(true);
////		sleep(100);
////		clickOn("#tsk4ans");
//		sleep(100);
//		clickOn("#tabApp1");
//		Algorbtn = (ToggleButton)s.lookup("#T4X1");
//		MomYoB.setText("19991");
//		DadYOB.setText("20151");		
//		MomName.setText("SDSDDS");
//		DadName.setText("SSSS");
//		Algorbtn.setSelected(true);
//		sleep(100);
//		clickOn("#tsk4ans");
//	}
	@Test
	public void testT4X1_valid() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		MomYoB.setText("19991");
		sleep(100);
		DadYOB.setText("20151");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_tmbUpper() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("2020");
		sleep(100);
		DadYOB.setText("2000");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_tdbUpper() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("2019");
		sleep(100);
		DadYOB.setText("2020");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_tdbLower() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("2000");
		sleep(100);
		DadYOB.setText("1879");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_tmChar() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("-*#@@$#");
		sleep(100);
		DadYOB.setText("1880");		
		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_tdChar() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("1880");
		sleep(100);
		DadYOB.setText("!#!@!$!@!@#");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_dfdigit() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		MomYoB.setText("1880");
		sleep(100);
		DadYOB.setText("01999");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_mfdigit() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		MomYoB.setText("01880");
		sleep(100);
		DadYOB.setText("1999");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_range1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabApp1");
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		MomYoB.setText("111880");
		sleep(100);
		DadYOB.setText("1999");		
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void testT4X1_range2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabApp1");
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		sleep(100);
		MomYoB.setText("1999");
		sleep(100);
		DadYOB.setText("111880");
		sleep(100);
		MomName.setText("SDSDDS");
		sleep(100);
		DadName.setText("SSSS");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");

	}
	@Test
	public void test_check1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		clickOn("#tabApp1");
		sleep(100);
		MomYoB.setText("1999");
		sleep(100);
		DadYOB.setText("111880");	
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);		
		clickOn("#tsk4ans");
	}
	@Test
	public void test_check3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		Algorbtn = (ToggleButton)s.lookup("#T4X1");
		clickOn("#tabApp1");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");
	}
	@Test
	public void test_check4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		sleep(100);
//		Algorbtn = (ToggleButton)s.lookup("#T4X2");
		sleep(100);
		Algorbtn.setSelected(true);
		clickOn("#tsk4ans");
	}
	@Test
	public void test_check5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabApp1");
		Algorbtn = (ToggleButton)s.lookup("#T4X2");
		sleep(100);
		MomYoB.setText("1999");
		sleep(100);
		DadYOB.setText("2000");
		sleep(100);
		MomName.setText("Kenneth");
		sleep(100);
		DadName.setText("Desmond");
		sleep(100);
		Algorbtn.setSelected(true);
		sleep(100);
		clickOn("#tsk4ans");
		sleep(100);
		sleep(400);
	}
}