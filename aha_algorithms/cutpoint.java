import java.util.Scanner;
// �����ڽӱ�����ڽӾ���洢ͼ��ʱ�临�Ӷ���O(N^2)����O(N+M)

public class cutpoint {
	static int n, m, N = 9;
	static int e[][] = new int[N][N];
	static int root;// �����
	static int num[] = new int[N];// ��¼ÿ�������ʱ�������ʼ��Ĭ��ֵΪ0��������δ���ʹ�
	static int low[] = new int[N];// ��¼ÿ�������ڲ�����������ʱ���ܹ��ص�����Сʱ���
	static int flag[] = new int[N];// ��Ƕ����Ƿ�Ϊ���
	static int index;// ��������ʱ����ĵ���

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static void dfs(int cur, int father) {// ����������������ǰ�����ź͸�����ı��
		int child = 0;

		index++;
		num[cur] = index;// ��ǰ�����ʱ���
		low[cur] = index;// ��ǰ�����ܹ����ʵ������綥���ʱ�����һ��ʼ���Լ�

		for (int i = 1; i <= n; ++i) {
			if (e[cur][i] == 1) {
				if (num[i] == 0) {// ����i��ʱ���Ϊ0����ʾ��δ�����ʹ�
					child++;
					dfs(i, cur);
					low[cur] = min(low[cur], low[i]);// ���µ�ǰ����cur�ܷ��ʵ����綥���ʱ���

					if (cur != root && low[i] >= num[cur])
						flag[cur] = 1;
					if (cur == root && child == 2)
						flag[cur] = 1;
				} else if (i != father) {
					// ���򶥵�i�����ʹ�������������㲻�ǵ�ǰ����cur�ĸ��ף�
					// ˵����ʱiΪcur�����ȣ������Ҫ���½��cur�ܷ��ʵ������綥���ʱ���
					low[cur] = min(low[cur], num[i]);
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		// ��ʼ���ڽӾ���
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				e[i][j] = 0;
			}
		}
		int x, y;
		for (int i = 1; i <= m; ++i) {
			x = cin.nextInt();
			y = cin.nextInt();
			e[x][y] = 1;
			e[y][x] = 1;
		}

		root = 1;// ���������Ϊ1
		dfs(1, root);// ��1�Ŷ��㿪ʼ����������ȱ���
		
		for(int i = 1; i <= n; ++i) {
			if(flag[i] == 1)
				System.out.print(i);
		}
		
		return;

	}

}
/*
Input:
6 7
1 4
1 3
4 2
3 2
2 5
2 6
5 6

Output:
2
*/

