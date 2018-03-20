import java.util.Scanner;

// ʱ�临�Ӷ���O(N^2)
public class Prim_1 {
	public static void main(String args[]) {
		int N = 7;
		int e[][] = new int[N][N];// �ڽӾ���洢��
		int dis[] = new int[N];// ��¼���������������̾���
		int book[] = new int[N];// ��¼���Ƿ�������������
		int n, m, INF = 99999999;
		int count = 0, sum = 0;

		// ����n��m��n��ʾ��������m��ʾ����
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// ��ʼ���ڽӾ���
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j)
					e[i][j] = 0;
				else
					e[i][j] = INF;
			}
		}

		// �����
		int t1, t2, t3;
		for (int i = 1; i <= m; ++i) {
			t1 = cin.nextInt();
			t2 = cin.nextInt();
			t3 = cin.nextInt();
			e[t1][t2] = t3;
			e[t2][t1] = t3;
		}

		// ��ʼ��dis���飬������1�Ŷ��㵽��������ĳ�ʼ����                                                                                                                                                                                                                                                                                                                                                                                                                      
		for (int i = 1; i <= n; ++i) {
			dis[i] = e[1][i];
		}	
           
		// ��ʼ��book����
		for (int i = 1; i <= n; ++i) {
			book[i] = 0;
		}

		// Prim���Ĳ���
		book[1] = 1;// 1�Ŷ������������                                                                  
		count++;
		int min, u;
		while (count < n) {
			min = INF;
			u = -1;
			// �ҵ���������������Ķ���
			for (int i = 1; i <= n; ++i) {
				if (book[i] == 0 && dis[i] < min) {
					min = dis[i];
					u = i;
				}
			}
			book[u] = 1;
			count++;
			sum += dis[u];
			// �ɳ�,ɨ�赱ǰ����u���еıߣ�����Ϊ�м�㣬������������ÿһ����������ľ���
			for (int i = 1; i <= n; ++i) {
				if (book[i] == 0 && dis[i] > e[u][i]) {
					dis[i] = e[u][i];
				}
			}
		}

		System.out.println(sum);
	}
}

/*
Input:
6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2

Output:
19
*/