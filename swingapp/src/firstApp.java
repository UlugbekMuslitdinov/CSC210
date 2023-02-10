import graphics.*;

public class firstApp {
	
	public static void main(String[] args)
	{
		Dog bob = new Dog();
		Cat stan = new Cat();
		
		bob.makeSound();
		stan.makeSound();
		
		graphics Graph = new graphics();
		
		System.out.println("main end");
	}
}

class Dog {
	Dog() {System.out.println("Dog default ctor");}
	/**
	 * 
	 * @param n
	 */
	void makeSound(String[] n) {System.out.println("Woof");}
}

/**
 * 
 * @author User
 *
 */
class Cat {
	Cat() {System.out.println("Cat default ctor");}
	void makeSound() {System.out.println("Meow");}
}