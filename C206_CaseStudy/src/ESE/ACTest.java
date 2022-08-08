package ESE;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void test1() {
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
	public void test2() {
		ArrayList<AcademicCluster>list = new ArrayList();
		String clusterid = "1008";
		
		AcademicCluster.deleteAcademicCluster(list, clusterid);
		
		assertTrue(list.size()==0);
		
	}
}