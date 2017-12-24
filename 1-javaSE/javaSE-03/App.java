public class App {
	
	public static void main(String[] args) {
		//0. 创建输入器
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		//1. 需要两个数字
		System.out.println("请输入第一个数字：");
		int a = input.nextInt();
		System.out.println("请输入第二个数字:");
		int b = input.nextInt();
		
		//2. 交换
		// a 1 b 5
		a = a + b;
		b = a - b;
		a = a - b;
		//int c = a;
		//a = b;
		//b = c;
		
		//3. 结果输出
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
	}
	
}