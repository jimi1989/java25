
public class Hello {
	
	public static void main(String[] args) {
		
		int score = 66;
		
		if(score > 90) {
			System.out.println("A");
		} else if(score >= 80 && score < 90) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入值：");
		int level = input.nextInt();
		*/
		
		/*
		*	变量部分必须是int、char、String类型
		*   只能做等值判断，值部分不能重复
		*/
		/*
		switch(level) {
			case 1:
				System.out.println("笔记本电脑-1");
				System.out.println("笔记本电脑-2");
				break;
			case 2:
				System.out.println("手机");
				break;
			case 3:
				System.out.println("Head first Java");
				break;
			default:
				System.out.println("鼓励奖");
		}
		*/
		
		//多重选择
		/*if(level == 1) {
			System.out.println("笔记本电脑");
		} else if(level == 2) {
			System.out.println("手机");
		} else if(level == 3) {
			System.out.println("Head first Java");
		} else {
			System.out.println("鼓励奖");
		}*/
		
		
		
		/*
		if(level == 1) {
			System.out.println("笔记本电脑");
		} else {
			if(level == 2) {
				System.out.println("手机");
			} else {
				if(level == 3) {
					System.out.println("Head first Java");
				} else {
					System.out.println("鼓励奖");
				}
			}
		}
		*/
		
		
		
		
		
		
		//int a = 10;
		//int b = 20;
		//三元表达式
		//int c = a > b ? a : b;
		
		/*
		if(a > b) {
			c = a;
		} else {
			c = b;
		}*/
		
		//System.out.println(c);
		
		
		
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入账号：");
		String name = input.next();
		
		System.out.println("请输入密码：");
		String password = input.next();
		
		if("tom".equals(name) && "123123".equals(password)) {
			System.out.println("登录成功");
		} else {
			System.out.println("账号或密码错误");
		}
		*/
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入您的姓名：");
		String name = input.next();
		
		if("Tom".equals(name)) {
			System.out.println("Welcome Tom");
		}
		*/
		
		//if(name.equals("Tom")) {
		//	System.out.println("Welcome Tom");
		//}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//1. 获取用户的消费金额
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入消费金额：");
		int money = input.nextInt();
		
		//2. 判断金额是否满足-20的条件 > 100
		if(money > 100) {
			//money -= 20; // money = money - 20;
			int temp = money / 100;
			money = money - temp * 20;
		}
		
		//3. 输出用户应该支付的金额
		System.out.println("您应支付：" + money + "元");
		*/
		
		
		
		//boolean result = 1 != 1;
		//System.out.println(result);
		
		/*
		if(false) {
			System.out.println("if代码块运行了 - 1");
			System.out.println("if代码块运行了 - 2");
			System.out.println("if代码块运行了 - 3");
		}
		
		System.out.println("The end!");
		*/
		
	} 
	
}