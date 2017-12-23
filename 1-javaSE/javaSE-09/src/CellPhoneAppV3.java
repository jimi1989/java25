
/**
 * 电话号码本第三版
 * @author jimi_jin
 * @version 3.0
 */
public class CellPhoneAppV3 {

	Person[] persons = new Person[50];
			
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	/**
	 * 程序的入口
	 */
	public void startup() {
		
		System.out.println("1.保存");
		System.out.println("2.查找");
		System.out.println("3.退出");
		System.out.println("请选择");
		
		int index = input.nextInt();
		
		if(1 == index) {
			save();
		} else if(2 == index) {
			find();
		} else if(3 == index) {
			System.exit(0); //系统正常退出
		} else {
			System.out.println("选择有误，重新输入");
		}
		
		startup();
		
	}
	
	/**
	 * 保存电话号码
	 */
	private void save() {
		// 1.用户输入联系人姓名
		System.out.println("请输入联系人姓名");
		String name = input.next();
		
		boolean flag = false;
		
		// 3.在数组中找到第一个为null的空间进行保存
		for(int i = 0; i < persons.length; i ++) {
			if(persons[i] == null) {
				
				// 2.用户输入联系人电话
				System.out.println("请输入联系人电话");
				String phoneNo = input.next();
				
				// 3.用户输入联系人qq
				System.out.println("请输入联系人qq");
				String qq = input.next();
				
				Person person = new Person();
				person.setName(name);
				person.setNum(phoneNo);
				person.setQq(qq);
				
				persons[i] = person;
				
				flag = true;
				
				break;
			} 
			
		}
		
		// 4.提示保存成功或者内存已满
		if(flag) {
			System.out.println("保存成功");
		} else {
			System.out.println("内存已满");
		}
	}
	
	/**
	 * 查找电话号码
	 */
	private void find() {
		//1.用户输入联系人姓名
		System.out.println("请输入联系人姓名");
		String name = input.next();
		
		Person person = null;
		//2.在names数组中查找对应的联系人姓名
		for(int i = 0; i < persons.length; i++) {
			//if(persons[i] != null && persons[i].getName() != null && persons[i].getName().equals(name)) {
			if(persons[i] != null && name.equals(persons[i].getName())) {
				person = persons[i];
				break;
			}
			
		}
		//4.打印找到的电话号码或查无此人
		if(person != null) {
			System.out.println("该联系人的电话为：" + person.getNum());
			System.out.println("该联系人的QQ为：" + person.getQq());
		} else {
			System.out.println("查无此人");
		}
	}
	
	
}
