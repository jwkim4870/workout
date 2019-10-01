
public class Cat extends Animal {
//private String name;
	private double weight;
	
	public Cat() {
		super();
		System.out.println( "Cat instance 생성");
	}

	public Cat( String name, double weight ) {
		super( name );
		this.weight = weight;
		System.out.println( "Cat [ " + name + " : " + weight + " kg ] instance 생성" );
	}
	
	public void playCat() {
		System.out.println( "Play Cat....." );
	}

	public void eat() {
		System.out.println( "Cat [ " + name + " ]가 먹다..." );
		
	}
	
    public void run() {
    	System.out.println( "Cat [ " + name + " ]가 달린다..." );
    }
   
}
