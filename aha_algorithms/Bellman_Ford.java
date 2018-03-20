import java.util.Scanner;

public class Bellman_Ford {
	public static void main(String args[]) {
		int n, m;
		int u[] = new int[8];
		int v[] = new int[8];
		int w[] = new int[8];
		int first[] = new int[6];// firstҪ��n�����ֵ1
		int next[] = new int[8];// nextҪ��m�����ֵ��1

		int dis[] = new int[6];
		int book[] = new int[6];// book����������¼��Щ�����Ѿ��ڶ�����

		int que[] = new int[101];
		int head = 1, tail = 1;

		int INF = 99999999;

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// ��ʼ��first�����±�1~n��ֵΪ-1����ʾ1~n������ʱ��û�б�
		for (int i = 1; i <= n; ++i) {
			first[i] = -1;
		}

		for (int i = 1; i <= m; ++i) {
			// ����ÿһ����
			u[i] = cin.nextInt();
			v[i] = cin.nextInt();
			w[i] = cin.nextInt();
			// �����ڽӱ�
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		// ��ʼ��dis���飬��ʾ1�Ŷ��㵽�����������ĳ�ʼ·��
		for (int i = 1; i <= n; ++i) {
			dis[i] = INF;
		}
		dis[1] = 0;

		// ��ʼ��book���飬��ʼ��Ϊ0�������������㿪ʼ�����ڶ�����
		for (int i = 1; i <= n; ++i) {
			book[i] = 0;
		}

		// 1�Ŷ������
		que[tail] = 1;
		tail++;
		book[1] = 1;// ���1�Ŷ����Ѿ����

		// �����Ż���Bellman-Ford�㷨�������
		int k;
		while (head < tail) {
			k = first[que[head]];// ��ǰ��Ҫ����Ķ��׶���
			while (k != -1) {// ɨ�赱ǰ��������г���
				if (dis[v[k]] > dis[u[k]] + w[k]) {
					dis[v[k]] = dis[u[k]] + w[k];// ���¶���u[k]��v[k]��·��
				}
				if (book[v[k]] == 0) {// ��ʾ���ڶ����У�������v[k]���������
					que[tail] = v[k];
					tail++;
					book[v[k]] = 1;
				}
				k = next[k];
			}
			book[que[head]] = 1;
			head++;
		}

		// ���1�Ŷ��㵽���������������·��
		for (int i = 1; i <= n; ++i) {
			System.out.print(dis[i] + " ");
		}

	}
}
/*
Input:
5 7
1 2 2
1 5 10
2 3 3
2 5 7
3 4 4
4 5 5
5 3 6
Output:
0 2 5 9 9 
 */