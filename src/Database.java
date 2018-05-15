import java.util.ArrayList;

public class Database {
	public void addGroup(String groupName) {}
	public void removeGroup(String groupName) {}
	public void renameGroup(String groupName, String newGroupName) {}
	public void addStudent(String groupName, String studentName) {}
	public void removeStudent(String groupName, String studentName) {}
	public void moveStudent(String studentName, String groupName, String targetGroupName) {}
	public void renameStudent(String groupName, String studentName, String newStudentName) {}
	public void markStudent(String groupName, String studentName) {}
	public String[] getGroups() {return new String[2];}
	public ArrayList<String[]> getStudents(String groupName) {return new ArrayList<String[]>();}
	public String[] getStudentNames(String groupName) {return new String[0];}
}
