import java.util.Scanner;

public class Dijkstra {
	public static void main(String args[]) {
		int N = 10;
		int e[][] = new int[N][N];
		int n, m, INF = 999999999;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// ��ʼ��ͼ�����ڽӾ����ʾ
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j) {
					e[i][j] = 0;
				} else {
					e[i][j] = INF;
				}
			}
		}

		// �����
		int t1, t2, t3;
		for (int i = 1; i <= m; ++i) {
			t1 = cin.nextInt();
			t2 = cin.nextInt();
			t3 = cin.nextInt();
			e[t1][t2] = t3;
		}

		// ��ʼ��dis���飬���1�Ŷ��㵽�����������ĳ�ʼ·��
		int dis[] = new int[N];
		for (int i = 1; i <= n; ++i) {
			dis[i] = e[1][i];
		}

		// book�����ʼ��
		int book[] = new int[N];
		for (int i = 1; i <= n; ++i) {
			book[i] = 0;
		}
		book[1] = 1;

		// Dijkstra�㷨�������
		int min, u;
		for (int i = 1; i <= n - 1; ++i) {
			min = INF;
			u = 0;
			for (int j = 1; j <= n; ++j) { // ȡ��Сֵ
				if (book[j] == 0 && dis[j] < min) {
					min = dis[j];
					u = j;
				}
			}
			if (u > 0) { // ͨ��dis[u]�ɳ�u�Ŷ��㵽������������·��
				book[u] = 1;
				for (int v = 1; v <= n; ++v) {
					if (e[u][v] < INF) {
						if (dis[v] > dis[u] + e[u][v]) {
							dis[v] = dis[u] + e[u][v];
						}
					}
				}
			}

		}

		// ������ս��
		for (int i = 1; i <= n; ++i) {
			System.out.print(dis[i] + " ");
		}

	}
}
/*
Input: 
6 9
1 2 1
1 3 12
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4

Output: 
 0 1 8 4 13 17
 */