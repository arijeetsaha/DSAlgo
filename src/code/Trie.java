package code;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private Map<Character, Trie> children;
	private boolean isLast;

	public Map<Character, Trie> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, Trie> children) {
		this.children = children;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	public Trie getChildren(Character c) {
		return children.get(c);
	}

	public Trie() {
		this.children = new HashMap<>();
		this.isLast = false;
	}

	public void insert(char c, boolean isLast) {
		if(!this.children.containsKey(c)) {
			Trie t1 = new Trie();
			if(isLast) {
				t1.setLast(true);
			}
			this.children.put(c, t1);
		}
		
	}

	@Override
	public String toString() {
		return "Trie [children=" + children + ", isLast=" + isLast + "]";
	}
	
	
}
