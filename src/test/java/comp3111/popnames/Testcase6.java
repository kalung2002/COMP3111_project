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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Testcase6 extends ApplicationTest {
	private Scene s;
	private TextArea t;
	private ToggleButton btn;

	private TextField tsk6namei;
	private TextField tsk6namet;
	private TextField tsk6yob;
	private Button tsk6ans;

//	private RadioButton tsk6tif;
//	private RadioButton tsk6tim;
//	private RadioButton tsk6iaf;
//	private RadioButton tsk6iam;
//
//	
//	private ToggleButton tsk6ios;
//	private ToggleButton tsk6iys;
//
//	
//	private ToggleButton T6X1;
//	private ToggleButton T6X2;

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

	@Test
	public void test1() {
		sleep(100);
		clickOn("#tabReport1");
		clickOn("#tabReport2");
		clickOn("#tabReport3");

		clickOn("#tabApp1");
		clickOn("#tabApp2");
		clickOn("#tabApp3");
		sleep(100);
	}

	@Test
	public void test2() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X1");
		clickOn("#T6X1");
		clickOn("#T6X2");
		sleep(100);
		clickOn("#tsk6tif");
		clickOn("#tsk6tim");
		clickOn("#tsk6iaf");
		clickOn("#tsk6iam");
		sleep(100);
		clickOn("#tsk6ios");
		clickOn("#tsk6ios");
		clickOn("#tsk6iys");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("2000");

		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test3() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X2");
		clickOn("#tsk6tif");
		clickOn("#tsk6iaf");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test4() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X2");
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Maaary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test5() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X2");
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Maaary");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test6() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X2");
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("20000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test7() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#T6X2");
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("AAA");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test8() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		clickOn("#T6X2");
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}@Test
	public void test9() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		clickOn("#T6X2");
		tsk6namei.setText("Mary");
		tsk6namet.setText("Ken");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}
	@Test
	public void test10() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Mary");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}@Test
	public void test11() {
		sleep(100);
		clickOn("#tabApp3");
		sleep(100);
		clickOn("#tsk6tim");
		clickOn("#tsk6iam");
		sleep(100);
		tsk6namei.setText("Mary");
		tsk6namet.setText("Ken");
		tsk6yob.setText("2000");
		clickOn("#tsk6yob");
		sleep(1000);
		clickOn("#tsk6ans");
	}

}
