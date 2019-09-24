import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreTableUI {
	private ScoreTable scoreTable;
	private DepartmentControl departmentControl;
	
	public ScoreTableUI() {
		scoreTable = new ScoreTable();
		departmentControl = new DepartmentControl();
	}
	
	public void mainMenu() {
		String menu = "   <<< 성적 관리 >>>\n\n"
					+ "1. 학과 정보 등록\n"
				    + "2. 학생 성적 정보 등록\n"
				    + "3. 성적 일람표 출력( 입력순 )\n"
				    + "4. 성적 일람표 출력( 평균순 )\n"				    
				    + "0. 종료\n"
				    + "원하는 메뉴를 선택하세요... ";
		Scanner sc = new Scanner( System.in );
		int select = -1;
		while ( select != 0 ) {
			System.out.print( menu );
			select = Integer.parseInt( sc.nextLine() );
			switch ( select ) {
			case 1: inputDepartmentInfo();		break;
			case 2: inputStudentInfo();			break;
			case 3: printScoreTable();			break;
			case 4: printScoreTableAverage();	break;
			case 0: 							break;
			default: System.out.println( "Error : 0 ~ 4사이만 입력 가능...\n" );
			}
		} 
		System.out.println( "\nStop program.....\n" );
	}
	
	public void inputDepartmentInfo() {
		Scanner sc = new Scanner( System.in );
		
		String departmentName;
		int majors;
		int countDepartment = departmentControl.getCountDepartment(); 
		
		if ( countDepartment < DepartmentControl.MAX_DEPARTMENT ) {
			System.out.printf( "\n[ %2d중 %2d ]번째 학과 이름 입력 ( \'end\'면 종료 ) : ",  
					DepartmentControl.MAX_DEPARTMENT, countDepartment + 1 );
			departmentName = sc.nextLine();
			while ( !departmentName.equals( "end" ) ) {
				System.out.printf( "[ %-20s] 전공 과목수 입력 : ", departmentName );
				majors = Integer.parseInt( sc.nextLine() );
				while ( majors < Department.LOW_MAJORS ) {
					System.out.printf( "\tError : 과목수는 1이상 입력 하세요.\n\n" );
					System.out.printf( "[ %-20s] 전공 과목수 입력 : ", departmentName );
					majors = Integer.parseInt( sc.nextLine() );
				}
				
				departmentControl.appendDepartment( departmentName, majors );
				countDepartment = departmentControl.getCountDepartment();
				
				if ( countDepartment < DepartmentControl.MAX_DEPARTMENT ) {
					System.out.printf( "\n[ %2d중 %2d ]번째 학과 이름 입력 ( \'end\'면 종료 ) : ",  
										DepartmentControl.MAX_DEPARTMENT, countDepartment + 1 );
					departmentName = sc.nextLine();
				} else {
					break;
				}
			}
		} else {
			System.out.println( "\nInfo : 학과 정보가 이미 모두 입력 되었습니다.\n" );
		}
	}
	
	public void inputStudentInfo() {
		if ( departmentControl.getCountDepartment() > 0 ) {
			Scanner sc = new Scanner( System.in );
			
			String name;
			String departmentName;
			int majors;
			int[] commonSubjects = new int[ Student.MAX_SUBJECT ];
			int[] majorSubjects;
			
			int count = scoreTable.getCountStudent();
			int majorIndex;
			
			System.out.printf( "\n학생 이름 입력 ( 이름이 \'end\' 이면 종료 ) : " );
			name = sc.nextLine();
			while ( !name.equals( "end" ) ) {
				++count;
				
				System.out.println( "\n    <<< 학과 목록 >>>" );
				System.out.print( departmentControl );
				System.out.println();
				System.out.print( "학과 이름 입력 : " );
				departmentName = sc.nextLine();
				majorIndex = departmentControl.searchMajors( departmentName );
				while ( majorIndex < 0 ) {
					System.out.printf( "\tError : 등록된 학과명이 아닙니다.\n\n" );
					System.out.println( "\n    <<< 학과 목록 >>>" );
					System.out.print( departmentControl );
					System.out.println();
					System.out.print( "학과 이름 입력 : " );
					departmentName = sc.nextLine();
					majorIndex = departmentControl.searchMajors( departmentName );
				}
				
				majors = departmentControl.getMajors( majorIndex ).getMajors();
				majorSubjects = new int[ majors ];
				for ( int i = 0; i < majors; ++i ) {
					System.out.printf( "\t[ %-20s ]학과 [%2d]번째 전공과목 점수 입력 ( 0 ~ 100 ) : ", 
									   departmentName, i + 1 );
					majorSubjects[ i ] = Integer.parseInt( sc.nextLine() );
					while ( majorSubjects[ i ] < Student.LOW_SCORE || majorSubjects[ i ] > Student.HIGH_SCORE ) {
						System.out.printf( "\tError : 점수는 0 ~ 100사이만 입력 하세요.\n\n" );
						System.out.printf( "\t[ %-20s ]학과 [%2d]번째 전록과목 점수 입력 ( 0 ~ 100 ) : ",
											departmentName, i + 1 );
						majorSubjects[ i ] = Integer.parseInt( sc.nextLine() );
					}
				}
				
				System.out.println();
				for ( int i = 0; i < Student.MAX_SUBJECT; ++i ) {
					System.out.printf( "\t[%2d]번째 공통과목 점수 입력 ( 0 ~ 100 ) : ", i + 1 );
					commonSubjects[ i ] = Integer.parseInt( sc.nextLine() );
					while ( commonSubjects[ i ] < Student.LOW_SCORE || commonSubjects[ i ] > Student.HIGH_SCORE ) {
						System.out.printf( "\tError : 점수는 0 ~ 100사이만 입력 하세요.\n\n" );
						System.out.printf( "\t[%2d]번째 공통과목 점수 입력 ( 0 ~ 100 ) : ", i + 1 );
						commonSubjects[ i ] = Integer.parseInt( sc.nextLine() );
					}
				}
				
				scoreTable.appendStudentInfo( name, departmentName, commonSubjects, majors, majorSubjects );
					
				System.out.printf( "\n학생 이름 입력 ( 이름이 \'end\' 이면 종료 ) : " );
				name = sc.nextLine();
			}
		} else {
			System.out.println( "\nInfo : 학과 정보를 먼저 등록하세요.\n" );
		}
			
	}
	
	public void printScoreTable() {
		if ( departmentControl.getCountDepartment() > 0 ) {
			System.out.println();
			System.out.println( "\t\t\t\t    <<< 성적일람표 >>>" );
			System.out.println();
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			System.out.println( "이름\t   학과\t\t\t  전공\t\t     공통\t\t총점\t평균\t석차  등급" );
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			scoreTable.printScoreTable();
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			System.out.printf( "총학생수 : %2d\n", scoreTable.getCountStudent() );
			System.out.println();
		} else {
			System.out.println( "\nInfo : 학과 정보를 먼저 등록하세요.\n" );
		}
	}
	
	public void printScoreTableAverage() {
		if ( departmentControl.getCountDepartment() > 0 ) {		
			System.out.println();
			System.out.println( "\t\t\t\t    <<< 성적일람표 >>>" );
			System.out.println();
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			System.out.println( "이름\t   학과\t\t\t  전공\t\t     공통\t\t총점\t평균\t석차  등급" );
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			scoreTable.printScoreTableAverage();
			System.out.println( "------------------------------------------------------------------------------------------------------" );
			System.out.printf( "총학생수 : %2d\n", scoreTable.getCountStudent() );
			System.out.println();
		} else {
			System.out.println( "\nInfo : 학과 정보를 먼저 등록하세요.\n" );
		}
	}
}
