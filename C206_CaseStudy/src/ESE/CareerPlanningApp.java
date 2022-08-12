package ESE;

import java.util.ArrayList;

public class CareerPlanningApp {

	public static boolean login = false;
	public static ArrayList<UserAcct> userList = new ArrayList();
	public static ArrayList<AcademicCluster> acList = new ArrayList();
	public static ArrayList<CareerInfo> ciList = new ArrayList();
	public static int options = -1;
	public static String user = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menu = -1;
		userList.add(new UserAcct("21064003", "SH", "staff", "21064003@myrp.edu.sg", "pa55word"));
		acList.add(new AcademicCluster("1010", "Science"));
		ciList.add(new CareerInfo("1", "Business & Finance"));
		
		while (login == false) {
			System.out.println("HOMEPAGE");
			int log = Helper.readInt("1. Register for new account \n2. Login with exisiting account \n(key in option)");
			if (log == 1) {
				System.out.println("REGISTER NEW ACCOUNT");
				String id = Helper.readString("ID: ");
				String name = Helper.readString("Username: ");
				String email = Helper.readString("Email: ");
				String pass = Helper.readString("Password: ");
				String confirm = Helper.readString("Re-enter password: ");
				
				while (pass.equals(confirm) == false) {
					System.out.println("Error password does not match.");
					System.out.println("Please try again");
					pass = Helper.readString("Password: ");
					confirm = Helper.readString("Re-enter password: ");
				}
				if (pass.equals(confirm)) {
					UserAcct.addUser(userList, id, name, "staff", email, pass);
					System.out.println("Registration successful. Please login with the new account");
				} 
				
			} else if (log == 2) {
				System.out.println("LOGIN");
				String username = Helper.readString("Username: ");
				String pw = Helper.readString("Password: ");
				
				for (int i = 0; i < userList.size(); i ++) {
					if ( username.equals(userList.get(i).name) && pw.equals(userList.get(i).password)) {
						login = true;
						user = userList.get(i).name;
						
						menu();
						menu = Helper.readInt("Please enter option: ");
						
						while (menu != 5) {
							if (menu == 1) {
								UserAcct.printMenu(userList);
							} else if (menu == 2) {
								AcademicCluster.SubMenu(acList, null);
							} else if (menu == 3) {
								CareerInfo.printMenu(ciList);
							} else if (menu == 4) {
								
							} else if (menu == 5) {
								
							} else {
								System.out.println("Error! Invalid option");
								menu = Helper.readInt("Please re-enter option: ");
							}
							menu = Helper.readInt("Please enter option: ");
						}
						
						System.out.println("Logging out... ...");
						System.out.println("Log out successful.");
						System.out.println("Returning to login page...");
						System.out.println("");
						System.out.println("HOMEPAGE");
						log = Helper.readInt("1. Register for new account \n2. Login with exisiting account \n(key in option)");
					} 
				}
				if (login == false) {
					System.out.println("Error! Invalid username or password.");
					System.out.println("Please try again");
				}
			} else {
				System.out.println("Invalid option");
			}
		}
	}
	
	public static void menu() {
		Helper.line(30, "-");
		System.out.println(user);
		Helper.line(30, "-");
		
		System.out.println("1. View more User Account options");
		System.out.println("2. View more Academic Cluster options");
		System.out.println("3. View more Career Info options");
		System.out.println("4. View more Subject options");
		System.out.println("5. Log out");
	}

}
