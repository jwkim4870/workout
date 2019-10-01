
public class Dog extends Animal {
	//private String name;
	private int age;
	
	public Dog() {
		super();
		System.out.println( "Dog instance 생성");
	}

	public Dog( String name, int age ) {
		super( name );
		this.age = age;
		System.out.println( "Dog [ " + name + " : " + age + " ] instance 생성" );
	}
	
	public void playDog() {
		System.out.println( "Play Dog....." );
	}
	
	public void eat() {
		super.eat(); 
		System.out.println( "Dog [ " + name + " ]가 먹다..." );
		
	}
	
    public void run() {
    	System.out.println( "Dog [ " + name + " ]가 달린다..." );
    }
}
