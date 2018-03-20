import java.util.Scanner;

//���ѽ������������
public class MaxHeap {
	static int h[] = new int[101];
	static int n;

	static void swap(int x, int y) {
		int t;
		t = h[x];
		h[x] = h[y];
		h[y] = t;
		return;
	}

	static void siftdown(int i) {// ���ﴫ��1�����ӶѵĶ��㿪ʼ���µ���
		int t, flag = 0;
		while (flag == 0 && i * 2 <= n) {
			// t��¼ֵ�ϴ�Ľ����
			if (h[i] < h[i * 2]) {
				t = i * 2;
			} else {
				t = i;
			}
 
			if ((i * 2 + 1) <= n) {
				if (h[t] < h[i * 2 + 1]) {
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

	static void creat() {
		for (int i = n / 2; i >= 1; --i) {
			siftdown(i);
		}
		return;
	}

	// ������
	static void heapsort() {
		while (n > 1) {
			swap(1, n);
			--n;
			siftdown(1);
		}
		return;
	}

	public static void main(String args[]) {
		int num;
		Scanner cin = new Scanner(System.in);
		num = cin.nextInt();
                                                                                   
		for (int i = 1; i <= num; ++i) {
			h[i] = cin.nextInt();
		}
		n = num;

		creat();

		heapsort();

		for (int i = 1; i <= num; ++i) {
			System.out.print(h[i] + " ");
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