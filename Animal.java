
public class Animal {
	protected String name;  //protected: 상속관계에있는 클래스끼리는 직접접근을 허용하는 타입. 상속관계가 아니면 기존 private과 동일함. 서브클래스가 슈퍼클래스의 private을 접근할때 쓰임.              
	
	public Animal() {
		this.name = "동물";
		System.out.println( "Animal instance 생성");
	}
	
	public Animal( String name ) {
		this.name = name;
		System.out.println( "Animal instance 생성");
	}
	
	public void eat() {
		System.out.println( "Animal [ " + name + " ]이 먹다.");
	}
	
	public void run() {
		System.out.println( "Animal [ " + name + " ]이 달린다.");
	}
}
