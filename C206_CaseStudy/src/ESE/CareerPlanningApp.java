package ESE;

import java.util.ArrayList;

public class CareerPlanningApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean login = false;
		ArrayList<UserAcct> userList = new ArrayList();
		userList.add(new UserAcct("21064003", "SH", "staff", "21064003@myrp.edu.sg", "pa55word"));
		int options = -1;
		
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
						Helper.line(30, "-");
						System.out.println(userList.get(i).name);
						Helper.line(30, "-");
						UserAcct.printMenu(userList);
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

}
