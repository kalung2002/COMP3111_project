/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

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

    @FXML
    private Tab tabReport1;

    @FXML
    private Tab tabReport2;

    @FXML
    private Tab tabReport3;

    @FXML
    private Tab tabApp1;

    @FXML
    private Tab tabApp2;

    @FXML
    private Tab tabApp3;

    @FXML
    private TextArea textAreaConsole;

//    @FXML
//    private ToggleGroup tsk6;
//    @FXML
//    private ToggleButton T6X1;
//    @FXML
//    private ToggleButton T6X2;

    @FXML
    private ToggleGroup T1;
    @FXML
    private ToggleGroup T11;
    @FXML
    private ToggleGroup T111;
    


    /**
     *  Task Zero
     *  To be triggered by the "Summary" button on the Task Zero Tab 
     *  
     */
    @FXML
    void doSummary() {
    	int year = Integer.parseInt(textfieldYear.getText());
    	String oReport = AnalyzeNames.getSummary(year);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (female)" button on the Task Zero Tab
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
     *  Task Zero
     *  To be triggered by the "Rank (male)" button on the Task Zero Tab
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
     *  Task Zero
     *  To be triggered by the "Top 5 (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopF() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopM() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
    	textAreaConsole.setText(oReport);
    }
    /**
     *  Task Six klluiaf
     *  Anything related to tsk6 will code here
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
    void task_six_getresult() {
    	ToggleButton selected_algor = (ToggleButton)tsk6_algor.getSelectedToggle();
    	if(selected_algor==null) {
    		textAreaConsole.setText("please select alogrithm");
    		return;
    	}
    	String salgor = selected_algor.getText();
//    	System.out.print(salgor);
    	textAreaConsole.setText(salgor);
    }

    @FXML
    void tsk6check() {
    	float status=0;
    	int counter=0;
    	
    	RadioButton selected_gender_i = (RadioButton) tsk6_gender_i.getSelectedToggle();
    	RadioButton selected_gender_t = (RadioButton) tsk6_gender_t.getSelectedToggle();
    	
    	ToggleButton selected_age = (ToggleButton)tsk6_youth.getSelectedToggle();
    	ToggleButton selected_algor = (ToggleButton)tsk6_algor.getSelectedToggle();

    	String namei =tsk6namei.getText();
    	String namet =tsk6namet.getText();
    	String yobs=tsk6yob.getText();
    	
    	
    	if(!(yobs==null)&&!yobs.isBlank()) {counter++;}
    	if(!(namei==null)&&!namei.isBlank()) {counter++;}
    	if(!(namet==null)&&!namet.isBlank()) {counter++;}
    	
    	if(!(selected_algor==null)) {counter++;}
    	if(!(selected_age==null)) {counter++;}
    	if(!(selected_gender_i==null)) {counter++;}
    	if(!(selected_gender_t==null)) {counter++;}
    	
    	status=counter/7.0f;
//    	System.out.println(status);
    	textAreaConsole.setText(yobs+status);
    	tsk6progress.setProgress(status);
    	if(status==1.0) {
    		textAreaConsole.setText("done");
    		tsk6ans.setDisable(false);
    	}else {tsk6ans.setDisable(true);}
    	
    	
    	

    }

}

