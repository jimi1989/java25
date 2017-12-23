
public class Cat extends Animal{

	private String name;
	private int age;
	
	/*public Cat() {
		
	}*/
	
	public Cat() {
		this("moren",100);
//		System.out.println("abc");
	}
	
	public Cat(String name) {
		this.name = name;
		this.age = 5;
		System.out.println("Cat对象创建..." + name);
	}
	
	public Cat(String name, int age) {// 方法签名
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("cat eat...");
	}
	
	
	public void sayHello() {
		System.out.println(name +" hello, i am " + age + " years old");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
