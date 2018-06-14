package code;

/**
 * Print all valid words that are possible using Characters of Array
Given a dictionary and a character array, print all valid words that are possible using characters from the array.

Examples:

Input : Dict - {"go","bat","me","eat","goal", 
                                "boy", "run"} 
        arr[] = {'e','o','b', 'a','m','g', 'l'} 
Output : go, me, goal. 
 * @author arijeet
 *
 */
public class ValidWordsFromDictionary {

	public static void main(String[] args) {
		String[] dic = { "go", "bat", "me", "eat", "goal", "boy", "run" };
		int len = dic.length;
		Trie t = new Trie();
		for (int i = 0; i < len; i++) {
			insertWordToTrie(dic[i], t);
		}

		System.out.println(t.getChildren('g'));

		char[] cArr = { 'e', 'o', 'b', 'a', 'm', 'g', 'l' };
		for(char c: cArr) {
			checkForPresence(t, cArr, c, "");
		}

	}

	private static void insertWordToTrie(String word, Trie t) {
		char[] cArr = word.toCharArray();
		int len = cArr.length;
		for (int i = 0; i < len; i++) {
			t.insert(cArr[i], i == len - 1);
			t = t.getChildren(cArr[i]);
		}
	}

	private static void checkForPresence(Trie t, char[] cArr, char c, String s) {

		Trie t1 = t.getChildren(c);
		if (t1 == null) {
			//return;
		} else {
			if (t.getChildren(c).isLast()) {
				System.out.print(s +c +" ");
			}

			for (char c1 : cArr) {
				checkForPresence(t1, cArr, c1, s + c);
			}
		}
	}

}
