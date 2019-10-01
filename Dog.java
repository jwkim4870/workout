
public class Dog extends Animal {
	//private String name;
	private int age;
	
	public Dog() {
		super();
		System.out.println( "Dog instance ����");
	}

	public Dog( String name, int age ) {
		super( name );
		this.age = age;
		System.out.println( "Dog [ " + name + " : " + age + " ] instance ����" );
	}
	
	public void playDog() {
		System.out.println( "Play Dog....." );
	}
	
	public void eat() {
		super.eat(); 
		System.out.println( "Dog [ " + name + " ]�� �Դ�..." );
		
	}
	
    public void run() {
    	System.out.println( "Dog [ " + name + " ]�� �޸���..." );
    }
}
