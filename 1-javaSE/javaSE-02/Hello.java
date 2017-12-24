
public class Hello {
	
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入姓名:");
		String name = input.next();
		
		System.out.println("请输入第一个数字:");
		//命令提示符中输入的值赋值给变量numA
		int numA = input.nextInt(); 
		
		System.out.println("请输入第二个数字:");
		int numB = input.nextInt();
		
		int result = numA + numB;
		System.out.println(name + "结果为：" + result);
		
		
		
		/*
		int a = 10;
		int b = 11;
		int result = a + b;
		
		System.out.println(result);
		*/
		
		
		//String str = (3 + 4) + "= 3 + 4";
		//System.out.println(str);
		
		//String str = "3 + 4 = " + (3 + 4);
		//System.out.println(str);
		
		/*
		int a = 2;
		char ch = (char)a;
		System.out.println(ch);
		*/
		
		//char ch = 'b';
		//int a = ch;
		
		//System.out.println(a);
		
		
		
		//int a = 123456789;
		//float f = a;
		
		//System.out.println(f);
		
		
		
		//结果类型
		//int result = (int)(10 / 3.0); 
		//int result = 10 / (int)3.0;
		//System.out.println(result);
		
		
		//强制类型转换
		//long b = 100L;
		//int a = (int)b;
		
		//System.out.println(a);
		
		
		//自动类型转换
		//int a = 10;
		//long b = a;
		
		//System.out.println(b);
		
		
		
		
		/*
		int a = 10;
		int b = 10 + a++;
		
		System.out.println(a);
		System.out.println(b);
		*/
		
		
		//int a = 10;
		//int b = a++;
		//int b = a;
		//a++;
		//int b = ++a;
		//++a;
		//int b = a;
		
		//System.out.println(a);
		//System.out.println(b);
		
		
		
		//int a = 10;
		//a = a + 1;
		//a += 1;
		//a++;
		//++a;
		
		//System.out.println(a);
		
		
		
		//int a = 10;
		//a = a + 2;
		//a += 2;
		//a -= 2;
		//a *= 2;
		//a /= 2; // a = a / 2;
		//a %= 2; // a = a % 2;
		
		//System.out.println(a);
		
		
		//double result = 10 / 3.0; ?????????????
		//System.out.println(result);
		
		
		
		/*
		int a = 10;
		int b = 12;
		int c = 18;
		
		System.out.println(a + "," + b);
		*/
		
		
		
		
		
		//int age = 32;
		//String name = "James";
		//System.out.println("我的年龄是" + age + ",名字是" + name);
		
		
		
		//一次性声明了两个变量并赋值
		//String name = "Tom",address = "美国";
		//System.out.println(name);
		
		//String name,address; //一次性声明了两个变量
		//name = "Tom";
		//address = "美国";
		
		
		//String name = "Tom";
		//String address = "美国";
		
		
		
		
		//System.out.println("name");
		
		//String name = "李斯李斯李斯李斯李斯李斯李斯";
		//System.out.println(name);
	
		
		
		//int a = 234.456;
		
		
		//boolean result = true;
		//result = false;
		
		//boolean result = 12 < 45;
		//System.out.println(result);
		
		
		
		
		//char name = 'A';
		//System.out.println(name);
		
		
		
		//double result = 2.0 - 1.1;
		//System.out.println(result);
		
		//float numA = 345.234F;
		//System.out.println(numA);
		
		//double numA = 345.234;
		//System.out.println(numA);
		
		
		
		//
		//int a = 012; //0xA;
		//System.out.println(a);
		
		
		//short sh = 3456;
		//System.out.println(sh);
		
		//byte b = 123;
		//System.out.println(b);
		
		//long numA = 45L;
		//System.out.println(numA);
		
		
		// 数据类型 变量名 = 值;
		//int numA; //声明了变量，但没有赋值
		//numA = 23; //给变量numA赋值
		//numA = 45;
		//System.out.println(numA);
		
		
		
		/*
		int numA = 23;
		int numB = 34;
		int numC = numA + numB;
		
		System.out.println(numA);
		System.out.println(numB);
		System.out.println(numC);
		*/
		
		
	} 
	
}