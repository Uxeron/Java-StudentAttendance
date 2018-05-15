import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
	Map<String, Map<String, ArrayList<String> > > data;

	public void Database() {
		data = new HashMap<>();
	}

	public void addGroup(String groupName) {
		data.put(groupName, new HashMap<>());
	}

	public void removeGroup(String groupName) {
		data.remove(groupName);
	}

	public void renameGroup(String groupName, String newGroupName) {
		data.put(newGroupName, data.get(groupName));
		data.remove(groupName);
	}

	public void addStudent(String groupName, String studentName) {
		data.get(groupName).put(studentName, new ArrayList<>());
	}

	public void removeStudent(String groupName, String studentName) {
		data.get(groupName).remove(studentName);
	}

	public void moveStudent(String studentName, String groupName, String targetGroupName) {
		data.get(targetGroupName).put(studentName, data.get(groupName).get(studentName));
		data.get(groupName).remove(studentName);
	}

	public void renameStudent(String groupName, String studentName, String newStudentName) {
		data.get(groupName).put(newStudentName, data.get(groupName).get(studentName));
		data.get(groupName).remove(studentName);
	}

	public void markStudent(String groupName, String studentName, String date, boolean mark) {
		if(mark)
			data.get(groupName).get(studentName).add(date);
		else
			data.get(groupName).get(studentName).remove(date);
	}

	public String[] getGroups() {
		return data.keySet().toArray(new String[0]);
	}

	public Map<String, ArrayList<String> > getStudents(String groupName) {
		return data.get(groupName);
	}

	public String[] getStudentNames(String groupName) {
		return data.get(groupName).keySet().toArray(new String[0]);
	}
}
