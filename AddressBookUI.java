import java.util.Scanner;

public class AddressBookUI {
	private AddressBook addressBook;	// AddressBook과 AddressBookUI 연결
	
	public AddressBookUI() {
		addressBook = new AddressBook();
	}
	
	public void mainMenu() {
		String menu = "1. 주소정보 등록\n"
				    + "2. 주소정보 삭제\n"
				    + "3. 주소정보 검색\n"
				    + "4. 주소록 정보출력\n"
				    + "0. 종료\n"
				    + "원하는 메뉴를 선택하세요... ";
		Scanner sc = new Scanner( System.in );
		int select = -1;
		while ( select != 0 ) {
			System.out.print( menu );
			select = Integer.parseInt( sc.nextLine() );
			switch ( select ) {
			case 1: inputAddressInfo();		break;
			case 2: deleteAddressInfo();	break;
			case 3: searchAddressInfo();	break;
			case 4: printAddressBook();		break;
			case 0: 						break;
			default: System.out.println( "Error : 0 ~ 4사이만 입력 가능...\n" );
			}
		} 
		System.out.println( "\nStop program.....\n" );
	}
	
	public void inputAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		String email;
		
		System.out.print( "주소 정보 등록 - 이름 입력 ( \'end\' : 종료 ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "주소 정보 등록 - 전화번호 입력 : " );
			tel = sc.nextLine();
			System.out.print( "주소 정보 등록 - e-mail 입력 : " );
			email = sc.nextLine();
			
			addressBook.appendAddressInfo( new AddressInfo( name, tel, email ) );
			
			System.out.print( "\n주소 정보 등록 - 이름 입력 ( \'end\' : 종료 ) : " );
			name = sc.nextLine();
		}
		System.out.println();
	}
	
	public void deleteAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		
		System.out.print( "주소 정보 삭제 이름 입력 ( \'end\' : 종료 ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "주소 정보 삭제 - 전화번호 입력 : " );
			tel = sc.nextLine();
			
			if ( addressBook.removeAddressInfo( name, tel ) > -1 ) {
				System.out.println();
				System.out.printf( "%-10s %13s 삭제 성공!!!\n", name, tel );
				System.out.println();
			} else {
				System.out.println();
				System.out.printf( "%-10s %13s 삭제 실패!!!\n", name, tel );
				System.out.println();
			}
			
			System.out.print( "주소 정보 삭제 - 이름 입력 ( \'end\' : 종료 ) : " );
			name = sc.nextLine();
		}
		System.out.println();
	}
	
	public void searchAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		int index;
		
		System.out.print( "주소 정보 검색 이름 입력 ( \'end\' : 종료 ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "주소 정보 검색 - 전화번호 입력 : " );
			tel = sc.nextLine();
			
			index = addressBook.searchAddressInfo( name, tel ); 
			if ( index > -1 ) {
				System.out.println();
				System.out.println( addressBook.getAddressInfo( index ) );
				System.out.println();
			} else {
				System.out.println();
				System.out.printf( "%-10s %13s 검색 실패!!!\n", name, tel );
				System.out.println();
			}
			
			System.out.print( "주소 정보 검색 - 이름 입력 ( \'end\' : 종료 ) : " );
			name = sc.nextLine();
		}		
		System.out.println();
	}
	
	public void printAddressBook() {
		System.out.println();
		System.out.println( "\t\t  주소록" );
		System.out.println();
		System.out.println( "-----------------------------------------------" );
		System.out.println( "번호\t이름\t전화번호\te-mail" );
		System.out.println( "-----------------------------------------------" );
		System.out.print( addressBook );
		System.out.println( "-----------------------------------------------" );
		System.out.println( "\t\t\t    총 주소 정보수 : " + addressBook.getCountAddressInfo() );
		System.out.println();
	}
}
