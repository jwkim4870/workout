
public class Cat extends Animal {
//private String name;
	private double weight;
	
	public Cat() {
		super();
		System.out.println( "Cat instance ����");
	}

	public Cat( String name, double weight ) {
		super( name );
		this.weight = weight;
		System.out.println( "Cat [ " + name + " : " + weight + " kg ] instance ����" );
	}
	
	public void playCat() {
		System.out.println( "Play Cat....." );
	}

	public void eat() {
		System.out.println( "Cat [ " + name + " ]�� �Դ�..." );
		
	}
	
    public void run() {
    	System.out.println( "Cat [ " + name + " ]�� �޸���..." );
    }
   
}
