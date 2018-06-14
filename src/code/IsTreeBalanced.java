package code;

public class IsTreeBalanced {
	
	private static int max;
	
	private static class BalanceStatusWithHeight {
		private int height;
		private boolean isBalanced;
		
		public BalanceStatusWithHeight(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}

		public synchronized int getHeight() {
			return height;
		}

		public synchronized void setHeight(int height) {
			this.height = height;
		}

		public synchronized boolean isBalanced() {
			return isBalanced;
		}

		public synchronized void setBalanced(boolean isBalanced) {
			this.isBalanced = isBalanced;
		}

	}

	private static BalanceStatusWithHeight isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new BalanceStatusWithHeight(-1, true);
		}

		BalanceStatusWithHeight leftStatus = isBalanced(root.getLeft());
		if (!leftStatus.isBalanced) {
			return leftStatus;
		}

		BalanceStatusWithHeight rightStatus = isBalanced(root.getRight());
		if (!rightStatus.isBalanced) {
			return rightStatus;
		}

		boolean isBalanced = Math.abs(rightStatus.height - leftStatus.height) <= 1;
		int height = Math.max(leftStatus.height, rightStatus.height) + 1;

		if(isBalanced == true && height > max) {
			max = height;
		}
		
		return new BalanceStatusWithHeight(height, isBalanced);
	}

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> end = new BinaryTreeNode<Integer>(0, null, null);
		
		BinaryTreeNode<Integer> leaf1 = new BinaryTreeNode<Integer>(4, end, null);
		BinaryTreeNode<Integer> leaf2 = new BinaryTreeNode<Integer>(5, null, null);
		
		BinaryTreeNode<Integer> par1 = new BinaryTreeNode<Integer>(2, leaf1, leaf2);
		BinaryTreeNode<Integer> par2 = new BinaryTreeNode<Integer>(3, null, null);
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, par1, par2);
		
		BalanceStatusWithHeight status = isBalanced(root);
		System.out.println(status.height +" :: "+ status.isBalanced+ " :: "+ max);
		
	}

}
