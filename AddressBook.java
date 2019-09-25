import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private int countAddressInfo;
	
	public List<AddressInfo> addressbook;	// AddressBook과 AddressInfo간의 관계
	
	public AddressBook() {
		addressbook = new ArrayList<>();
	}
		
	public int getCountAddressInfo() {
		return countAddressInfo;
	}

	public AddressInfo getAddressInfo( int index ) {
		return addressbook.get( index );
	}
	
	public void appendAddressInfo( AddressInfo addressInfo ) {
		addressbook.add( addressInfo );
		++countAddressInfo;
	}
	
	public int removeAddressInfo( String name, String tel ) {
		int index = searchAddressInfo( name, tel );
		if ( index > -1 ) {
			addressbook.remove( index );
			--countAddressInfo;
		}
		
		return index;
	}
	
	public int searchAddressInfo( String name, String tel ) {
		int index = -1;
		AddressInfo addressInfo;
		for ( int i = 0; i < addressbook.size(); ++i ) {
			addressInfo = addressbook.get( i );
			if ( addressInfo.getName().equals( name ) &&
				 addressInfo.getTel().equals( tel ) )  {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for ( AddressInfo value : addressbook ) {
			str.append( String.format( "%5d ", value.getNo() ) );
			str.append( String.format( "%-10s ", value.getName() ) );
			str.append( String.format( "%13s ", value.getTel() ) );
			str.append( String.format( "%-30s\n", value.getEmail() ) );
		}
		
		return str.toString();
	}
}











