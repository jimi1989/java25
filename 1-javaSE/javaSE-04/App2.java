public class App2 {
	
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String lastErrorName = "";
		int errorCount = 0;
		
		while(true) {
			System.out.println("请输入账号：");
			String userName = input.next();
			
			System.out.println("请输入密码：");
			String password = input.next();
			
			if("tom".equals(userName) && "123123".equals(password)) {
				System.out.println("登录成功");
				break;
			} else {
				//如果当前用户名和上次错误的一致，错误次数+1
				if(!lastErrorName.equals(userName)) {
					//如果当前用户名和上次错误的不一致，记录当前错误的名字，并将错误次数归零
					errorCount = 0;
					lastErrorName = userName;
				}
				errorCount++;
				if(errorCount == 3) {
					System.out.println("账号冻结");
					break;
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int i = 10;
		while(i > 0) {
			i--;
			if(i == 5) {
				//break;
				continue;
			}
			System.out.println(i);
			
		}
		
		System.out.println("The end!");
		*/
	}
	
	
}