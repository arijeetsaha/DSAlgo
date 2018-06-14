package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing N integers and a positive integer K. The task is to
 * find the length of the longest sub array with sum of the elements divisible
 * by the given value K.
 * 
 * @author arijeet
 *
 */
public class LongestSubArrDivisible {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] arrayInfo = br.readLine().split(" ");
			int N = Integer.parseInt(arrayInfo[0]);
			int K = Integer.parseInt(arrayInfo[1]);
			Map<Integer, Integer> map = new HashMap<>();
			String[] arrays = br.readLine().split(" ");
			int maxLen = 0;
			int temp = 0;
			int arrMod[] = new int[N];
			int sum = 0;
			arrMod[0] = Integer.parseInt(arrays[0]) % K;
			map.put(arrMod[0], 0);
			for (int j = 0; j < N; j++) {
				sum += Integer.parseInt(arrays[j]);
				arrMod[j] = ((sum % K)+K)%K;
			}

			for (int j = 0; j < N; j++) {

				if (arrMod[j] == 0) {
					maxLen = j + 1;
				} else if (!map.containsKey(arrMod[j])) {
					map.put(arrMod[j], j);
				} else {
					temp = j - map.get(arrMod[j]);
					if (maxLen < temp) {
						maxLen = temp;
					}
				}
			}
			System.out.println(maxLen);
		}
	}

}
