package ESE;
import java.util.ArrayList;

public class SubjectsMenu {

	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Subjects> subjectsList = new ArrayList<Subjects>();

		subjectsList.add(new Subjects("01", "Science"));
		subjectsList.add(new Subjects("02", "Math"));
		subjectsList.add(new Subjects("03", "English"));
		
		int option = 0;

		while (option != 4) {
			
			SubjectsMenu.menu();
			option = Helper.readInt("Enter an option >");
			
			if (option == 1) {
					// View all items
					SubjectsMenu.viewAllSubjects(subjectsList);

				} else if (option == 2) {
	
					SubjectsMenu.setHeader("ADD SUBJECT");

					Subjects sub = inputSubject();
					SubjectsMenu.addSubject(subjectsList, sub);
					System.out.println("Subject added");

				} else if (option == 3) {
					// Return item
					SubjectsMenu.setHeader("DELETE SUBJECT");
					
					SubjectsMenu.deleteSubject(subjectsList);
				} else if (option == 4) {
					CareerPlanningApp.menu();
				} else {
					System.out.println("Invalid option");
				}
				
			}
			
		
	}
		
	

	public static void deleteSubject(ArrayList<Subjects> subjectsList) {
		SubjectsMenu.viewAllSubjects(subjectsList);
		String name = Helper.readString("Enter name > ");
		Boolean isReturned = doDeleteSubject(subjectsList, name);

		if (isReturned == false) {
			System.out.println("Invalid Name");
		} else {
			System.out.println("Subject " + name + " deleted");
		}
		
	}

	public static boolean doDeleteSubject(ArrayList<Subjects> subjectsList, String name) {
		boolean isReturned = false;

		for (int i = 0; i < subjectsList.size(); i++) {
			if (subjectsList.get(i).getSubjectname().toString().equalsIgnoreCase(name)) {
				subjectsList.remove(i);
				isReturned = true;

			}
		}
		return isReturned;
	}



	public static void addSubject(ArrayList<Subjects> subjectsList, Subjects sub) {
		subjectsList.add(sub);
		System.out.println("New Subject Added");
		
	}

	public static Subjects inputSubject() {
		String id = Helper.readString("Enter ID > ");
		String name = Helper.readString("Enter name >");

		Subjects sub = new Subjects(id, name);
		return sub;
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void viewAllSubjects(ArrayList<Subjects> subjectsList) {
		SubjectsMenu.setHeader("SUBJECTS");
		String output = String.format("%-15s %-30s\n", "SUBJECT ID", "SUBJECT NAME");
		output += retrieveAllSubject(subjectsList);
		System.out.println(output);
		
	}

	public static String retrieveAllSubject(ArrayList<Subjects> subjectsList) {
		String output = "";

		for (int i = 0; i < subjectsList.size(); i++) {

			output += String.format("%-15s %-30s\n", subjectsList.get(i).getId(),
					subjectsList.get(i).getName());
		}
		return output;
	}

		
		

	public static void menu() {
		Helper.line(40, "-");
		System.out.println("SUBJECTS");
		Helper.line(40, "-");

		System.out.println("1. View Subject");
		System.out.println("2. Add Subject");
		System.out.println("3. Delete Subject");
		System.out.println("4. Quit");
		
	}
	

}
