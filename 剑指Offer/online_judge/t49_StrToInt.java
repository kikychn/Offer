package online_judge;
/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 */
public class t49_StrToInt {
	public static void main(String[] args) {
		String str = "-2147483647";
		System.out.print(StrToInt(str));
	}

	public static int StrToInt(String str) {
		if (str == null || str.length() == 0)
			return 0;

		int result = 0;
		int flag = 0;
		if (str.charAt(0) == '-')
			flag = 1;
		for (int i = flag; i < str.length(); ++i) {
			if (str.charAt(i) == '+')
				continue;
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				result = result * 10 + str.charAt(i) - '0';
			} else {
				return 0;
			}
		}

		if (flag == 1)
			result = -1 * result;
		return result;
	}
}
