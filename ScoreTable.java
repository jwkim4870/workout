import java.util.ArrayList;
import java.util.List;

public class ScoreTable {
	private List<Student> students, sortStudents;
	private int countStudent;
	
	public ScoreTable() {
		students = new ArrayList<>();
		sortStudents = new ArrayList<>();
		countStudent = 0;
	}
	
	public int getCountStudent() {
		return countStudent;
	}

	public void setCountStudent(int countStudent) {
		this.countStudent = countStudent;
	}

	public void appendStudentInfo( String name, String majorName, int[] subjects, int majors, int[] majorSubjects ) {
		if ( majorName.equals( "computer" ) ) {
			students.add( new ComputerStudent( name, majorName, subjects, majors, majorSubjects ) );
		} else if ( majorName.equals( "electronic" ) ) {
			students.add( new ElectronicStudent( name, majorName, subjects, majors, majorSubjects ) );
		}
		
		++countStudent;
		calcRank();
		sortStudents();
	}
	
	public List<Student> searchStudentInfo( String name ) {
		List<Student> resultStudents = new ArrayList<>();
		
		for ( Student student : students ) {
			if ( student.getName().equals( name ) ) {
				resultStudents.add( student );
			}
		}
		
		return resultStudents;
	}
	
	public void printScoreTable() {
		for ( Student student : students ) {
			System.out.println( student );
		}
	}
	
	public void printScoreTableAverage() {
		for ( Student student : sortStudents ) {
			System.out.println( student );
		}
	}
	
	private void calcRank() {
		int rank;
		
		for ( int i = 0; i < this.students.size(); ++i ) {
			rank = 1;
			for ( int j = 0; j < this.students.size(); ++j ) {
				if ( students.get( i ).getAverage() < students.get( j ).getAverage() ) {
					++rank;
				}
			}
			students.get( i ).setRank( rank );
		}
	}
	
	private void sortStudents() {
		Student[] studentArray = copyArray();
		final int MAX_ARRAY = studentArray.length - 1;
		
		Student temp;
		int k;
		for ( int i = 0; i < MAX_ARRAY; ++i ) {
			k = i;
			for ( int j = i + 1; j < studentArray.length; ++j ) {
				if ( studentArray[ k ].getAverage() < studentArray[ j ].getAverage() ) {
					k = j;
				}
			}
			if ( k != i ) {
				temp = studentArray[ i ];
				studentArray[ i ] = studentArray[ k ];
				studentArray[ k ] = temp;
			}
		}
		this.updateSortArray( studentArray );	
	}
	
	private Student[] copyArray() {
		final int MAX_STUDENTS = students.size();
		Student[] studentArray = new Student[ MAX_STUDENTS ];
		
		for ( int i = 0; i < MAX_STUDENTS; ++i ) {
			studentArray[ i ] = students.get( i ); 
		}

		return studentArray;
	}

	private void updateSortArray( Student[] studentArray ) {
		sortStudents.clear();
		for ( Student item : studentArray ) {
			sortStudents.add( item );
		}		
	}	
}
