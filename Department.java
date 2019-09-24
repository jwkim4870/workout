
public class Department {
	public static final int LOW_MAJORS = 1;
	
	private String departmentName;
	private int majors;
	
	public Department( String departmentName, int majors ) {
		this.departmentName = departmentName;
		this.majors = majors;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public int getMajors() {
		return majors;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append( String.format( "%-20s[ %2d ]\n", departmentName, majors ) );
		
		return str.toString();
	}
}
