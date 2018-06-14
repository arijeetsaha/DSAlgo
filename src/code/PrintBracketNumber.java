package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an expression exp of length n consisting of some brackets. The task is
 * to print the bracket numbers when the expression is being parsed.
 * 
 * @author arijeet
 *
 */
public class PrintBracketNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] input = br.readLine().toCharArray();
			List<String> l = new ArrayList<>();
			Deque<Integer> deque = new ArrayDeque<>();
			int bracketNo = 0;
			for (char c : input) {
				if (c == '(') {
					bracketNo++;
					deque.push(bracketNo);
					System.out.print(bracketNo + " ");
				} else if (c == ')') {
					System.out.print(deque.pop() + " ");
				}
			}
			System.out.println();
		}
	}
}
