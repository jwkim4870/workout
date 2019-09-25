import java.util.Scanner;

public class AddressBookUI {
	private AddressBook addressBook;	// AddressBook�� AddressBookUI ����
	
	public AddressBookUI() {
		addressBook = new AddressBook();
	}
	
	public void mainMenu() {
		String menu = "1. �ּ����� ���\n"
				    + "2. �ּ����� ����\n"
				    + "3. �ּ����� �˻�\n"
				    + "4. �ּҷ� �������\n"
				    + "0. ����\n"
				    + "���ϴ� �޴��� �����ϼ���... ";
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
			default: System.out.println( "Error : 0 ~ 4���̸� �Է� ����...\n" );
			}
		} 
		System.out.println( "\nStop program.....\n" );
	}
	
	public void inputAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		String email;
		
		System.out.print( "�ּ� ���� ��� - �̸� �Է� ( \'end\' : ���� ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "�ּ� ���� ��� - ��ȭ��ȣ �Է� : " );
			tel = sc.nextLine();
			System.out.print( "�ּ� ���� ��� - e-mail �Է� : " );
			email = sc.nextLine();
			
			addressBook.appendAddressInfo( new AddressInfo( name, tel, email ) );
			
			System.out.print( "\n�ּ� ���� ��� - �̸� �Է� ( \'end\' : ���� ) : " );
			name = sc.nextLine();
		}
		System.out.println();
	}
	
	public void deleteAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		
		System.out.print( "�ּ� ���� ���� �̸� �Է� ( \'end\' : ���� ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "�ּ� ���� ���� - ��ȭ��ȣ �Է� : " );
			tel = sc.nextLine();
			
			if ( addressBook.removeAddressInfo( name, tel ) > -1 ) {
				System.out.println();
				System.out.printf( "%-10s %13s ���� ����!!!\n", name, tel );
				System.out.println();
			} else {
				System.out.println();
				System.out.printf( "%-10s %13s ���� ����!!!\n", name, tel );
				System.out.println();
			}
			
			System.out.print( "�ּ� ���� ���� - �̸� �Է� ( \'end\' : ���� ) : " );
			name = sc.nextLine();
		}
		System.out.println();
	}
	
	public void searchAddressInfo() {
		Scanner sc = new Scanner( System.in );
		String name;
		String tel;
		int index;
		
		System.out.print( "�ּ� ���� �˻� �̸� �Է� ( \'end\' : ���� ) : " );
		name = sc.nextLine();
		while ( !name.equals( "end" ) ) {
			System.out.print( "�ּ� ���� �˻� - ��ȭ��ȣ �Է� : " );
			tel = sc.nextLine();
			
			index = addressBook.searchAddressInfo( name, tel ); 
			if ( index > -1 ) {
				System.out.println();
				System.out.println( addressBook.getAddressInfo( index ) );
				System.out.println();
			} else {
				System.out.println();
				System.out.printf( "%-10s %13s �˻� ����!!!\n", name, tel );
				System.out.println();
			}
			
			System.out.print( "�ּ� ���� �˻� - �̸� �Է� ( \'end\' : ���� ) : " );
			name = sc.nextLine();
		}		
		System.out.println();
	}
	
	public void printAddressBook() {
		System.out.println();
		System.out.println( "\t\t  �ּҷ�" );
		System.out.println();
		System.out.println( "-----------------------------------------------" );
		System.out.println( "��ȣ\t�̸�\t��ȭ��ȣ\te-mail" );
		System.out.println( "-----------------------------------------------" );
		System.out.print( addressBook );
		System.out.println( "-----------------------------------------------" );
		System.out.println( "\t\t\t    �� �ּ� ������ : " + addressBook.getCountAddressInfo() );
		System.out.println();
	}
}
