
public class Day7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog( "������", 2 );
		Cat cat = new Cat( "�����", 3.9 );
		
		System.out.println();
		dog.eat();
		cat.eat();
		System.out.println();
		dog.run();
		cat.run();
		
		System.out.println();
		Animal[] animals = new Animal[ 2 ];
		animals[ 0 ] = new Dog( "������2", 1 );
		animals[ 1 ] = new Cat( "�����2", 1.5);
		for ( int i = 0; i < 2; i++ ) {
			animals[ i ].eat(); //overriding
		}
		
		for ( int i =0; i < 2; i++) {
			if ( animals[i] instanceof Dog ) { // animals[i]�ν��Ͻ���  Dog Ŭ���� Ÿ���̶�� Dog�� ����ȯ�ؼ� �޼ҵ� ȣ���϶�. Super class���� Sub class�� ���� ����ȯ �ؾ��ϰ� � sub class�̳� �����ϴ� ���� instanceof.
				((Dog)animals[ 0 ]).playDog();
			} else if ( animals[i] instanceof Cat ) {
		        ((Cat)animals[ 0 ]).playCat(); //
			}
		}
	}

}
