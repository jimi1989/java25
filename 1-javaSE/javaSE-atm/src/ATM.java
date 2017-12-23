import java.util.List;

public class ATM {
	
	// 必须保证bank对象只用一个
	private Bank bank = Bank.getInstance();
	private java.util.Scanner input = new java.util.Scanner(System.in);
	private Account currAccount = null;// current  当前登录的account对象

	public void startup() {
		
		System.out.println("1. 开户");
		System.out.println("2. 插卡");
		System.out.println("3. 系统管理");
		System.out.println("4. 退出系统");
		System.out.println("请选择菜单：");

		int index = input.nextInt();
		
		if(1 == index) {
			createAccount();
		} else if(2 == index) {
			insertCard();
		} else if(3 == index) {
			sysManage();
		} else if(4 == index) {
			System.exit(0);// 系统正常退出
		} else {
			System.out.println("选择错误，请重新输入");
		}

		startup();
		
	}

	/**
	 * 系统管理
	 */
	private void sysManage() {
		//1.输入管理员密码
		System.out.println("请输入管理员密码:");
		String password = input.next();
		
		//2.判断管理员密码是否正确
		if("123456".equals(password)) {
			//3.如果密码正确，显示管理员二级菜单
			System.out.println("登录成功");
			showSysMenu();
		} else {
			//4.如果密码不正确，提示重新输入
			System.out.println("管理员密码错误，请重新输入");
		}
		sysManage();
	}

	/**
	 * 管理员二级菜单
	 */
	private void showSysMenu() {
		System.out.println("1. 显示所有账户");
		System.out.println("2. 冻结账户");
		System.out.println("3. 恢复账户");
		System.out.println("4. 退出");
		System.out.println("请选择:");

		int index = input.nextInt();
		
		switch(index) {
			case 1: 
				showAllAccounts();
				break;
			case 2:
				frozenAccount();
				break;
			case 3:
				recoverAccount();
				break;
			case 4:
				startup();
				break;
			default:
				System.out.println("选择错误，请重新选择");
				break;
		}
		
		showSysMenu();
		
	}

