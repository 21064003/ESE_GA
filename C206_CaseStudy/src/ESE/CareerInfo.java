package ESE;
import java.util.ArrayList;

public class CareerInfo {

	public String careerID;
	public String careerName;

	public CareerInfo(String careerID, String careerName) {
		this.careerID = careerID;
		this.careerName = careerName;
	}
	
	public static void printMenu(ArrayList<CareerInfo> list) {
		int choice = -1;
		while (choice != 4) {
			System.out.println("Career Information Menu");
			System.out.println("1. View career information");
			System.out.println("2. Add career information");
			System.out.println("3. Delete career information");
			System.out.println("4. Exit");
			choice = Helper.readInt("Enter option: ");
			
			if (choice == 1) {
				CareerInfo.viewCareerList(list);
			} else if (choice == 2) {
				String careerID = Helper.readString("Enter Career ID: ");
				String careerName = Helper.readString("Enter Career Name: ");
				CareerInfo.addCareer(list, careerID, careerName);
			} else if (choice == 3){
				String search = Helper.readString("Enter career id to delete: ");
				CareerInfo.deleteCareer(list, search);
			} else if (choice == 4) {
				CareerPlanningApp.menu();
			} else {
				System.out.println("Error! Invalid option entered");
			}
		}
	}
	
	public static void viewCareerList(ArrayList<CareerInfo> list) {
		String output = String.format("%-12s %-25s ", "CAREER ID", "CAREER NAME");
		for(int a = 0; a < list.size(); a ++) {
			output += String.format("\n%-12s %-25s ", list.get(a).careerID, list.get(a).careerName);
		}
		
		System.out.println(output);
	}
	
	public static void addCareer(ArrayList<CareerInfo> list, String careerID, String careerName) {
		boolean newcareer = true;
		for (int x = 0; x < list.size(); x ++) {
			if (list.get(x).careerID.equals(careerID)) {
				newcareer = false;
				System.out.println("Error! Career already exists");
			}
		}
		if (newcareer == true) {
			list.add(new CareerInfo(careerID, careerName));
		}
	}
	
	public static void deleteCareer(ArrayList<CareerInfo> list, String search) {
		boolean deleted = false;
		for (int a = 0; a < list.size(); a ++) {
			if (list.get(a).careerID.contains(search)) {
				list.remove(a);
				System.out.println("Career " + search + " deleted");
				deleted = true;
				break;
			} 
		}
		if (deleted = false) {
			System.out.println("Failed to find and delete career " + search);
		}
	}
}