package ESE;
import java.util.ArrayList;

public class AcademicCluster {

	public String clusterid;
	public String clustername;		
		
		public AcademicCluster(String clusterid, String clustername) {
			this.clusterid = clusterid;
			this.clustername = clustername;
			}
		
		public static void SubMenu(ArrayList<AcademicCluster> AcademicClusterlist, AcademicCluster ac) {
			System.out.println("Academic Clust Menu");
			System.out.println("1. View academic cluster");
			System.out.println("2. Add an academic cluster");
			System.out.println("3. Delete an academic cluster");
			System.out.println("4. Exit");
			
			int option = -1;

			while (option != 4) {
			
				option = Helper.readInt("Enter choice > ");

				if (option == 1) {
					viewAllAcademicCluster(null);
				} else if (option == 2) {
					addAcademicCluster(AcademicClusterlist, ac);
				} else if (option == 3) {
					deleteAcademicCluster(AcademicClusterlist);
				} else if (option == 4) {
					CareerPlanningApp.menu();
				} else {
					System.out.println("Error! Invalid option entered");
				}
			}
		}
		
		public static String inputAcademicCluster() {
			String id = Helper.readString("Enter id of Academic Cluster > ");
			String name = Helper.readString("Enter name of Academic Cluster > ");
			
			AcademicCluster ac = new AcademicCluster(id, name);
			return name;
		}
		
		public static void addAcademicCluster(ArrayList<AcademicCluster> AcademicClusterlist, AcademicCluster ac) {
			AcademicClusterlist.add(ac);
			System.out.println("New Academic Cluster added");
		}
		
		public static String retrieveAllAcademicCluster(ArrayList<AcademicCluster> AcademicClusterList) {
			  String output = "";
		        for(int a = 0; a < AcademicClusterList.size(); a ++) {
		            output += String.format("\n%-12s %-25s", AcademicClusterList.get(a).clusterid, AcademicClusterList.get(a).clustername);
		            }
				return output;
		    }
		
		public static void viewAllAcademicCluster(ArrayList<AcademicCluster> AcademicClusterList) {
			Helper.line(30, "=");
			String output = String.format("\n%-12s %-25s", "CLUSTER ID", "CLUSTER NAME");
			Helper.line(30, "=");
			output += retrieveAllAcademicCluster(AcademicClusterList);
			System.out.println(output);
		}
		
		public static void deleteAcademicCluster(ArrayList<AcademicCluster> AcademicClusterlist) {
			
			String deleteAcademicCluster = Helper.readString("Enter Academic Cluster to search > ");
			for (int a = 0; a < AcademicClusterlist.size(); a ++) {
	            AcademicClusterlist.get(a);
				if (deleteAcademicCluster.equalsIgnoreCase(AcademicCluster.inputAcademicCluster())) {
	            	AcademicClusterlist.remove(a);
	            	System.out.println("AcademicCluster deleted successfully");
	            	break;
	            }
			}
		}
	}