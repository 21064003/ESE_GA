package ESE;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AC {

	private static final Object AcademicClusterList = null;

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
	public void retrieveAllAcademicClusterTest() {
		assertNotNull("Test if there is valid Academic Cluster arraylist to add to ", AcademicClusterList);
	
	String allAcademicCluster = AcademicCluster.viewAllAcademicCluster(AcademicClusterList);
	String clusterid = "";
	assertEquals("Check that ViewAllAcademicClusterList", clusterid, allAcademicCluster);
	
	AcademicCluster.addAcademicCluster(AcademicClusterList, 1);
	AcademicCluster.addAcademicCluster(AcademicClusterList, 2);
	assertEquals("Test that AcademicCluster arraylist size is 2", 2, AcademicClusterList.size());
	
	allAcademicCluster = AcademicCluster.viewAllAcademicCluster(AcademicClusterList);
	clusterid = String.format("%-20s %-20s\n", "21010", "IT");
	clusterid += String.format("%-20s %-20s\n", "01010", "Art");
	assertEquals("Test that ViewAllAcademicClusterList", clusterid, allAcademicCluster);
	}
		
	@Test
	public void test2() {
		ArrayList<AcademicCluster>list = new ArrayList();
		String clusterid = "1008";
		String clustername = "ICT";
		String clusterid1 = "2001";
		String clustername1 = "Business";
		
		
		AcademicCluster.addAcademicCluster(list, clusterid, clustername);
		AcademicCluster.addAcademicCluster(list, clusterid1, clustername1);
		
		assertEquals(list.size(), 2);
		
		
	}
	
	@Test
	public void test3() {
		ArrayList<AcademicCluster>list = new ArrayList();
		String clusterid = "1008";
		
		AcademicCluster.deleteAcademicCluster(list, clusterid);
		
		assertTrue(list.size()==0);
		
	}
}

