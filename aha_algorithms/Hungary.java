import java.util.Scanner;

//�������㷨������ͼƥ��ľ����㷨֮һ
public class Hungary {
	static int n, m, N = 101;
	static int e[][] = new int[N][N];
	static int match[] = new int[N]; // ��¼��Թ�ϵ
	static int book[] = new int[N];

	static boolean dfs(int u) {
		for (int i = 1; i <= n; ++i) {
			if (book[i] == 0 && e[u][i] == 1) {
				book[i] = 1;
				// �����iδ����Ի����ҵ����µ����
				if (match[i] == 0 || dfs(match[i])) {
					match[i] = u;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int sum = 0;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		int x, y;
		for (int i = 1; i <= m; ++i) {
			x = cin.nextInt();
			y = cin.nextInt();
			e[x][y] = 1;
			e[y][x] = 1;
		}

		for (int i = 1; i <= n; ++i) {
			match[i] = 0;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {// ����ϴ�����ʱ�ı��
				book[j] = 0;
			}

			if (dfs(i))
				sum++;// Ѱ������·������ҵ��������+1
		}

		System.out.println(sum);
	}

}
/*
Input:
3 5
1 1
1 2
2 2
2 3
3 1

Ouput:
3
*/