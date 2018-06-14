package code;

public class ExcelDecoding {

	
	public static void main(String[] args) {
		boolean willPass = checkPassThroughOrigin(1, "A", 28, "AA");
		System.out.println(willPass);
	}
	
	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int value(String str) {
		char[] chars = str.toCharArray();
		int length = chars.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			count = (chars[i] - 'A' + 1) + 26 * count;
		}
		System.out.println(count);
		return count;
	}

	static boolean checkPassThroughOrigin(int x1, String y1, int x2, String y2) {

		int yVal1 = value(y1);
		int yVal2 = value(y2);

		Point p1= new Point(x1,  yVal1);
		Point p2= new Point(x2,  yVal2);
		
		
		float slope1 = p1.y / p1.x + p1.y % p1.x;
		float slope2 = p2.y / p2.x + p2.y % p2.x;

		if(slope1 == slope2) {
			return true;
		}
		
		return false;
	}

}
