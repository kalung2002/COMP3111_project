package comp3111.popnames;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Taskc2 extends ApplicationTest {

	private Scene s;
	private TextArea t;

	private Button task2btnSummary;
	private Button task2btnTable;
	private Button task2btnBar;
	private Button task2btnPie;

	private TextField task2Startyear;
	private TextField task2Endyear;
	private TextField task2Kth;
	private TextField task2Gender;

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

		task2Startyear = (TextField) s.lookup("#task2Startyear");
		task2Endyear = (TextField) s.lookup("#task2Endyear");
		task2Kth = (TextField) s.lookup("#task2Kth");
		task2Gender = (TextField) s.lookup("#task2Gender");

	}

	@Test
	public void test1() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("M");
		sleep(100);
		clickOn("#task2btnSummary");
	}
	@Test
	public void test1i() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("F");
		sleep(100);
		clickOn("#task2btnSummary");
	}
	@Test
	public void test2() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("M");
		sleep(100);
		clickOn("#task2btnTable");
	}
	@Test
	public void test2i() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("F");
		sleep(100);
		clickOn("#task2btnTable");
	}

	@Test
	public void test3() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("M");
		sleep(100);
		clickOn("#task2btnBar");
	}
	@Test
	public void test3i() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("F");
		sleep(100);
		clickOn("#task2btnBar");
	}
	@Test
	public void test4() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("M");
		sleep(100);
		clickOn("#task2btnPie");
	}
	@Test
	public void test4i() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		task2Startyear.setText("2000");
		task2Endyear.setText("2010");
		task2Kth.setText("5");
		task2Gender.setText("F");
		sleep(100);
		clickOn("#task2btnPie");
	}

	@Test
	public void teste() {
		clickOn("#tabReport2");
		sleep(100);
		clickOn("#task2Gender");
		sleep(100);

		
		task2Startyear.setText("2000");
		clickOn("#task2Gender");
		task2Startyear.setText("1600");
		clickOn("#task2Gender");
		task2Startyear.setText("200");
		clickOn("#task2Gender");
		task2Startyear.setText("20000");
		task2Startyear.setText("2000");
		clickOn("#task2Gender");

		task2Endyear.setText("2010");
		clickOn("#task2Gender");
		task2Endyear.setText("1999");
		clickOn("#task2Gender");
		task2Endyear.setText("1600");
		clickOn("#task2Gender");
		task2Endyear.setText("201");
		clickOn("#task2Gender");
		task2Endyear.setText("20100");
		task2Endyear.setText("2010");
		clickOn("#task2Gender");

		task2Kth.setText("5");
		clickOn("#task2Gender");
		task2Kth.setText("0");
		clickOn("#task2Gender");
		task2Kth.setText("-1");
		clickOn("#task2Gender");
		task2Kth.setText("99999");
		task2Kth.setText("5");
		clickOn("#task2Gender");

		task2Gender.setText("M");
		clickOn("#task2Gender");
		task2Gender.setText("F");
		clickOn("#task2Gender");
		task2Gender.setText("X");
		clickOn("#task2Gender");
		task2Gender.setText("");
		task2Gender.setText("M");
		clickOn("#task2Gender");

		sleep(100);
		clickOn("#task2btnPie");
	}

}
