
public class Son extends Father{

	public Son() {
		super("father");
		System.out.println("Son create...");
	}
	
	public Son(String name) {
		System.out.println("");
	}
	
	public void speakEnglish() {
		super.sayHello();
		System.out.println("what is your name?");
	}
	
	@Override
	public void sayHello() {
		System.out.println("hello");
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
