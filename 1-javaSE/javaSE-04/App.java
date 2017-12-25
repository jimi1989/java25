public class App {
	
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int errorCount = 0; //错误次数
		String lastErrorName = ""; //最后一次错误的账号
		//如果输入用户名和密码连续错误3次，提示”账号冻结
		while(errorCount < 3) {
			System.out.println("请输入账号：");
			String userName = input.next();
			
			System.out.println("请输入密码：");
			String password = input.next();
			
			if("tom".equals(userName) && "123123".equals(password)) {
				System.out.println("登录成功");
				errorCount = 3;
			} else {
				if(!userName.equals(lastErrorName)) {
					errorCount = 0;
					lastErrorName = userName;
				}
				errorCount++;
				if(errorCount == 3) {
					System.out.println("账号被冻结");
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		/*
		int i = 0;
		while(i < 10) {
			System.out.println(i);
			i++;
		}*/
		
		/*
		for(int i = 0;i < 10;i++) {
			System.out.println(i);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String name;
		do {
			System.out.println("请输入姓名:");
			name = input.next();
			
			if(!"quit".equals(name)) {
				System.out.println("您的姓名是:" + name);
			}
		}while(!"quit".equals(name));
		
		*/
		
		
		
		
		
		
		/*
		//先执行，再判断
		int count = 10;
		
		do{
			System.out.println("hello," + count);
			count--;
		}while(count > 0);
		*/
		
		
		
		
		
		/*
		//1. 获取班级总人数
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("请输入班级总人数：");
		int count = input.nextInt(); //总人数
		
		//2. 输入每个同学的成绩，将成绩累加获得总成绩
		int total = 0; //总成绩
		int c = 0;
		
		int i = 1;
		while(i <= count) {
			
			System.out.println("请输入第" + i +"个同学的成绩：");
			int score = input.nextInt();
			
			if(score >= 80) {
				c++;
				total += score;//total = total + score;
			}
			
			
			i++;
		}
		
		//3. 使用总成绩除以班级总人数，获取平均成绩
		int avg = total / c;
		//4. 输出平均成绩
		System.out.println("总成绩为：" + total + " 平均成绩为：" + avg);
		*/
		
		
		
		
		
		
		
		
		
		
		
		/*
		int count = 10;
		while(count > 20) {
			System.out.println("xxx");
			count++;
		}
		*/
		//.....
		
		
		/*
		int count = 1;
		while(count <= 100) {
			System.out.println(count + "只青蛙" + count + "张嘴，" + (count * 2) +"只眼睛" + (count * 4) +"条腿");
			count++;
		}
		*/
		
		
		/*
		int count = 0; //初始化
		while(count < 3) { //条件判断部分
			System.out.println("Hello"); 
			count++; //更改变量
		}
		*/
		
		
	}
	
}