package code;

import java.util.LinkedList;

/**
 * Circular tour Submissions: 8776   Accuracy: 26.8%   Difficulty: Medium
          
Suppose there is a circle. There are n petrol pumps on that circle. You will be given two sets of data.

1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Your task is to complete the function tour which returns an integer denoting the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).

Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

Input
The first line of input will be the no of test cases . Then T test cases follow . Each Test case contains 2 lines . The first line will contain an integer N denoting the no of petrol pumps and in the next line are N space separated values petrol and distance denoting the amount of petrol every petrol pump has and the distance to next petrol pump respectively .

Output
The output of each test case will be the index of the the first point from where a truck will be able to complete the circle otherwise -1 .

Constraints:
1<=T<=100
1<=N<=50
1<=petrol,distance<=100

Example (To be used only for expected output)
Input
1
4
4 6 6 5 7 3 4 5
Output
1

Explanation:
Above there are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output in this case is 1 (index of 2nd petrol pump).

** For More Input/Output Examples Use 'Expected Output' option **
 * @author arijeet
 *
 */
public class PetrolGasCircularTour {

	public static void main(String[] args) {
		PetrolGasCircularTour tour = new PetrolGasCircularTour();
		int[] petrol = { 4, 6, 7, 4 };
		int[] distance = { 6, 5, 3, 5 };
		tour.tour(petrol, distance);
	}

	int tour(int petrol[], int distance[]) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> deqList = new LinkedList<>();
		int len = petrol.length;
		int sumP = 0;
		int sumD = 0;
		int i = 0;
		for (i = 0; i < len; i++) {
			sumP += petrol[i];
			sumD += distance[i];
			list.add(i);
			while (sumP < sumD) {
				int index = list.removeFirst();
				sumP -= petrol[index];
				sumD -= distance[index];
				deqList.add(index);
			}
		}
		int dqLen = deqList.size();
		if (deqList.isEmpty()) {
			//System.out.println("1 :: " + list.peekFirst());
			return list.peekFirst();
		} else {
			for (int j = 0; j < dqLen; j++) {
				sumP += petrol[deqList.get(j)];
				sumD += distance[deqList.get(j)];

				if (sumP < sumD) {
					//System.out.println("2 :: " + -1);
					return -1;
				}
			}
			//System.out.println("3 :: " + list.peekFirst());
			return list.peekFirst();
		}
	}

}
