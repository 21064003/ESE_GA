package ESE;
import java.util.ArrayList;

public class Subjects {
	private String subjectid;
	private String subjectname;
	
	public Subjects(String subjectid, String subjectname) {
		this.subjectid = subjectid;
		this.subjectname = subjectname;
		
	}

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	@Override
	public String toString() {
		String output = String.format("%-15s %-30s\n",getSubjectname(),getSubjectid());
		return output;
		}

		
	

	public String getId() {
		// TODO Auto-generated method stub
		return subjectid;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return subjectname;
	}}


