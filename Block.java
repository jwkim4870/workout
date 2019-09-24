package core;

import Util.Util;

public class Block {
	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private String data; //�ŷ�����
	
	public Block( int blockID, String previousBlockHash, int nonce, String data) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.data = data;
	}

	public int getBlockID() {
		return blockID;
	}

	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void getInformation() {
		System.out.println( "--------------------------------" );
		System.out.println( "��� ��ȣ    : " + getBlockID() );
		System.out.println( "���� �ؽ�    : " + getPreviousBlockHash() );
		System.out.println( "ä�� ������ : " + getNonce() );
		System.out.println( "��� ������ : " + getData() );
		System.out.println( "��� �ؽ�   : " + getBlockHash() );
		System.out.println( "--------------------------------" );
	}
	
	public String getBlockHash() { //����� ����. ���� ����� ����� �����Ϳ� ���� ����� ���� ����.
		return Util.getHash( nonce + data + previousBlockHash );
	}
	
	public void mine() {
		while ( true ) {
			if ( getBlockHash().substring( 0, 4 ).contentEquals( "0000" ) ) {
				System.out.println( blockID + "��° ����� ä���� ����~~~");
				break;
			}
			++nonce;
		}
	}
}
