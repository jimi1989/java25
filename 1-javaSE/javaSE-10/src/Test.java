
public class Test {

	public static void main(String[] args) {

		Cat cat = new Cat();
		
//		Cat cat;
//		cat = new Cat();
		
		Cat cat2 = new Cat();
		// 引用数据类型之间的赋值都是内存地址
		cat = cat2;
		
		cat2.setName("tom");
		
		System.out.println(cat.getName());
		
		Cat[] cats = new Cat[6];
		Cat cat3 = new Cat();
		
		cats[0] = cat3;
		
		cats[0].setName("tom1");
		cat3.setName("tom2");
		
		cats[1] = new Cat();
		cats[1].setName("jack");
		
		cats[2] = cat2;
		
		cat.setName("haha");
		
		
		/*int[] nums = new int[5];
		String[] names = new String[5];
		Cat[] cats = new Cat[5];
		
		Cat cat = new Cat();
		cats[0] = cat;
		cat.setName("xiaohua");
		cats[0].setName("xiaohei");
		
		cats[1] = new Cat();
		cats[1].setName("tom");
		
		System.out.println(cats[0].getName());
		System.out.println(cats[1].getName());
		
		System.out.println(cats[2].getName());*/
		
		/*Child ch = new Child();
		Cat c = new Cat();
		c.setName("tom");
		
		ch.feedCat(c);
		System.out.println("c的name" + c.getName());*/
		
		// 基本数据类型之间的赋值都是值传递
		/*int a = 10;
		int b = a;
		b = 20;
		System.out.println(a);
		
		// 引用数据类型之间的赋值都是内存地址
		Cat c = new Cat();
		c.setName("tom");
		
		Cat x = c;
		x.setName("cafe");
		
		System.out.println(c.getName());*/
		
		/*
		Cat cat = new Cat();
		//cat.age = -3;
		//cat.name = "tom";
		
		cat.setAge(25);
		cat.setName("cafe");
		
		//cat.age = 25;
		//System.out.println(cat.name);
		//System.out.println(cat.age);
		
		System.out.println(cat.getAge());
		System.out.println(cat.getName());
		*/
	}

}
