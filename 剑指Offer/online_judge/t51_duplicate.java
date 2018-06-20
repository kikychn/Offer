package online_judge;
/**
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 */
public class t51_duplicate {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
		int[] dupli = new int[1];
		System.out.println(duplicate(nums, nums.length, dupli));
		System.out.print(dupli[0]);
	}

	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication in
	// C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications in
	// the array number
	// otherwise false
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || duplication == null || length <= 0 || duplication.length < 1)
			return false;

		for (int i = 0; i < length; ++i) {
			if (numbers[i] != i) {	// 此处用if或while都可行
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}

		return false;
	}

}
