/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;

import java.io.IOException;

import org.apache.commons.lang3.math.NumberUtils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.Toolkit;
public class Controller {
	@FXML
	private RowConstraints GRID0;

	@FXML
	private RowConstraints GRID1;

	@FXML
	private Tab tabTaskZero;

	@FXML
	private TextField textfieldNameF;

	@FXML
	private TextField textfieldYear;

	@FXML
	private Button buttonRankM;

	@FXML
	private TextField textfieldNameM;

	@FXML
	private Button buttonRankF;

	@FXML
	private Button buttonTopM;

	@FXML
	private Button buttonTopF;

	@FXML
	private Button buttonSummary;

//	@FXML
//	private Tab tabReport1;
//
//	@FXML
//	private Tab tabReport2;
//
//	@FXML
//	private Tab tabReport3;
//
//	@FXML
//	private Tab tabApp1;
//
//	@FXML
//	private Tab tabApp2;
//
//	@FXML
//	private Tab tabApp3;
//	@FXML
//	private ToggleGroup T1;
//	@FXML
//	private ToggleGroup T11;
//	@FXML
//	private ToggleGroup T111;

	@FXML
	private TextArea textAreaConsole;
	@FXML
	private TabPane MENU_GROUP;

	private Alert getAlert(String title) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setGraphic(null);
		alert.setContentText(null);
		return alert;

	}

	private void Display_helper(double d, double e) {
		GRID0.setPercentHeight(d);
		GRID1.setPercentHeight(e);
	}

	@FXML
	void onselect() {
		Display_helper(50, 50);
		Tab selected = (Tab) MENU_GROUP.getSelectionModel().getSelectedItem();
		if (selected == null) {
			return;
		}
		if (textAreaConsole != null) {
			textAreaConsole.clear();
		}
		System.out.println(selected.getText());
		switch (selected.getText()) {
		case "Task Zero":
			Display_helper(50, 50);
			break;

		case "Reporting 1":
			Display_helper(40, 60);
			break;
		case "Reporting 2":
			Display_helper(50, 50);
			break;
		case "Reporting 3":
			Display_helper(40, 60);
			break;

		case "Application 1":
			Display_helper(50, 50);
			break;

		case "Application 2":
			Display_helper(60, 40);
			break;

		case "Application 3":
			Display_helper(50, 50);
			break;
		}
	}

	@FXML
	void initialize() {
		// change setting immediately after application launched
		// change style here since some fxml setting will be override by JMetro
		tsk4progress.setProgress(-1);

		Task1PieButton.setStyle("-fx-font-size:20");
		Task1TableButton.setStyle("-fx-font-size:20");
		Task1Summarybutton.setStyle("-fx-font-size:20");
		Task1BarButton.setStyle("-fx-font-size:20");

	}

	/**
	 * Task Zero To be triggered by the "Summary" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doSummary() {
		int year = Integer.parseInt(textfieldYear.getText());
		String oReport = AnalyzeNames.getSummary(year);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Rank (female)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doRankF() {
		String oReport = "";
		String iNameF = textfieldNameF.getText();
		int iYear = Integer.parseInt(textfieldYear.getText());
		int oRank = AnalyzeNames.getRank(iYear, iNameF, "F");
		if (oRank == -1)
			oReport = String.format("The name %s (female) has not been ranked in the year %d.\n", iNameF, iYear);
		else
			oReport = String.format("Rank of %s (female) in year %d is #%d.\n", iNameF, iYear, oRank);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Rank (male)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doRankM() {
		String oReport = "";
		String iNameM = textfieldNameM.getText();
		int iYear = Integer.parseInt(textfieldYear.getText());
		int oRank = AnalyzeNames.getRank(iYear, iNameM, "M");
		if (oRank == -1)
			oReport = String.format("The name %s (male) has not been ranked in the year %d.\n", iNameM, iYear);
		else
			oReport = String.format("Rank of %s (male) in year %d is #%d.\n", iNameM, iYear, oRank);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Top 5 (female)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopF() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Top 5 (male)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopM() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task One To be triggered get result button
	 * 
	 * @throws IOException
	 * 
	 */

	@FXML
	private TextField Text1_year;// for task 1
	@FXML
	private TextField Text1_name;// for task 1

	@FXML
	private Button Task1PieButton;// for task 1
	@FXML
	private Button Task1TableButton;// for task 1
	@FXML
	private Button Task1Summarybutton;// for task 1
	@FXML
	private Button Task1BarButton;// for task 1

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
	// generate Summary
	void Generate_BarChart() throws IOException {


		boolean name_isNum = Text1_name.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		boolean year_isNum = Text1_year.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		if (Text1_year.getText().isEmpty())
			return;
		if (Text1_name.getText().isEmpty())
			return;
		if (name_isNum == false) {
			return;
		}
		if (year_isNum == false) {
			return;
		}
		int iYear = Integer.parseInt(Text1_year.getText());
		int topN = Integer.parseInt(Text1_name.getText());
		
		if(iYear>2019 || iYear<1880) {
			return;
		}
		if(topN < 1 || topN > 10) {
			return;
		}
		// Generate BarChart
		Stage stage;
		stage = new Stage();
		stage.setTitle("Bar Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("Top " + Text1_name.getText() + " Names in Year " + Text1_year.getText());
		xAxis.setLabel("Names");
		yAxis.setLabel("Total Number of Occurence");

		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Female");
		series1.setName("Male");
		for (int i = 1; i <= topN; i++) {
			series1.getData()
					.add(new XYChart.Data(AnalyzeNames.getName(iYear, i, "M"), AnalyzeNames.getNumber(iYear, "M", i)));
			series2.getData()
					.add(new XYChart.Data(AnalyzeNames.getName(iYear, i, "F"), AnalyzeNames.getNumber(iYear, "F", i)));
		}
		Scene scene = new Scene(bc, 800, 600);
		bc.getData().addAll(series1, series2);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void Generate_PieChart() {

		if (Text1_year.getText().isEmpty())
			return;
		if (Text1_name.getText().isEmpty())
			return;
		boolean name_isNum = Text1_name.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		boolean year_isNum = Text1_year.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		if (name_isNum == false) {
			return;
		}
		if (year_isNum == false) {
			return;
		}
		int iYear = Integer.parseInt(Text1_year.getText());
		int topN = Integer.parseInt(Text1_name.getText());
		
		if(iYear>2019 || iYear<1880) {
			return;
		}
		if(topN < 1 || topN > 10) {
			return;
		}
		
		Scene scene = new Scene(new Group());
		Stage stage;
		stage = new Stage();
		stage.setTitle("Imported Fruits");
		stage.setWidth(1000);
		stage.setHeight(500);

		ObservableList<PieChart.Data> pieChartData_M = FXCollections.observableArrayList();
		ObservableList<PieChart.Data> pieChartData_F = FXCollections.observableArrayList();
		for (int i = 1; i <= topN; i++) {

			pieChartData_M
					.add(new PieChart.Data(AnalyzeNames.getName(iYear, i, "M"), AnalyzeNames.getNumber(iYear, "M", i)));
			pieChartData_F
					.add(new PieChart.Data(AnalyzeNames.getName(iYear, i, "F"), AnalyzeNames.getNumber(iYear, "F", i)));
		}
		final PieChart chart_M = new PieChart(pieChartData_M);
		final PieChart chart_F = new PieChart(pieChartData_F);
		chart_M.setTitle("Top " + Text1_name.getText() + " names (Males) in " + Text1_year.getText());
		chart_F.setTitle("Top " + Text1_name.getText() + " names (Females) in " + Text1_year.getText());
		chart_M.setLayoutX(500);
		((Group) scene.getRoot()).getChildren().add(chart_M);
		((Group) scene.getRoot()).getChildren().add(chart_F);

		stage.setScene(scene);
		stage.show();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	void Generate_Table() {
		
		if (Text1_year.getText().isEmpty())
			return;
		if (Text1_name.getText().isEmpty())
			return;
		boolean name_isNum = Text1_name.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		boolean year_isNum = Text1_year.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		if (name_isNum == false) {
			return;
		}
		if (year_isNum == false) {
			return;
		}
		TableView<Person> M_table = new TableView<Person>();
		TableView<Person> F_table = new TableView<Person>();

		final ObservableList<Person> M_data = FXCollections.observableArrayList();
		final ObservableList<Person> F_data = FXCollections.observableArrayList();


		int iYear = Integer.parseInt(Text1_year.getText());
		int topN = Integer.parseInt(Text1_name.getText());
		
		if(iYear>2019 || iYear<1880) {
			return;
		}
		if(topN < 1 || topN > 10) {
			return;
		}

		for (int i = 1; i <= topN; i++) {

			float Malepercent = (float) AnalyzeNames.getNumber(iYear, "M", i) / AnalyzeNames.getTotalOccur(iYear, "M");
			float Femalepercent = (float) AnalyzeNames.getNumber(iYear, "F", i)/ AnalyzeNames.getTotalOccur(iYear, "F");
			String Mpercent = String.valueOf(Malepercent * 100) + "%";
			String Fpercent = String.valueOf(Femalepercent * 100) + "%";
			F_data.add(new Person(AnalyzeNames.getName(iYear, i, "F"),
					String.valueOf(AnalyzeNames.getNumber(iYear, "F", i)), Fpercent));
			M_data.add(new Person(AnalyzeNames.getName(iYear, i, "M"),
					String.valueOf(AnalyzeNames.getNumber(iYear, "M", i)), Mpercent));
		}
		Scene scene = new Scene(new Group());
		Stage stage = new Stage();
		stage.setTitle("Top " + Text1_name.getText() + " Names in " + Text1_year.getText());
		stage.setWidth(1100);
		stage.setHeight(500);
		// for female
		final Label label = new Label("Female");
		label.setFont(new Font("Arial", 20));
		// for male
		final Label mlabel = new Label("Male");
		mlabel.setFont(new Font("Arial", 20));

		M_table.setEditable(true);
		F_table.setEditable(true);

		TableColumn<Person, String> M_NameCol = new TableColumn<Person, String>("Name");
		TableColumn<Person, String> F_NameCol = new TableColumn<Person, String>("Name");
		M_NameCol.setMinWidth(100);
		M_NameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		F_NameCol.setMinWidth(100);
		F_NameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));

		TableColumn<Person, String> M_GenderCol = new TableColumn<Person, String>("Occurrences");
		TableColumn<Person, String> F_GenderCol = new TableColumn<Person, String>("Occurrences");
		M_GenderCol.setMinWidth(200);
		M_GenderCol.setCellValueFactory(new PropertyValueFactory<Person, String>("occurr"));
		F_GenderCol.setMinWidth(200);
		F_GenderCol.setCellValueFactory(new PropertyValueFactory<Person, String>("occurr"));

		TableColumn<Person, String> M_NumberCol = new TableColumn<Person, String>("Percentage");
		TableColumn<Person, String> F_NumberCol = new TableColumn<Person, String>("Percentage");
		M_NumberCol.setMinWidth(200);
		M_NumberCol.setCellValueFactory(new PropertyValueFactory<Person, String>("percent"));
		F_NumberCol.setMinWidth(200);
		F_NumberCol.setCellValueFactory(new PropertyValueFactory<Person, String>("percent"));

		M_table.setItems(M_data);
		F_table.setItems(F_data);

		M_table.getColumns().addAll(M_NameCol, M_GenderCol, M_NumberCol);
		F_table.getColumns().addAll(F_NameCol, F_GenderCol, F_NumberCol);

		final VBox mbox = new VBox();
		mbox.setSpacing(5);
		mbox.setPadding(new Insets(10, 0, 0, 10));
		mbox.getChildren().addAll(mlabel, M_table);

		((Group) scene.getRoot()).getChildren().addAll(mbox);

		final VBox fbox = new VBox();
		fbox.setSpacing(5);
		fbox.setPadding(new Insets(10, 0, 0, 10));
		fbox.setLayoutX(550);
		fbox.getChildren().addAll(label, F_table);
		((Group) scene.getRoot()).getChildren().addAll(fbox);
//    	        F_table.setLayoutX(550);
//    	        M_table.setLayoutY(30);
//    	        ((Group) scene.getRoot()).getChildren().add(label);
//    	        ((Group) scene.getRoot()).getChildren().add(M_table);
//    	        ((Group) scene.getRoot()).getChildren().add(F_table);    	 
    	        stage.setScene(scene);
    	        stage.show();
    }    
    @FXML
    void  Generate_Summary(){
		if (Text1_year.getText().isEmpty())
			return;
		if (Text1_name.getText().isEmpty())
			return;
		boolean name_isNum = Text1_name.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		boolean year_isNum = Text1_year.getText().chars().allMatch(c -> c >= 48 && c <= 57);
		if (name_isNum == false) {
			return;
		}
		if (year_isNum == false) {
			return;
		}
		
    	String oReport = "";
    	int iYear = Integer.parseInt(Text1_year.getText()); // get the year of the user input
    	float Malepercent=   (float)AnalyzeNames.getNumber(iYear,"M",1) / AnalyzeNames.getTotalOccur(iYear,"M");
    	float Femalepercent = (float)  AnalyzeNames.getNumber(iYear,"F",1) / AnalyzeNames.getTotalOccur(iYear,"F");
    	oReport = String.format("Summary of Results in the year %d:\n", iYear);
    	
    	oReport += String.format("--- %s (Male) is the most popular name with the number of occurences of %.2f \n",AnalyzeNames.getName(iYear, 1, "M"),Malepercent*100);
    	oReport += String.format("--- %s (Female) is the most popular name with the number of occurences of %.2f \n",AnalyzeNames.getName(iYear, 1, "F"), Femalepercent*100);
    	textAreaConsole.setText(oReport);    	
    }
    public static class Person {
    	 
        private final SimpleStringProperty name;
        private final SimpleStringProperty occurr;
        private final SimpleStringProperty percent;
 
        private Person(String fName, String Gender, String Number) {
            this.name = new SimpleStringProperty(fName);
            this.occurr = new SimpleStringProperty(Gender);
            this.percent = new SimpleStringProperty(Number);
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String fName) {
        	name.set(fName);
        }
 
        public String getOccurr() {
            return occurr.get();
        }
 
        public void setOccurr(String fName) {
        	occurr.set(fName);
        }
 
        public String getPercent() {
            return percent.get();
        }
 
        public void setPercent(String fName) {
        	percent.set(fName);
        }
    }


	

	/**
	 * Task three To be triggered by get result button or Anything related to tsk3
	 * will code here
	 * 
	 */
	@FXML
	private Button tsk3btn4;
	@FXML
	private Button tsk3btn3;
	@FXML
	private Button tsk3btn2;
	@FXML
	private Button tsk3btn1;
	@FXML
	private TextArea tsk3info;
	@FXML
	private TextField tsk3yois;
	@FXML
	private TextField tsk3yoe;
	@FXML
	private TextField tsk3name;
	@FXML
	private TextField tsk3gender;

	@FXML
	void tsk3in() {
//		System.out.println("tsk3");
		tsk3btn1.setDisable(true);
		tsk3btn2.setDisable(true);
		tsk3btn3.setDisable(true);
		tsk3btn4.setDisable(true);
		boolean isvalid = true;
		String output = "input check:\n";

		String years = tsk3yois.getText();
		String yeare = tsk3yoe.getText();
		String name = tsk3name.getText();
		String gender = tsk3gender.getText();
		if (years.isBlank()) {
			isvalid = false;
			output += "Please input starting year\n";
		} else if (!NumberUtils.isCreatable(years)) {// if isn't number
			isvalid = false;
			output += "Please input a valid number\n";
		} else {
			int a = Integer.parseInt(years);
			if (a < 1880 || a > 2019) {
				isvalid = false;
				output += "Please input year within range\n";

			}

		}

		if (yeare.isBlank()) {
			isvalid = false;
			output += "Please input end year\n";
		} else if (!NumberUtils.isCreatable(yeare)) {// if isn't number
			isvalid = false;
			output += "Please input a valid number\n";
		} else {
			int b = Integer.parseInt(yeare);
			if (b < 1880 || b > 2019) {
				isvalid = false;
				output += "Please input year within range\n";
			}

		}

		if (isvalid) {// check start year and end year
			int a = Integer.parseInt(years);
			int b = Integer.parseInt(yeare);
			if (b < a) {
				isvalid = false;

				output += Integer.toString(a) + '>';
				output += Integer.toString(b) + ' ';
				output += "error:start year is greater than end year\n";
			}
		}

		if (name.isBlank()) {
			isvalid = false;
			output += "Please input the name of interest\n";
		} else if (!name.chars().allMatch(Character::isLetter)) {
			isvalid = false;
			output += "Please input a valid name(only character)\n";
		} else if (name.length() > 15 || name.length() < 2) {
			isvalid = false;
			output += "Please input a valid name(2~15 characters)\n";

		}

		if (gender.isBlank()) {
			isvalid = false;
			output += "Please input gender\n";
		} else if (!(gender.equals("M") || gender.equals("F"))) {
			isvalid = false;
			output += "Please input valid gender(M/F)\n";
		}

		if (textAreaConsole != null) {
			textAreaConsole.clear();
		}

		if (isvalid) {// if all pass release the button

			textAreaConsole.setText("input check done\nclick on the buttons to get report");
			tsk3btn1.setDisable(false);
			tsk3btn2.setDisable(false);
			tsk3btn3.setDisable(false);
			tsk3btn4.setDisable(false);
		} else {// else split error message
			textAreaConsole.setText(output);
		}
	}

	@FXML
	void tsk3brcht() {// generate and popup barchart
		String years = tsk3yois.getText();
		String yeare = tsk3yoe.getText();
		String name = tsk3name.getText();
		String gender = tsk3gender.getText();
		int start_year = Integer.parseInt(years);
		int end_year = Integer.parseInt(yeare);
		boolean existdata = false;
		for (int i = start_year; i <= end_year; i++) {
			if (AnalyzeNames.tsk3csv_find_name_by_year(i, name, gender) >= 0) {
				existdata = true;
			}
		}
		if(!existdata) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Data not found error");
			alert.setContentText("Ooops, the information you entered has no record in our database");
			alert.showAndWait();
			return;
		}

		final CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("year");

		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("occurance");

		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("bar chart of birth in specific name in a period");

		XYChart.Series<String, Number> dataseries = new XYChart.Series();
		dataseries.setName("year");
		for (int i = start_year; i <= end_year; i++) {
			dataseries.getData().add(
					new XYChart.Data(Integer.toString(i), AnalyzeNames.tsk3csv_find_name_by_year(i, name, gender)));
		}

		bc.getData().add(dataseries);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(bc, 0, 0);

//		String a =Integer.toString(AnalyzeNames.tsk3csv_find_name_by_year(start_year,name,gender));

		Alert alert = getAlert("bar chart");

		alert.getDialogPane().setContent(expContent);
		alert.showAndWait();
		
	}

	@FXML
	void tsk3lncht() {

		String years = tsk3yois.getText();
		String yeare = tsk3yoe.getText();
		String name = tsk3name.getText();
		String gender = tsk3gender.getText();
		int start_year = Integer.parseInt(years);
		int end_year = Integer.parseInt(yeare);
		boolean existdata = false;
		for (int i = start_year; i <= end_year; i++) {
			if (AnalyzeNames.tsk3csv_find_name_by_year(i, name, gender) >= 0) {
				existdata = true;
			}
		}
		if(!existdata) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Data not found error");
			alert.setContentText("Ooops, the information you entered has no record in our database");
			alert.showAndWait();
			return;
		}
		
		final NumberAxis xAxis = new NumberAxis(start_year-2,end_year+2,2);
		xAxis.setLabel("year");

		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("occurance");
		
		LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
		lc.setTitle("bar chart of birth in specific name in a period");
		
		Series<Number, Number> dataseries = new XYChart.Series<Number, Number>(); 
		dataseries.setName("Year"); 
		for (int i = start_year; i <= end_year; i++) {
			dataseries.getData().add(
					new XYChart.Data(i, AnalyzeNames.tsk3csv_find_name_by_year(i, name, gender)));
		}

		
		lc.getData().add(dataseries);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(lc, 0, 0);

