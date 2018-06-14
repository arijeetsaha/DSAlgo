package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Write a program to find the majority element in the array. A majority element
 * in an array A[] of size n is an element that appears more than n/2 times (and
 * hence there is at most one such element). If input array doesn't contain a
 * majority element, then output "NO Majority Element"
 *
 */
public class MajorityElement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int count = 1;
			int N = Integer.parseInt(br.readLine());
			String[] nos = br.readLine().split(" ");
			String major = nos[0];
			for (int j = 1; j < N; j++) {
				if (count > 0) {
					if (!nos[j].equals(major)) {
						count--;
					} else {
						count++;
						major = nos[j];
					}
				} else {
					count++;
					major = nos[j];
				}

			}
			if (count == 0) {
				System.out.println("NO Majority Element");
			} else {
				int temp = 0;
				for (int k = 0; k < N; k++) {
					if (nos[k].equals(major)) {
						temp++;
					}
				}
				if (temp > N / 2) {
					System.out.println(major);
				} else {
					System.out.println("NO Majority Element");
				}
			}
		}
	}
}
