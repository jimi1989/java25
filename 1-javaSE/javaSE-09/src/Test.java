
public class Test {

	public static void main(String[] args) {
		
		CellPhoneAppV3 app = new CellPhoneAppV3();
		app.startup();
		
		/*CellPhoneAppV2 app = new CellPhoneAppV2();
		app.startup();*/
		
		/*CellPhoneAppV1 app = new CellPhoneAppV1();
		String phoneNo = app.getPhpneNo("jack1");
		System.out.println("该联系人的电话号码为:" + phoneNo);*/
		
		/*PC pc = new PC();
		pc.playMusic("东方红");
		pc.chat("小红");*/
		
		/*MyMath math = new MyMath();
		int[] numbers = {23,543,12,344,6744,235,1223,87};
		int max = math.getMax(numbers);
		
		System.out.println(max);*/
		
		/*java.util.Scanner input = new java.util.Scanner(System.in);
		MyMath math = new MyMath();
		
		System.out.println("请输入第一个数:");
		int numA = input.nextInt();
		
		System.out.println("请输入第二个数:");
		int numB = input.nextInt();
		
		System.out.println("请输入元算符号(+-* /):");
		String symbol = input.next();
		
		int res = 0;
		boolean flag = true;
		
		if("+".equals(symbol)) {
			res = math.add(numA, numB);
		} else if("-".equals(symbol)) {
			res = math.sub(numA, numB);
		} else if("*".equals(symbol)) {
			res = math.mutil(numA, numB);
		} else if("/".equals(symbol)) {
			if(numB == 0) {
				flag = false;
				System.out.println("除数不能为0");
			} else {
				res = math.division(numA, numB);
			}
		} else {
			flag = false;
			System.out.println("符号输入有误！");
		}
		
		if(flag) {
			System.out.println("运算结果为：" + res);
		}
		*/
		
	}

}
