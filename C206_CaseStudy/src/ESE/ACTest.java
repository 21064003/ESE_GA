package ESE;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//.
public class ACTest {

	private static final ArrayList<AcademicCluster> AcademicClusterList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void addAcademicClusterTest() {
		// AcademicCluster list is not null, so that it is able to add a new AcademicCluster (boundary)
		ArrayList<AcademicCluster> AcademicClusterList = new ArrayList<AcademicCluster> ();
		assertNotNull("Test if there is valid category arraylist to add to", AcademicClusterList);
		// Given an empty list, after adding 1 AcademicCluster, the size of the list is 1 (normal)
		// The AcademicCluster just added is the same as the first AcademicCluster of the list
		AcademicCluster a1 = new AcademicCluster("1010", "Science");
		AcademicCluster.addAcademicCluster(AcademicClusterList, a1);
		assertEquals("Test that AcademicCluster arraylist size is 1", 1, AcademicClusterList.size());
		assertSame("Test that AcademicCluster is added", a1, AcademicClusterList.get(0));
		// Add another AcademicCluster
		// Test the size of the list is 2 (normal)
		// The AcademicCluster just added is the same as the second AcademicCluster of the list
		AcademicCluster a2 = new AcademicCluster("1051", "Maths");
		AcademicCluster.addAcademicCluster(AcademicClusterList, a2);
		assertEquals("Test that AcademicCluster arraylist size is 2", 2, AcademicClusterList.size());
		assertSame("Test that AcademicCluster is added", a2, AcademicClusterList.get(1));
	}

	@Test
	public void viewAllAcademicClusterTest() {
		// Test if Academic list is not null but empty (boundary)
		ArrayList<AcademicCluster> AcademicClusterList = new ArrayList<AcademicCluster> ();
		assertNotNull("Test if there is valid Academic arraylist to add to ", AcademicClusterList);
		//Test if the list of Academic retrieved from the case study is empty (boundary)
		String allAcademicCluster = AcademicCluster.retrieveAllAcademicCluster(AcademicClusterList);
		String testOutput = "";
		assertEquals("Check that viewAllAcademicCluster", testOutput, allAcademicCluster);
		// Given an empty list, after adding 2 Academic Clusters, test if the size of the list is 2 (normal)
		AcademicCluster a1 = new AcademicCluster("1010", "Science");
		AcademicCluster a2 = new AcademicCluster("1051", "Maths");
		AcademicCluster.addAcademicCluster(AcademicClusterList, a1);
		AcademicCluster.addAcademicCluster(AcademicClusterList, a2);
		assertEquals("Test that AcademicCluster arraylist size is 2", 2, AcademicClusterList.size());
		// Test if expected output string same name and id as the list of AcademicCluster retrieved from the AcademicCluster
		allAcademicCluster = AcademicCluster.retrieveAllAcademicCluster(AcademicClusterList);
		testOutput = String.format("\n%-12s %-25s", "1010", "Science");
		testOutput += String.format("\n%-12s %-25s", "1051", "Maths");
		assertEquals("Test that ViewAllAcademicClusterList", testOutput, allAcademicCluster);
	}

	@Test
	public void deleteAcademicClusterTest() {
		ArrayList<AcademicCluster> AcademicClusterList = new ArrayList<AcademicCluster> ();
		assertNotNull("Test if there is valid AcademicCluster arrayList to delete to", AcademicClusterList);
		AcademicCluster a1 = new AcademicCluster("1010", "Science");
		AcademicCluster a2 = new AcademicCluster("1051", "Maths");
		AcademicClusterList.add(a1);
		AcademicClusterList.add(a2);
		assertEquals("Test if that Stall arrayList size is 2?", 2, AcademicClusterList.size());
		AcademicClusterList.remove(a1);
		assertEquals("Test if that Stall arrayList size is 1?", 1, AcademicClusterList.size());
		AcademicClusterList.remove(a2);
		assertEquals("Test if that Stall arrayList size is 0?", 0, AcademicClusterList.size());
	}
}