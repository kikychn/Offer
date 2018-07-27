package online_judge;
/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
import java.util.*;

public class t64_GetMedian {

	private int count = 0;
	private Queue<Integer> minHeap = new PriorityQueue<Integer>();
	private Queue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public void Insert(Integer num) {
		if (count % 2 == 0) {
			maxHeap.offer(num);
			int maxNum = maxHeap.poll();
			minHeap.offer(maxNum);
		} else {
			minHeap.offer(num);
			int minNum = minHeap.poll();
			maxHeap.offer(minNum);
		}
		++count;
	}

	public Double GetMedian() {
		if (count % 2 == 0)
			return new Double(minHeap.peek() + maxHeap.peek()) / 2;
		else
			return new Double(minHeap.peek());
	}

}
