package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array A[] of n elements. The task is to complete the function which
 * returns true if triplets exists in array A[] whose sum is zero else returns
 * false.
 * 
 */
public class TripletsSumZero {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int[] nos = Arrays.stream(line).map(x -> Integer.parseInt(x)).mapToInt(Integer::intValue).toArray();
			findTriplets(N, nos);
		}
	}

	private static void findTriplets(int n, int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		// -3 -2 -1 1 2 3
		for (int j = 0; j <= n - 2; j++) {
			int a = j + 1;
			int b = n - 1;
			while (a < b) {
				if (arr[a] + arr[b] == -arr[j]) {
					count++;
					break;
					// a++;
					// b--;
				} else if (arr[a] + arr[b] < -arr[j]) {
					a++;
				} else {
					b--;
				}

			}
		}
		System.out.println(count > 0 ? 1 : 0);
	}
}
