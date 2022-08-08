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
						menu();
						options = Helper.readInt("Enter option: ");
						while (options != 4) {
							if (options == 1) {
								UserAcct.viewUserList(userList);
								Helper.line(30, "=");
								menu();
								options = Helper.readInt("Enter option: ");
							} else if (options == 2) {
								String delete = Helper.readString("Enter id of user to delete: ");
								UserAcct.deleteUser(userList, delete);
								Helper.line(30, "=");
								menu();
								options = Helper.readInt("Enter option: ");
							} else if (options == 3) {
							
							} else if (options == 4) {
								System.out.println("Logged out.");
							}
						}
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
		System.out.println("1. View user list");
		System.out.println("2. Delete user");
		System.out.println("3. ");
		System.out.println("4. Log out");
	}
}