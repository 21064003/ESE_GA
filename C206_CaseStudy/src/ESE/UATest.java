package ESE;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UATest {

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
	//Test for add user into array with 1 user in it
	public void testaddUser1() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		String ID = "21064001";
		String uname = "HI";
		String urole = "staff";
		String uemail = "21064001@rp.edu.sg";
		String upassword = "pass123";
		
		UserAcct.addUser(list, userID, name, role, email, password);
		UserAcct.addUser(list, ID, uname, urole, uemail, upassword);
		
		assertEquals(list.size(), 2);
	}
	
	@Test
	//Test for add user into empty arraylist
	public void testaddUser2() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		UserAcct.addUser(list, userID, name, role, email, password);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test for when adding user with same ID
	public void testaddUser3() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		String uname = "HI";
		String urole = "staff";
		String uemail = "21064001@rp.edu.sg";
		String upassword = "pass123";
		UserAcct.addUser(list, userID, name, role, email, password);
		UserAcct.addUser(list, userID, uname, urole, uemail, upassword);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test adding same user twice
	public void testaddUser4() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		UserAcct.addUser(list, userID, name, role, email, password);
		UserAcct.addUser(list, userID, name, role, email, password);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test delete 1 user
	public void testdeletedUser1() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		UserAcct.addUser(list, userID, name, role, email, password);
		String search = "21064003";
		
		UserAcct.deleteUser(list, search);
		
		assertEquals(list.size(), 0);
	}
	
	@Test
	//Test deleted user that does not exist
	public void testdeletedUser2() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		UserAcct.addUser(list, userID, name, role, email, password);
		String search = "21064000";
		
		UserAcct.deleteUser(list, search);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test delete user from empty arraylist
	public void testdeletedUser3() {
		ArrayList<UserAcct> list = new ArrayList();
		String search = "21064003";
		
		UserAcct.deleteUser(list, search);
		
		assertEquals(list.size(), 0);
	}
	
	@Test
	//Test delete 1 user from array with multiple users
	public void testdeletedUser4() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		String ID = "21064001";
		String uname = "HI";
		String urole = "staff";
		String uemail = "21064001@rp.edu.sg";
		String upassword = "pass123";
		
		UserAcct.addUser(list, userID, name, role, email, password);
		UserAcct.addUser(list, ID, uname, urole, uemail, upassword);
		String search = "21064003";
		
		UserAcct.deleteUser(list, search);
		
		assertEquals(list.size(), 1);
	}
	
	@Test
	//Test deleting same user twice
	public void testdeletedUser5() {
		ArrayList<UserAcct> list = new ArrayList();
		String userID = "21064003";
		String name = "SH";
		String role = "student";
		String email = "21064003@myrp.edu.sg";
		String password = "pa55word";
		
		String ID = "21064001";
		String uname = "HI";
		String urole = "staff";
		String uemail = "21064001@rp.edu.sg";
		String upassword = "pass123";
		
		UserAcct.addUser(list, userID, name, role, email, password);
		UserAcct.addUser(list, ID, uname, urole, uemail, upassword);
		String search = "21064003";
		
		UserAcct.deleteUser(list, search);
		UserAcct.deleteUser(list, search);
		
		assertEquals(list.size(), 1);
	}

}
