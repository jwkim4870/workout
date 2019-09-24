package core;

import Util.Util;

public class BlockChainTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( Util.getHash( "1" ));
		/*
		int nonce = 0;
		
		while ( true ) {
			if ( Util.getHash( nonce + "" ).substring( 0, 6 ).contentEquals( "000000" ) ) {
				System.out.println( "정답 : " + nonce );
				break;
			}
			++nonce;
		} //채굴 기본코드. 앞자리 000000이 만나기까지 계속 Hash값 테스트 실시.
*/
		Block block = new Block( 1, null, 0, "데이터");  //데이터: 거래정보  
		block.mine();
		block.getInformation();
		
		Block block1 = new Block( 2, block.getBlockHash(), 0, "데이터" );
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block( 3, block1.getBlockHash(), 0, "데이터" );
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block( 4, block2.getBlockHash(), 0, "데이터a" );
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block( 5, block3.getBlockHash(), 0, "데이터" );
		block4.mine();
		block4.getInformation();
	}

}
