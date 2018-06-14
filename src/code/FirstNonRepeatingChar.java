package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an input stream of n characters consisting only of small case alphabets
 * the task is to find the first non repeating character each time a character
 * is inserted to the stream.
 * 
 * @author arijeet
 *
 */
public class FirstNonRepeatingChar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] arrayInfo = br.readLine().split(" ");
			Map<String, Integer> map = new HashMap<>();
			List<String> l = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if (map.containsKey(arrayInfo[j])) {
					int count = map.get(arrayInfo[j]);
					map.put(arrayInfo[j], ++count);
					l.remove(arrayInfo[j]);
					if(!l.isEmpty()) {
						System.out.print(l.get(0)+" ");
					}else {
						System.out.print(-1+" ");
					}
				} else {
					map.put(arrayInfo[j], 1);
					l.add(arrayInfo[j]);
					System.out.print(l.get(0)+" ");
				}
			}
			System.out.println();
		}
	}

}
