
public class Student {
	public static final int MAX_SUBJECT = 3;
	
	public static final int EXCELLENT = 90;
	public static final int FAIL = 60;
	public static final int HIGH_SCORE = 100;
	public static final int LOW_SCORE = 0;
	
	private String name;
	private String departmentName;
	private int[] subjects = new int[ MAX_SUBJECT ];
	private double average;
	private int rank;
	private String grade;
	
	public Student( String name, String departmentName, int[] subject ) {
		this.name = name;
		this.departmentName = departmentName;
		
		int i = 0;
		for ( int score : subject ) {
			this.subjects[ i++ ] = score;
		}
		this.rank = 1;
	}
	
	public String getName() {
		return name;
	}

	public int[] getSubjects() {
		return subjects;
	}
	
	public double getAverage() {
		return average;
	}
	
	public int getRank() {
		return rank;
	}

	public String getGrade() {
		return grade;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	protected int calcCommonTotal() {
		int total = 0;
		for ( int score : subjects ) {
			total += score;
		}
		
		return total;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append( String.format( "%-10s %-20s ", name, departmentName ) );

		return str.toString();
	}
}
