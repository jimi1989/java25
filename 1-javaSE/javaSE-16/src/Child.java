
public class Child {

	public void feed(Animal animal) {
		animal.eat();
	}
	
	public Animal getAnimal() {
		return new Dog();
	}
	
}
