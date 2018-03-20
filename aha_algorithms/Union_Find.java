import java.util.Scanner;
// ���鼯
public class Union_Find {
	static int f[] = new int[1000];
	static int n, m, k, sum = 0;

	static void init() {
		for (int i = 1; i <= n; ++i) {
			f[i] = i;
		}
	}

	// �ҵ��ĵݹ麯������ͣ��ȥ�ҵ���ֱ���ҵ�����Ϊֹ����������������ԭ��
	static int getf(int v) {
		if (f[v] == v) {
			return v;
		} else {
			f[v] = getf(f[v]);
			return f[v];
		}
	}

	// �ϲ������Ӽ��ϵĺ���
	static void merge(int v, int u) {
		int t1, t2;
		t1 = getf(v);
		t2 = getf(u);
		if (t1 != t2) {// �ж���������Ƿ���ͬһ�������У����Ƿ�Ϊͬһ������
			f[t2] = t1;
		}
		return;
	}

	public static void main(String args[]) {
		int x, y;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		init();// ��ʼ��
		for (int i = 1; i <= m; ++i) {
			x = cin.nextInt();
			y = cin.nextInt();
			merge(x, y);
		}

		for (int i = 1; i <= n; ++i) {
			if (f[i] == i) {
				++sum;
			}
		}

		System.out.println(sum);

	}
}
/*
Input:
10 9
1 2
3 4
5 2
4 6
2 6
8 7
9 7
1 6
2 4

Output:
3
*/