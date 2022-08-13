package ESE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectsTest {
	
	private Subjects sub1;
	private Subjects sub2;
	private Subjects sub3;
	
	public ArrayList<Subjects> subjectsList;
	
	public SubjectsTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		sub1 = new Subjects("01", "Math");
		sub2 = new Subjects("02", "Science");
		sub3 = new Subjects("03", "Math");
		

		
	
	

	} 
	
	public void testRetrieveAllSubject() {
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectsList);


		String allSubject = SubjectsMenu.retrieveAllSubject(subjectsList);
		String testOutput = "";
		assertEquals("Check that ViewAllSubjectList", testOutput, allSubject);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		SubjectsMenu.addSubject(subjectsList, sub1);
		SubjectsMenu.addSubject(subjectsList, sub2);
		assertEquals("Test if that Subject arraylist size is 2?", 2, subjectsList.size());

		allSubject = SubjectsMenu.retrieveAllSubject(subjectsList);

		testOutput = String.format("%-15s %-30s %-20s\n", "Subject001", "Math", "Min age 3");
		testOutput += String.format("%-15s %-30s %-20s\n", "Subject002", "Science", "Min age 7");

		assertEquals("Check that ViewAllSubjectlist", testOutput, allSubject);
	
	
	}
	
	@Test
	public void testAddSubject() {
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectsList);

		
		SubjectsMenu.addSubject(subjectsList, sub1);
		assertEquals("Test if that Subject arraylist size is 1?", 1, subjectsList.size());

		assertSame("Test that Subject is added same as 1st item of the list?", sub1, subjectsList.get(0));

	
		SubjectsMenu.addSubject(subjectsList, sub2);
		SubjectsMenu.addSubject(subjectsList, sub3);
		assertEquals("Test that Subject arraylist size is 3?", 3, subjectsList.size());
		assertSame("Test that Subject is added same as 3rd item of the list?", sub3, subjectsList.get(2));
	

	

}
	
	@Test
	public void testDoDeleteSubject() {

		
		assertNotNull("Test if there is valid Subject arraylist to add to", subjectsList);

		
		SubjectsMenu.addSubject(subjectsList, sub1);
		Boolean isReturned = SubjectsMenu.doDeleteSubject(subjectsList, "sub01");
		System.out.print(isReturned);
		assertTrue("Test if subject Subject001 is deleted?", isReturned);

	
		isReturned = SubjectsMenu.doDeleteSubject(subjectsList, "sub03");
		assertFalse("Test if subject Subject003 is not delete?", isReturned);

}
	
	@After
	public void tearDown() throws Exception {
		sub1 = null;
		sub2 = null;
		sub3 = null;
		subjectsList = null;
	}

	
	

}




