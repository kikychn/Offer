import java.util.Scanner;

//��С�ѽ������������
public class MinHeap {
	static int h[] = new int[101];// ������Ŷѵ�����
	static int n;// �洢����Ԫ�صĸ�����Ҳ���ǶѵĴ�С

	// �������������ڽ������е�����Ԫ�ص�ֵ
	static void swap(int x, int y) {
		int t;
		t = h[x];
		h[x] = h[y];
		h[y] = t;
		return;
	}

	// ���µ�������
	static void siftdown(int i) {
		int t, flag = 0;
		while (i * 2 <= n && flag == 0) {
			// �����ж������������Ĺ�ϵ������t��¼��С�Ľ����
			if (h[i] > h[i * 2]) {
				t = i * 2;
			} else {
				t = i;
			}

			// ��������Ҷ��ӣ��ٶ��Ҷ��ӽ�������
			if ((i * 2 + 1) <= n) {
				// ����Ҷ��ӵ�ֵ��С�����½�С�Ľ����
				if (h[t] > h[i * 2 + 1]) {
					t = i * 2 + 1;
				}
			}

			// ���������С�Ľ���Ų����Լ���˵���ӽ�����бȸ�����С��
			if (t != i) {
				swap(i, t);
				i = t;// ����iΪ�ղ����������Ķ��ӽ��ı�ţ����ڽ������������µ���
			} else {
				flag = 1;// ˵����ǰ�ĸ�����Ѿ��������ӽ�㶼С������Ҫ�ٵ�����
			}

		}
		return;
	}

	// �����ѵĺ���
	static void creat() {
		for (int i = n / 2; i >= 1; --i) {
			siftdown(i);
		}
	}

	// ɾ����С��Ԫ��
	static int deletemin() {
		int t = h[1];// ��һ����ʱ������¼�Ѷ���ֵ(��Сֵ)
		h[1] = h[n];// ���ѵ����һ���㸳ֵ���Ѷ�
		--n;// �ѵ�Ԫ�ؼ���1
		siftdown(1);// ���µ���
		return t;// ����֮���¼�ĶѶ������Сֵ
	}

	public static void main(String args[]) {
		int num;
		Scanner cin = new Scanner(System.in);
		num = cin.nextInt();// ����Ҫ��������ֵĸ���

		for (int i = 1; i <= num; ++i) {
			h[i] = cin.nextInt();
		}
		n = num;

		// ����
		creat();

		// ɾ���Ѷ�Ԫ�أ�����ɾ��n�Σ�Ҳ���Ǵ�С������������
		for (int i = 1; i <= num; ++i) {
			System.out.print(deletemin() + " ");
		}

	}
}
/*
Input:
14
99 5 36 7 22 17 46 12 2 19 25 28 1 92

Output:
1 2 5 7 12 17 19 22 25 28 36 46 92 99
 */
