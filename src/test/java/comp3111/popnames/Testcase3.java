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

public class Testcase3 extends ApplicationTest {
	private Scene s;
	private TextArea t;
	private ToggleButton btn;

	private Button tsk3btn4;
	private Button tsk3btn3;
	private Button tsk3btn2;
	private Button tsk3btn1;
	private TextArea tsk3info;
	private TextField tsk3yois;
	private TextField tsk3yoe;
	private TextField tsk3name;
	private TextField tsk3gender;

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
		tsk3gender = (TextField) s.lookup("#tsk3gender");
		tsk3name = (TextField) s.lookup("#tsk3name");
		tsk3yoe = (TextField) s.lookup("#tsk3yoe");
		tsk3yois = (TextField) s.lookup("#tsk3yois");

//		tsk3btn4 = (Button) s.lookup("#tsk3btn4");
//		tsk3btn3 = (Button) s.lookup("#tsk3btn3");
//		tsk3btn2 = (Button) s.lookup("#tsk3btn2");
//		tsk3btn1 = (Button) s.lookup("#tsk3btn1");
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
		clickOn("#tabReport3");
		//
		clickOn("#tsk3yoe");
		tsk3yois.setText("");
		clickOn("#tsk3yoe");
		tsk3yois.setText("2000");
		clickOn("#tsk3yoe");
		tsk3yois.setText("AAAA");
		clickOn("#tsk3yoe");
		tsk3yois.setText("20000");
		clickOn("#tsk3yoe");
		tsk3yois.setText("1999");
		clickOn("#tsk3yoe");
		//
		tsk3yoe.setText("");
		clickOn("#tsk3yoe");
		tsk3yoe.setText("2010");
		clickOn("#tsk3yoe");
		tsk3yoe.setText("AAAA");
		clickOn("#tsk3yoe");
		tsk3yoe.setText("20000");
		clickOn("#tsk3yoe");
		tsk3yoe.setText("1998");
		clickOn("#tsk3yoe");
		tsk3yoe.setText("2010");
		clickOn("#tsk3yoe");
		//
		tsk3name.setText("");
		clickOn("#tsk3yoe");
		tsk3name.setText("Mmmm");
		clickOn("#tsk3yoe");
		tsk3name.setText("Mmmm03");
		clickOn("#tsk3yoe");
		tsk3name.setText("Mmmm035464646654654645465");
		clickOn("#tsk3yoe");
		tsk3name.setText("M");
		clickOn("#tsk3yoe");
		tsk3name.setText("Mary");
		clickOn("#tsk3yoe");
		tsk3name.setText("xxxx");
		clickOn("#tsk3yoe");

		//
		tsk3gender.setText("");
		clickOn("#tsk3yoe");
		tsk3gender.setText("B");
		clickOn("#tsk3yoe");

		tsk3gender.setText("M");
		clickOn("#tsk3yoe");
		tsk3gender.setText("F");
		clickOn("#tsk3yoe");
		//
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn4");
	}

	@Test
	public void test3() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Mary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn4");
	}

	@Test
	public void test3e() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Maaary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn4");
	}

	@Test
	public void test4() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Mary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn3");

	}

	@Test
	public void test4e() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Maaary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn3");

	}

	@Test
	public void test5() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Mary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn2");
	}@Test
	public void test5e() {
		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Maaary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn2");
	}

	@Test
	public void test6() {

		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Mary");
		tsk3gender.setText("F");
		sleep(100);
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn1");
	}	@Test
	public void test6e() {

		sleep(100);
		clickOn("#tabReport3");
		tsk3yois.setText("2000");
		tsk3yoe.setText("2010");
		tsk3name.setText("Maaary");
		tsk3gender.setText("F");
		sleep(100);
		
		clickOn("#tsk3yoe");
		clickOn("#tsk3btn1");
	}

}