//		String a =Integer.toString(AnalyzeNames.tsk3csv_find_name_by_year(start_year,name,gender));

		Alert alert = getAlert("line chart");

		alert.getDialogPane().setContent(expContent);
		alert.showAndWait();
		
	}

	@FXML
	void tsk3summary() {

	}

	@FXML
	void tsk3table() {

	}

	/**
	 * Task four To be triggered get result button Anything related to tsk4 will
	 * code here
	 * 
	 */

	@FXML
	private Button tsk4ans;

	@FXML
	private ToggleGroup tsk4_algor;

	@FXML
	private ProgressBar tsk4progress;

	@FXML
	private TextField tsk4namei;

	@FXML
	private TextField tsk4namet;

	@FXML
	private TextField tsk4yobi;

	@FXML
	private TextField tsk4yobt;

	@FXML
	void task_four_getresult() {

	}

	@FXML
	void tsk4check() {

	}

//
	/**
	 * Task five To be triggered get result button Anything related to tsk5 will
	 * code here
	 * 
	 */
	@FXML
	private Button tsk5ans;

	@FXML
	private ToggleGroup tsk5_algor;

	@FXML
	private ProgressBar tsk5progress;

	@FXML
	private ToggleGroup tsk5_youth;

	@FXML
	private ToggleGroup tsk5_gender_i;

	@FXML
	private TextField tsk5namei;

	@FXML
	private TextField tsk5yob;

	@FXML
	private ToggleGroup tsk5_gender_choice;

	@FXML
	void task_five_getresult() {

	}

	@FXML
	void tsk5check() {

	}
	//

	/**
	 * Task Six klluiaf To be triggered get result button Anything related to tsk6
	 * will code here
	 * 
	 */
	@FXML
	private ProgressBar tsk6progress;
	@FXML
	private ToggleGroup tsk6_algor;

	@FXML
	private ToggleGroup tsk6_youth;

	@FXML
	private ToggleGroup tsk6_gender_i;

	@FXML
	private ToggleGroup tsk6_gender_t;

	@FXML
	private TextField tsk6namei;

	@FXML
	private TextField tsk6namet;

	@FXML
	private TextField tsk6yob;
	@FXML
	private Button tsk6ans;

	@FXML
	private Button task_six_btn_getresult;

	@FXML
	void task_six_getresult() {
		ToggleButton selected_algor = (ToggleButton) tsk6_algor.getSelectedToggle();
		if (selected_algor == null) {
			textAreaConsole.setText("please select alogrithm");
			return;
		}
		String salgor = selected_algor.getText();
//    	System.out.print(salgor);
		textAreaConsole.setText(salgor);
	}

	@FXML
	void tsk6check() {
		float status = 0;
		int counter = 0;

		RadioButton selected_gender_i = (RadioButton) tsk6_gender_i.getSelectedToggle();
		RadioButton selected_gender_t = (RadioButton) tsk6_gender_t.getSelectedToggle();

		ToggleButton selected_age = (ToggleButton) tsk6_youth.getSelectedToggle();
		ToggleButton selected_algor = (ToggleButton) tsk6_algor.getSelectedToggle();

		String namei = tsk6namei.getText();
		String namet = tsk6namet.getText();
		String yobs = tsk6yob.getText();

		if (!(yobs == null) && !yobs.isBlank()) {
			counter++;
		}
		if (!(namei == null) && !namei.isBlank()) {
			counter++;
		}
		if (!(namet == null) && !namet.isBlank()) {
			counter++;
		}

		if (!(selected_algor == null)) {
			counter++;
		}
		if (!(selected_age == null)) {
			counter++;
		}
		if (!(selected_gender_i == null)) {
			counter++;
		}
		if (!(selected_gender_t == null)) {
			counter++;
		}

		status = counter / 7.0f;
//    	System.out.println(status);
		textAreaConsole.setText(yobs + status);
		tsk6progress.setProgress(status);
		if (status == 1.0) {
			textAreaConsole.setText("done");
			tsk6ans.setDisable(false);
		} else {
			tsk6ans.setDisable(true);
		}
	}


}
