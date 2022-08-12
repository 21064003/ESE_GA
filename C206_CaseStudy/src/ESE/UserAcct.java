package ESE;
import java.util.ArrayList;

public class UserAcct {

	public String userID;
	public String name;
	public String role;
	public String email;
	public String password;

	public UserAcct(String userID, String name, String role, String email, String password) {
		this.userID = userID;
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	
	public static void printMenu(ArrayList<UserAcct> list) {
		int choice = -1;
		while (choice != 4) {
			System.out.println("User Account Menu");
			System.out.println("1. View user list");
			System.out.println("2. Add user");
			System.out.println("3. Delete user");
			System.out.println("4. Exit");
			choice = Helper.readInt("Enter option: ");
			
			if (choice == 1) {
				UserAcct.viewUserList(list);
			} else if (choice == 2) {
				String userID = Helper.readString("Enter User ID: ");
				String name = Helper.readString("Enter Username: ");
				String role = Helper.readString("Enter User role: ");
				String email = Helper.readString("Enter email: ");
				String password = Helper.readString("Enter password: ");
				UserAcct.addUser(list, userID, name, role, email, password);
			} else if (choice == 3){
				String search = Helper.readString("Enter user id of user to delete: ");
				UserAcct.deleteUser(list, search);
			} else if (choice == 4) {
				CareerPlanningApp.menu();
			} else {
				System.out.println("Error! Invalid option entered");
			}
		}
	}
	
	public static void viewUserList(ArrayList<UserAcct> list) {
		String output = String.format("%-12s %-25s %-15s %-30s", "USER ID", "NAME", "ROLE", "EMAIL");
		for(int a = 0; a < list.size(); a ++) {
			output += String.format("\n%-12s %-25s %-15s %-30s", list.get(a).userID, list.get(a).name, list.get(a).role, list.get(a).email);
		}
		
		System.out.println(output);
	}
	
	public static void addUser(ArrayList<UserAcct> list, String userID, String name, String role, String email, String password) {
		boolean newuser = true;
		for (int x = 0; x < list.size(); x ++) {
			if (list.get(x).userID.equals(userID)) {
				newuser = false;
				System.out.println("Error! User already exists");
			}
		}
		if (newuser == true) {
			list.add(new UserAcct(userID, name, role, email, password));
		}
	}
	
	public static void deleteUser(ArrayList<UserAcct> list, String search) {
		boolean deleted = false;
		for (int a = 0; a < list.size(); a ++) {
			if (list.get(a).userID.contains(search)) {
				list.remove(a);
				System.out.println("User " + search + " deleted");
				deleted = true;
				break;
			} 
		}
		if (deleted = false) {
			System.out.println("Failed to find and deleted user " + search);
		}
	}
}
