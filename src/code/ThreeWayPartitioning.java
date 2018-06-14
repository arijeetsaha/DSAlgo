package code;

import java.util.ArrayList;

/**
 * 
 * Given an array and a range [lowVal, highVal], the task is to complete the
 * function threeWayPartition which partition the array around the range such
 * that array is divided in three parts. 1) All elements smaller than lowVal
 * come first. 2) All elements in range lowVal to highVal come next. 3) All
 * elements greater than highVal appear in the end. The individual elements of
 * three sets can appear in any order. You are required to return the modified
 * arranged array.
 */
public class ThreeWayPartitioning {

	public ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int lowVal, int highVal) {

		method(A, lowVal);
		method(A, highVal);
		return A;

	}

	private void method(ArrayList<Integer> A, int lowVal) {
		int small = 0;
		int large = A.size() - 1;
		for (int i = 0; i < A.size();i++) {
			if (A.get(i) < lowVal) {
				int temp = A.get(small);
				A.set(small, A.get(i));
				A.set(i, temp);
				small++;
			}
		}

		for (int i = A.size() -1; i >= 0;i--) {
			if (A.get(i) > lowVal) {
				int temp = A.get(large);
				A.set(large, A.get(i));
				A.set(i, temp);
				large--;
			}
		}
	}

	public static void main(String[] args) {
		ThreeWayPartitioning obj = new ThreeWayPartitioning();
		ArrayList<Integer> list = new ArrayList<>();
		// {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
		list.add(1);
		list.add(14);
		list.add(5);
		list.add(20);
		list.add(4);
		list.add(2);
		list.add(54);
		list.add(20);
		list.add(87);
		list.add(98);
		list.add(1);
		list.add(32);
		System.out.println(list);
		obj.threeWayPartition(list, 2, 20);
	}
}
