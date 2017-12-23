import java.util.ArrayList;
import java.util.List;

public class Bank {

	private static Bank bank;
	
	private Bank(){}
	
	public static Bank getInstance() {
		if(bank == null) {
			bank = new Bank();
		}
		return bank;
	}
	
	
	// 存放所有账户的值，相当于数据库
	private List<Account> accounts = new ArrayList<>();
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * 保存账户
	 */
	public boolean saveAccount(Account acc) {
		return accounts.add(acc);
	}
	
	
	/**
	 * 校验该用户名是否可用
	 * @param accountName 要校验的账户
	 * @return true:该账户可用 false:不可用
	 */
	public Account findByName(String accountName) {
		for(int i = 0; i < accounts.size(); i++) {
			Account acc = accounts.get(i);
			if(acc != null && accountName.equals(acc.getName())) {
				return acc;
			}
		}
		return null;
		
	}
	
	/**
	 * 根据用户名密码查找对应的账户
	 * @params name 登录的账户  password 登录的密码 
	 * @return true:账户密码正确  false:账户或者密码错误
	 * 
	 */
	public Account findByNameAndPassword(String name, String password) {
		
		for(int i = 0; i < accounts.size(); i++) {
			Account acc = accounts.get(i);
			if(acc != null && name.equals(acc.getName()) && password.equals(acc.getPassword())){
				return acc;
			}
		}
		return null;
		
	}


}
