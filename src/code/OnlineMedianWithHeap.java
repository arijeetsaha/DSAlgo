package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an input stream of n integers the task is to insert integers to stream and print the median of the new stream formed by each insertion of x to the stream.

Example

Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3)

Input:
The first line of input contains an integer N denoting the no of elements of the stream. Then the next N lines contains integer x denoting the no to be inserted to the stream.

Output:
For each element added to the stream print the floor of the new median in a new line.

Constraints:
1<=N<=10^5+7
1<=x<=10^5+7

Example:
Input:
4
5
15
1 
3
Output:
5
10
5
4
 * @author arijeet
 *
 */
public class OnlineMedianWithHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			findMedian(minHeap, maxHeap, num);

		}
	}

	private static void findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int num) {
		int minHeapSize = minHeap.size();
		
		maxHeap.add(num);
		if(maxHeap.size()-minHeapSize>1) {
			int n = maxHeap.poll();
			minHeap.add(n);
		}
		
		if(minHeap.size()>0 && maxHeap.peek() > minHeap.peek()) {
			int maxTop = maxHeap.poll();
			int minTop = minHeap.poll();
			maxHeap.add(minTop);
			minHeap.add(maxTop);
		}
		
		if(maxHeap.size() == minHeap.size()) {
			System.out.println((maxHeap.peek()+minHeap.peek())/2);
		}else {
			System.out.println(maxHeap.peek());
		}
	}

}
