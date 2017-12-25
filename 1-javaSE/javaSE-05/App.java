public class App {
	
	public static void main(String[] args) {
		
		
		java.util.Random rd = new java.util.Random();
		
		//System.out.println(rd.nextInt(100)); // 0(包含) - 100 （不包含）
		
		String[] names = {"tom","jerry","alex","rose","moon"};
		int index = rd.nextInt(names.length);
		
		System.out.println(names[index]);
		
		
		
		
		
		
		
		
		//排序算法（冒泡排序）
		/*
		int[] nums = {45,23,678,1234,34,67,986};
		
		for(int i = 0;i < nums.length-1;i++) {
			
			for(int j = 0;j < nums.length-i-1;j++) {
				if(nums[j] < nums[j+1]) {
					int c = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = c;
				}
			}
			
			
		}
		
		for(int n : nums) {
			System.out.println(n);
		}
		*/
		
		
		
		/*
		String[] names = {"A","B","C","D"};
		
		for(String name : names) {
			System.out.println(name);
		}
		
		for(int i = 0;i < names.length;i++) {
			if(i % 2 == 0) {
				String name = names[i];
				System.out.println(name);
			}
		}
		
		*/
		
		
		//int[] nums = {45,23,678,1234,34,67,986};
		
		//迭代
		//JDK5.0 <= foreach 
		//for(int n : nums) {
		//	System.out.println(n);
		//}
		
		
		
		//for(int i = 0;i < nums.length;i++) {
		//	int n = nums[i];
		//	System.out.println(n);
		//}
		
		
		//int[] nums = {45,23,678,1234,34,67,986};
		//int max = nums[0];
		
		//for(int i = 1;i < nums.length;i++) {
			/*if(max < nums[i]) {
				max = nums[i];
			}*/
		//	max = max < nums[i] ? nums[i] : max;
		//}
		
		//System.out.println("最大值为:" + max);
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int[] nums = new int[12];
		
		//System.out.println(nums.length);
		// nums.length
		
		
		for(int i = 0;i < nums.length;i++) {
			System.out.println("请输入第" + i + "个数");
			nums[i] = input.nextInt();
		}
		
		//输出数组的内容
		for(int i = 0;i < nums.length;i++) {
			System.out.println(nums[i]);
		}
		*/
		
		
		
		
		
		
		//String[] names = new String[5];
		//names[5] = "zzz";
		
		
		
		
		
		
		
		
		
		
		
		/*
		String[] names = new String[5];
		System.out.println(names[3]);
		
		//if(names[3] != null && names[3].equals("abc")) {
		if("abc".equals(names[3])) {
			
			System.out.println("hello，Array");
		}
		*/
		
		
		//int[] nums = new int[3];
		
		//System.out.println(nums[2]);
		
		
		
		//1. 数组的长度是5
		//2. 分别给每个下标赋值
		//String[] names = new String[]{"A","X","V","U","Q"};
		
		
		
		//1. 数组的长度是5
		//2. 分别给每个下标赋值
		//String[] names = {"A","X","V","U","Q"};
		//names[3] = "T";
		
		
		
		
		
		
		//数据类型 变量名 = 值;
		//int[] nums = new int[10];
		//String[] names = new String[5]; //声明一个数组
		//names[1] = "Jack"; //给数组下标赋值
		
		//System.out.println(names[1]); //获取数组下标对应的值
		
		
		
		//int nums[] = new int[10]; 不推荐
		
		
	}
	
}