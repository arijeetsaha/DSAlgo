package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Given an array, print k largest elements from the array.  The output elements should be printed in decreasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned.
The second line of each test case contains N input C[i].

Output:

Print the k largest element in descending order.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
K ≤ N
1 ≤ C[i] ≤ 1000

Example:

Input:
2
5 2
12 5 787 1 23
7 3
1 23 12 9 30 2 50

Output:
787 23
50 30 23
 
 * @author arijeet
 *
 */
public class KLargestElement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]);
			int K = Integer.parseInt(inputs[1]);
			int nums[] = new int[N];
			String[] nos = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				nums[j] = Integer.parseInt(nos[j]);
			}

			findKLargestElements(nums, K, N);
		}
	}

	private static void findKLargestElements(int[] nums, int k, int N) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(k);
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		for (int i = k; i < N; i++) {
			if(heap.peek()<nums[i]) {
				heap.poll();
				heap.add(nums[i]);
			}
			
		}
		int arr[] = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = heap.poll();
		}
		for (int i = k - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
