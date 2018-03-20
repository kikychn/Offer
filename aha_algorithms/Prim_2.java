import java.util.Scanner;

public class Prim_2 {
	static int dis[] = new int[7];// ��¼���������������̾���
	static int book[] = new int[7];// ��¼���Ƿ�������������
	static int h[] = new int[7];// h���������
	static int pos[] = new int[7];// pos�����洢ÿ�������ڶ��е�λ��
	static int size;// ��¼�ѵĴ�С

	// ���������������������е�����Ԫ�ص�ֵ
	static void swap(int x, int y) {
		int t;
		t = h[x];
		h[x] = h[y];
		h[y] = t;

		t = pos[h[x]];
		pos[h[x]] = pos[h[y]];
		pos[h[y]] = t;
		return;
	}

	// ���µ�������
	static void siftdown(int i) {// ����һ����Ҫ���µ����Ľ����
		int t, flag = 0;// flag������¼�Ƿ���Ҫ�������µ���
		while (i * 2 <= size && flag == 0) {
			if (dis[h[i * 2]] < dis[h[i]]) {
				t = i * 2;// ��t��¼ֵ��С�Ľ����
			} else {
				t = i;
			}

			if (i * 2 + 1 <= size) {
				if (dis[h[i * 2 + 1]] < dis[h[i]]) {
					t = i * 2 + 1;
				}
			}

			if (t != i) {
				swap(i, t);
				i = t;
			} else {
				flag = 1;
			}
		}
		return;
	}

	static void siftup(int i) {// ����һ����Ҫ���ϵ����Ľ����i
		int flag = 0;
		if (i == 1)
			return;
		while (i != 1 && flag == 0) {
			if (dis[h[i]] < dis[h[i / 2]]) {
				swap(i, i / 2);
			} else {
				flag = 1;
			}
			i = i / 2;
		}
		return;
	}

	// �ӶѶ�ȡ��һ��Ԫ��
	static int pop() {
		int t;
		t = h[1];
		pos[t] = 0;
		h[1] = h[size];
		pos[h[1]] = 1;
		size--;
		siftdown(1);
		return t;
	}

	public static void main(String args[]) {
		int n, m, count = 0, sum = 0;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();

		// �����
		int u[] = new int[19];
		int v[] = new int[19];
		int w[] = new int[19];
		int a, b, c;
		for (int i = 1; i <= m; ++i) {
			u[i] = cin.nextInt();
			v[i] = cin.nextInt();
			w[i] = cin.nextInt();
		}
		// ����������ͼ��������Ҫ�����еı��ٷ�����洢һ��
		for (int i = m + 1; i <= 2 * m; ++i) {
			u[i] = v[i - m];
			v[i] = u[i - m];
			w[i] = w[i - m];
		}

		// �ڽӱ�洢��
		int first[] = new int[n + 1];
		int next[] = new int[2*m + 1];
		for (int i = 1; i <= n; ++i) {
			first[i] = -1;
		}
		for (int i = 1; i <= 2 * m; ++i) {
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		/* Prim���Ĳ��ֿ�ʼ */
		// ��1�Ŷ������������
		book[1] = 1;
		count++;
		// ��ʼ��dis���飬������1�Ŷ��㵽�����������ĳ�ʼ����
		int INF = 999999999;
		dis[1] = 0;
		for (int i = 2; i <= n; ++i) {
			dis[i] = INF;
		}
		int k = first[1];
		while (k != -1) {
			dis[v[k]] = w[k];
			k = next[k];
		}
		// ��ʼ����
		size = n;
		for (int i = 1; i <= size; ++i) {
			h[i] = i;
			pos[i] = i;
		}
		for (int i = n / 2; i >= 1; --i) {
			siftdown(i);
		}
		pop();// �ȵ���һ���Ѷ�Ԫ�أ���Ϊ��ʱ�Ѷ���1�Ŷ���

		int j;
		while (count < n) {
			j = pop();
			book[j] = 1;
			count++;
			sum += dis[j];

			k = first[j];
			while (k != -1) {
				if (book[v[k]] == 0 && dis[v[k]] > w[k]) {
					dis[v[k]] = w[k];
					siftup(pos[v[k]]);
				}
				k = next[k];
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
