package ESE;
import java.util.ArrayList;

public class AcademicCluster {

	public String clusterid;
	public String clustername;		
		
		public AcademicCluster(String clusterid, String clustername) {
			this.clusterid = clusterid;
			this.clustername = clustername;
			}
		
		public void start() {

			int option = -1;

			while (option != 4) {
				SubMenu();
				option = Helper.readInt("Enter choice > ");

				if (option == 1) {
					viewAllAcademicCluster(null);
				} else if (option == 2) {
					addAcademicCluster(null, clusterid, clusterid);
				} else if (option == 3) {
					deleteAcademicCluster(null, clusterid);
				} else if (option == 4) {

					System.out.println("Thank you for using Academic Clusters!");
			}
		}
	}
		
		public void SubMenu() {
			System.out.println("Academic Cluster Menu");
			System.out.println("1. View academic cluster");
			System.out.println("2. Add an academic cluster");
			System.out.println("3. Delete an academic cluster");
			System.out.println();
		}
		
		public static String viewAllAcademicCluster(ArrayList<AcademicCluster> AcademicClusterList) {
			  String output = String.format("%-12s %-25s", "CLUSTER ID", "CLUSTER NAME");
		        for(int a = 0; a < AcademicClusterList.size(); a ++) {
		            output += String.format("\n%-12s %-25s", AcademicClusterList.get(a).clusterid, AcademicClusterList.get(a).clustername);
		            }
				return output;
		    }
		
		public static AcademicCluster inputAcademicCluster() {
			String id = Helper.readString("Enter id of Academic Cluster > ");
			String name = Helper.readString("Enter name of Academic Cluster > ");
			
			AcademicCluster ac = new AcademicCluster(id, name);
			return ac;
		}
		
		public static void addAcademicCluster(ArrayList<AcademicCluster> AcademicClusterlist, String clusterid, String clustername) {
			AcademicCluster ac = null;
			AcademicClusterlist.add(ac);
			System.out.println("New Academic Cluster added");
		}
		
		public static void deleteAcademicCluster(ArrayList<AcademicCluster> AcademicClusterlist, String search) {
			for (int a = 0; a < AcademicClusterlist.size(); a ++) {
	            if (AcademicClusterlist.get(a).clusterid.contains(search)) {
	            	AcademicClusterlist.remove(a);
		}
			}
		}
}