package ESE;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CI {

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
	//Test for add career info into array with 1 career info in it
	public void testaddCareerInfo1() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		String careerID2 = "2";
		String careerName2 = "Information Technology";
		
		CareerInfo.addCareer(list, careerID, careerName);
		CareerInfo.addCareer(list, careerID2, careerName2);
		
		assertEquals(list.size(), 2);
	}
	
	@Test
	//Test for add career into empty arraylist
	public void testaddCareerInfo2() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";

		CareerInfo.addCareer(list, careerID, careerName);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test for when adding career with same ID
	public void testaddCareerInfo3() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		String careerName2 = "Information Technology";

		CareerInfo.addCareer(list, careerID, careerName);
		CareerInfo.addCareer(list, careerID, careerName2);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test adding same career twice
	public void testaddCareerInfo4() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		CareerInfo.addCareer(list, careerID, careerName);
		CareerInfo.addCareer(list, careerID, careerName);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test delete 1 career
	public void testdeletedCareerInfo() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		CareerInfo.addCareer(list, careerID, careerName);
		String search = "1";
		
		CareerInfo.deleteCareer(list, search);
		
		assertEquals(list.size(), 0);
	}
	
	@Test
	//Test delete career that does not exist
	public void testdeletedCareerInfo2() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		CareerInfo.addCareer(list, careerID, careerName);
		String search = "2";
		
		CareerInfo.deleteCareer(list, search);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test delete career from empty arraylist
	public void testdeletedCareerInfo3() {
		ArrayList<CareerInfo> list = new ArrayList();
		String search = "1";
		
		CareerInfo.deleteCareer(list, search);
		
		assertEquals(list.size(), 0);
	}
	
	@Test
	//Test delete 1 id from array with multiple careers
	public void testdeletedCareerInfo4() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		String careerID2 = "2";
		String careerName2 = "Information Technology";
		
		CareerInfo.addCareer(list, careerID, careerName);
		CareerInfo.addCareer(list, careerID2, careerName2);
		String search = "1";
		
		CareerInfo.deleteCareer(list, search);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test deleting same career twice
	public void testdeletedCareerInfo5() {
		ArrayList<CareerInfo> list = new ArrayList();
		String careerID = "1";
		String careerName = "Business & Finance";
		
		String careerID2 = "2";
		String careerName2 = "Information Technology";
		
		CareerInfo.addCareer(list, careerID, careerName);
		CareerInfo.addCareer(list, careerID2, careerName2);
		String search = "1";
		
		CareerInfo.deleteCareer(list, search);
		CareerInfo.deleteCareer(list, search);
		
		assertEquals(list.size(), 1);
	}

}