	/**
	 * 恢复账户
	 */
	private void recoverAccount() {
		//1.显示所有已被冻结的账户
		List<Account> accs = bank.getAccounts();
		
		System.out.println("账户名\t\t状态");
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null && !acc.isEnable()) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "正常" : "异常"));
			}
		}
		
		//2.管理员输入冻结账户名
		System.out.println("请输入要恢复的账户:");
		String name = input.next();
		
		//3.判断该账户是否存在
		Account acc = bank.findByName(name);
		
		if(acc != null) {
			//4.如果存在，修改该对象的enable属性为true
			acc.setEnable(true);
			System.out.println("恢复成功");
		} else {
			//5.如果不存在，提示错误
			System.out.println("该账户不存在");
		}
	}

	/**
	 * 冻结账户
	 */
	private void frozenAccount() {
		//1.显示所有未被冻结的账户
		List<Account> accs = bank.getAccounts();
		
		System.out.println("账户名\t\t状态");
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null && acc.isEnable()) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "正常" : "异常"));
			}
		}
		
		//2.管理员输入冻结账户名
		System.out.println("请输入要冻结的账户:");
		String name = input.next();
		
		//3.判断该账户是否存在
		Account acc = bank.findByName(name);
		
		if(acc != null) {
			//4.如果存在，修改该对象的enable属性为false
			acc.setEnable(false);
			System.out.println("冻结成功");
		} else {
			//5.如果不存在，提示错误
			System.out.println("该账户不存在");
		}

	}

	/**
	 * 显示所有账户
	 */
	private void showAllAccounts() {

		//1.获得accounts数组
		List<Account> accs = bank.getAccounts();
		
		System.out.println("账户名\t\t状态");
		//2.迭代输出accounts数组的对象的值
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "正常" : "异常"));
			}
		}
		
	}

	/**
	 * 插卡(登录)
	 */
	private void insertCard() {
		//1.用户输入账户、密码
		System.out.println("请输入账户:");
		String name = input.next();
		
			System.out.println("请输入密码:");	String password = input.next();
		
		//2.判断账户、密码输入是否正确，判断账户状态
			currAccount = bank.findByNameAndPassword(name, password);// accounts[i]
		
			if(currAccount != null) {
			//判断账户状态
			if(currAccount.isEnable()) {
				//2.1输入正确并且状态正常，显示二级菜单
			System.out.println("登录成功");
				showAccMenu();
			} else {
				System.out.println("账户状态异常，请联系管理员");
			}
			
			
		} else{
			//2.2输入错误，提示重新输入
			System.out.println("账户或者密码错误，请重新输入");
			insertCard();
		}
		
	}

	/**
	 * 账户的二级菜单
	 */
	private void showAccMenu() {

		System.out.println("1. 查询余额");
		System.out.println("2. 取款");
		System.out.println("3. 存款");
		System.out.println("4. 转账");
		System.out.println("5. 修改密码");
		System.out.println("6. 退出");
		System.out.println("请选择菜单");
		
		int index = input.nextInt();
		
		if(1 == index) {
			showCurrentMoney();
		} else if (2 == index) {
			drawMoney();
		} else if (3 == index) {
			inMoney();
		} else if (4 == index) {
			transMoney();
		} else if (5 == index) {
			changePassword();
		} else if (6 == index) {
			startup();
		} else {
			System.out.println("输入错误，请重新输入");
			showAccMenu();
		}
		
		
	}

	/**
	 * 转账
	 */
	private void transMoney() {
		// 1.用户输入转入账户
		System.out.println("请输入转入账户:");
		String name = input.next();
		
		// 2.校验该账户是否存在
		Account inAccount = bank.findByName(name);
		// 3.如果转入账户存在
		if(inAccount != null) {
			// 3.1 用户输入转账金额
			System.out.println("请输入转账金额:");
			int money = input.nextInt();
			
			// 3.2 判断转账金额是否>0并且小于当前登录账户currAccount账户的余额
			if(money < 0) {
				System.out.println("转账金额设置不正确");
			} else if(money > currAccount.getMoney()) {
				System.out.println("余额不足");
			} else {
				// 3.3修改当前登录账户currAccount的余额= 余额 - 转账金额
				currAccount.setMoney(currAccount.getMoney() - money);
				// 3.4 修改转入账户inAccount的余额= 他自己的余额  + 转账金额 
				inAccount.setMoney(inAccount.getMoney() + money);
				System.out.println("转账成功");
			}
		} else {
			// 4.如果转入账户不存在，提示信息
			System.out.println("转入账户不存在，请重新输入");
		}
		
		showAccMenu();
	}

	/**
	 * 修改密码
	 */
	private void changePassword() {

		//1. 用户输入原始密码
		System.out.println("请输入原始密码:");
		String oldPassword = input.next();
		
		//2. 判断原始密码是否正确
		if(oldPassword.equals(currAccount.getPassword())) {
			//3. 如果正确提示用户输入新密码
			System.out.println("请输入新密码:");
			String newPassword = input.next();
			
			//4. 设置当前登录currAccount对象的password属性
			currAccount.setPassword(newPassword);
			System.out.println("密码设置成功,请重新登录");
			insertCard();
		} else {
			System.out.println("原始密码不正确");
		}
		//5. 显示二级菜单
		showAccMenu();
	}

	/**
	 * 存款
	 */
	private void inMoney() {

		//1. 用户输入存款金额
		System.out.println("请输入存款金额:");
		int money = input.nextInt();
		
		//2. 判断金额是否>0
		if(money < 0) {
			System.out.println("存款金额输入不正确,请重新输入");
		} else {
			//3. 设置当前登录账户currAccount的money属性为(余额 + 存款金额)
			currAccount.setMoney(currAccount.getMoney() + money);
			System.out.println("存款成功");
		}
		//4. 显示二级菜单
		showAccMenu();
	}

	/**
	 * 取款
	 */
	private void drawMoney() {
		// 1. 用户输入取款金额
		System.out.println("请输入取款金额:");
		int money = input.nextInt();
				
		// 2. 判断金额是否>0
		if(money < 0) {
			System.out.println("取款金额输入错误，请重新输入");
		} else if(money > currAccount.getMoney()) {
			// 3. 判断金额是否<当前余额
			System.out.println("余额不足 ");
		} else {
			// 4. 设置当前currAccount的money属性为(余额 - 取款金额)
			currAccount.setMoney(currAccount.getMoney() - money);
			System.out.println("取款成功");
		}
		
		// 5. 显示二级菜单
		showAccMenu();
		
	}

	/**
	 * 查询余额
	 */
	private void showCurrentMoney() {
		System.out.println("当前账户余额为:" + currAccount.getMoney());
		showAccMenu();
	}

	/**
	 * 开户
	 */
	private void createAccount() {
		//1.用户输入账户名
		System.out.println("请输入账户:");
		String name = input.next();
		
		//2.校验该账户名是否可用
		Account acc = bank.findByName(name);
		
		if(acc == null) {
			//2.1 如果该账户可用，用户输入密码
			System.out.println("请输入密码：");
			String password = input.next();
			
			//保存账户:封装Account对象，保存到bank对象的accounts数组中
			Account account = new Account();
			account.setName(name);
			account.setPassword(password);
			
			boolean isSave = bank.saveAccount(account);
			
			if(isSave) {
				System.out.println("开户成功");
			} else {
				System.out.println("开户失败，请联系管理员");
			}
			
			
		} else {
			//2.2 如果账户不可用，提示账户被占用，重新输入
			System.out.println("账户已存在，请重新输入");
			createAccount();
		}
		
	}
	
	
}
