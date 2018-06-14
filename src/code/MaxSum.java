package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int M = 1000000007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String arrays = br.readLine();
			if (n == 1) {
				System.out.println(arrays);
				continue;
			}
			List<Integer> list = Arrays.stream(arrays.split(" ")).map(a -> Integer.parseInt(a))
					.collect(Collectors.toList());
			Collections.sort(list);
			Object arr[] = list.toArray();
			sum = findSumForNegetiveElements(n, arr, M);
			System.out.println(sum);
		}

	}

	public static int findSumForNegetiveElements(int n, Object[] arr, int M) {
		int sum = 0;
		int i = 0;
		for (; i < n && (int) arr[i] <= 0; i++) {
			int prod = (int) arr[i] % M;
			if (i + 1 < n && (int) arr[i + 1] <= 0) {
				prod *= (int) arr[i + 1] % M;
				prod %= M;
				sum += prod;
				sum %= M;
				i++;
			} else {
				break;
			}
		}
		int j = 0;
		for (j = n - 1; j > i; j--) {
			int prod = (int) arr[j] % M;
			if (j - 1 > i) {
				prod *= (int) arr[j - 1] % M;
				sum += prod % M;
				sum %= M;
				j--;
			}else {
				break;
			}
		}

		if (i == j) {
			sum += (int) arr[i];
		}
		if (i < j) {
			sum += (int) arr[i] % M * (int) arr[j];
		}

		return sum;
	}

}
