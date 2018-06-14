package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For
 * each element in arr1[] count elements less than or equal to it in array
 * arr2[].
 * 
 * @author arijeet
 *
 */
public class CountNoOfElementsLessOrEqual {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] arrayInfo = br.readLine().split(" ");
			int m = Integer.parseInt(arrayInfo[0]);
			int n = Integer.parseInt(arrayInfo[1]);

			String[] array1 = br.readLine().split(" ");
			String[] array2 = br.readLine().split(" ");
			
			int[] arr1 = new int[m];
			int[] arr2 = new int[n];
			
			for(int j=0;j<m;j++) {
				arr1[j] = Integer.parseInt(array1[j]);
			}
			
			for(int j=0;j<n;j++) {
				arr2[j] = Integer.parseInt(array2[j]);
			}
			
			method(m, n, arr1, arr2);
		}
	}

	private static void method(int m, int n, int[] array1, int[] array2) {
		int maxElement = 0;
		for (int j = 0; j < n; j++) {
			if(array2[j] > maxElement){
				maxElement = array2[j];
			}
		}
		
		int[] arr = new int[maxElement+1];
		
		for (int j = 0; j < n; j++) {
			arr[array2[j]]++;
		}
		
		for (int j = 1; j <= maxElement ; j++) {
			arr[j] += arr[j-1];
		}
		
		for(int j = 0;j<m;j++) {
			if(array1[j] > maxElement ) {
				System.out.print(arr[maxElement]+" ");
			}else {
				System.out.print(arr[array1[j]]+" ");
			}
		}
		
		System.out.println();
	}
}
