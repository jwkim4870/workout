
public class ComputerStudent extends Student {
	private int majors;
	private int[] majorSubjects;
	private int total;


	public ComputerStudent( String name, String departmentName, int[] subject, int majors, int[] majorSubject  ) {
		super( name, departmentName, subject );
		
		this.majors = majors;
		majorSubjects = new int[ majors ];
	
		int i = 0;
		for ( int score : majorSubject ) {
			this.majorSubjects[ i++ ] = score;
		}
		calcTotal();
	}
	
	private void calcTotal() {
		total = calcCommonTotal();
		for ( int score : majorSubjects ) {
			total += score;
		}
		
		super.setAverage( total / (double)( MAX_SUBJECT + majors ) );
		double average = super.getAverage();
		
		if ( average >= EXCELLENT ) {
			super.setGrade( "Excellent" );
		} else if ( average < FAIL ) {
			super.setGrade( "Fail" );
		} else {
			super.setGrade( " " );
		}
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		int[] subjects = super.getSubjects();
		
		str.append( super.toString() );

		for ( int i = 0; i < majors; ++i ) {
			str.append( String.format( "%5d ", majorSubjects[ i ] ) );
		}
		str.append( "      " );
		for ( int i = 0; i < MAX_SUBJECT; ++i ) {
			str.append( String.format( "%5d ", subjects[ i ] ) );
		}
		
		str.append( String.format( " %6d %8.2f   %3d   %-10s", 
				                   total, super.getAverage(), 
				                   super.getRank(), super.getGrade() ) );
		
		return str.toString();
	}	
}
