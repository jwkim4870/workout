import java.util.ArrayList;
import java.util.List;

public class DepartmentControl {
	public static final int MAX_DEPARTMENT = 2;
	
	private List<Department> departments;
	private int countDepartment;
	
	public DepartmentControl() {
		departments = new ArrayList<>( MAX_DEPARTMENT );
		countDepartment = 0;
	}
	
	public void appendDepartment( String departmentName, int majors ) {
		departments.add( new Department( departmentName, majors ) );
		++countDepartment;
	}
	
	public int getCountDepartment() {
		return countDepartment;
	}

	public Department getMajors( int index ) {
		return departments.get( index );
	}
	
	public int searchMajors( String departmentName ) {
		int index = -1;
		
		for ( int i = 0; i < departments.size(); ++i ) {
			if ( departments.get( i ).getDepartmentName().equals( departmentName ) ) {
				index = i;
			}
		}
		
		return index;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for ( Department department : departments ) {
			str.append( department );
		}
		
		return str.toString();
	}
}
