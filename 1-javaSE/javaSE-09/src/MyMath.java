
public class MyMath {

	public int add(int numA, int numB) {
		int sum = numA + numB;
		return sum;
	}

	public int sub(int numA, int numB) {
		int res = numA - numB;
		return res;
	}
	
	public int mutil(int numA, int numB) {
		int res = numA * numB;
		return res;
	}
	
	public int division(int numA, int numB) {
		int res = numA / numB;
		return res;
		
		/*if(numB != 0) {
			int res = numA / numB;
			return res;
		} else {
			System.out.println("除数不能为0");
			return 0;
		}*/
		
	}
	
	// 求数组最大值
	public int getMax(int[] nums) {
		int max = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			max = max < nums[i] ? nums[i] : max;
		}
		
		return max;
	}
	
	
}
