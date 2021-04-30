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




//	@Test
//	public void testButtonTaskoneTrue() {
//		clickOn("#tabReport1");
//		
//		clickOn("#Task1button");
////		String s1 = t.getText();
////		System.out.println("how are");
////		clickOn("#Task1button");
////		String s2 = t.getText();
////		assertTrue(s1.equals(s2));
//
//	}

	@Test
	public void testinput() {
		clickOn("#tabReport1");
		sleep(100);
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
		clickOn("#tabReport1");
		sleep(100);


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
		clickOn("#tabReport1");
		sleep(100);
		topN.setText("5");
		String s1 = topN.getText();
		
		clickOn("#tabReport1");
		String s2 = topN.getText();
		int x = Integer.parseInt(s1);
		assertTrue(x == 5);
		
		x = Integer.parseInt(s2);
		assertTrue(x == 5);
		assertTrue(s1.equals(s2));
	}
	@Test
	public void test_getTotalOccur() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		AnalyzeNames a = new AnalyzeNames();
		int test = a.getTotalOccur(2010, "M");
		assertTrue(test == 1913851);
		
	}
	@Test
	public void test_getNumber() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		AnalyzeNames a = new AnalyzeNames();
		int test = a.getNumber(2010,"F",1);
		assertTrue(test == 22883);
	}
	@Test
	public void test_Barchart() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("5");
		year.setText("2000");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("11");
		year.setText("2000");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		topN.setText("-1");
		year.setText("2000");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test_2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("*1");
		year.setText("2000");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("01");
		year.setText("2000");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("2020");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("1879");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test6() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("01889");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Barchart_test7() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("******");
		clickOn("#Task1BarButton");
	}
	@Test
	public void test_Piechart() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("0");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("11");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("-1");
		year.setText("2019");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("01999");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("1879");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_Piechart_test6() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("2020");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_getSummary() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("2010");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_Table() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("2010");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("20100");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("2020");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("-1");
		year.setText("2010");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("-1");
		year.setText("2010");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("1879");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1");
		year.setText("01880");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_TableInvalid6() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("01");
		year.setText("1880");
		clickOn("#Task1TableButton");
	}
	@Test
	public void test_getSummaryInvalid() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("2-2");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("-10");
		year.setText("2000");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("010");
		year.setText("2000");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("1111111");
		year.setText("2000");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("2020");
		year.setText("2000");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("1879");
		year.setText("2000");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid6() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("1879");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid7() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("1888");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid8() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("01880");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_getSummaryInvalid9() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("10");
		year.setText("we**`1");
		clickOn("#buttonSummary");
	}
	@Test
	public void test_PiechartInvalid() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("11");
		year.setText("2010");
		clickOn("#Task1PieButton");
		topN.setText("11");
		year.setText("2010");
		clickOn("#tabReport1");
	}
	@Test
	public void test_PiechartInvalid1() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("0");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}	
	@Test
	public void test_PiechartInvalid2() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("-1");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_PiechartInvalid3() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("2020");
		year.setText("2010");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_PiechartInvalid4() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1999");
		year.setText("0123");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_PiechartInvalid5() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		clickOn("#tabReport1");
		topN.setText("1999");
		year.setText("2020");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_PiechartInvalid6() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1999");
		year.setText("1879");
		clickOn("#Task1PieButton");
	}
	@Test
	public void test_PiechartInvalid7() {
//    	AnalyzeNames a = new AnalyzeNames();
//    	String name = a.getName(2019, 2192, "F");
//    	assertFalse(name.equals("Paul"));
		sleep(100);
		clickOn("#tabReport1");
		topN.setText("1999");
		year.setText("``````");
		clickOn("#Task1PieButton");
	}
}