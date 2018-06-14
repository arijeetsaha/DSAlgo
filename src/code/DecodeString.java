package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An encoded string (s) is given, the task is to decode it. The pattern in
 * which the strings were encoded were as follows original string:
 * abbbababbbababbbab encoded string : "3[a3[b]1[ab]]".
 * 
 * @author arijeet
 *
 */
public class DecodeString {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] input = br.readLine().toCharArray();
			
		}
	}
}
