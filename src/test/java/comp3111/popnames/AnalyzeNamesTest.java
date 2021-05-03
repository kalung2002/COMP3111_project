package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzeNamesTest {
	
    @Test 
    public void testGetRankNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetRankMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGetRankFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    	
    @Test 
    public void testGetNameMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 27, "M");
    	assertTrue(name.equals("David"));
    }
    
    @Test 
    public void testGetNameFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 2192, "F");
    	assertTrue(name.equals("Desire"));
    }
    
    @Test 
    public void testtsk6csv_num_entry() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.tsk6csv_num_entry(2000));
    }
    @Test 
    public void testtsk3csv_num_entry_by_gender() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.tsk3csv_num_entry_by_gender(2000, "F"));
    }
    @Test 
    public void testtsk3csv_get_highest_rank() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.tsk3csv_get_highest_rank(1980, 2010, "Mary", "F"));
    	
    }
    @Test 
    public void testtsk3csv_get_highest_year() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.tsk3csv_get_highest_year(1980, 2010, "Mary", "F"));
    }
    @Test 
    public void testtsk3csv_find_name_by_year() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.tsk3csv_find_name_by_year(2000, "Mary", "F"));
    	assertEquals(a.tsk3csv_find_name_by_year(2000, "Mmmm", "F"),-1);
    }
    
    @Test 
    public void testget_summary() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.getSummary(2000));
    }
    @Test 
    public void testget_totaloccu() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.getTotalOccur(2000, "F"));
    }
    @Test 
    public void testget_num() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertNotNull(a.getNumber(2000, "F", 5));
    	assertEquals(a.getNumber(2000, "F", 50000000),0);
    }
    @Test 
    public void testget_name() {
    	AnalyzeNames a = new AnalyzeNames();
    	assertEquals(a.getName(2000, 50000000, "F").charAt(0),'i');
    }
   

}
