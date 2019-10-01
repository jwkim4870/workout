
public class Day7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog( "강아지", 2 );
		Cat cat = new Cat( "고양이", 3.9 );
		
		System.out.println();
		dog.eat();
		cat.eat();
		System.out.println();
		dog.run();
		cat.run();
		
		System.out.println();
		Animal[] animals = new Animal[ 2 ];
		animals[ 0 ] = new Dog( "강아지2", 1 );
		animals[ 1 ] = new Cat( "고양이2", 1.5);
		for ( int i = 0; i < 2; i++ ) {
			animals[ i ].eat(); //overriding
		}
		
		for ( int i =0; i < 2; i++) {
			if ( animals[i] instanceof Dog ) { // animals[i]인스턴스가  Dog 클래스 타입이라면 Dog로 형변환해서 메소드 호출하라. Super class에서 Sub class로 갈때 형변환 해야하고 어떤 sub class이냐 지정하는 것은 instanceof.
				((Dog)animals[ 0 ]).playDog();
			} else if ( animals[i] instanceof Cat ) {
		        ((Cat)animals[ 0 ]).playCat(); //
			}
		}
	}

}
