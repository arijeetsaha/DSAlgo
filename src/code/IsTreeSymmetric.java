package code;

public class IsTreeSymmetric {

	public static void main(String[] args) {

		// BinaryTreeNode<Integer> end = new BinaryTreeNode<Integer>(0, null, null);
		//
		BinaryTreeNode<Integer> leaf1 = new BinaryTreeNode<Integer>(4, null, null);
		BinaryTreeNode<Integer> leaf2 = new BinaryTreeNode<Integer>(4, null, null);
		//
		// BinaryTreeNode<Integer> par1 = new BinaryTreeNode<Integer>(2, leaf1, leaf2);
		BinaryTreeNode<Integer> par1 = new BinaryTreeNode<Integer>(2, leaf1, null);
		BinaryTreeNode<Integer> par2 = new BinaryTreeNode<Integer>(2, leaf2, null);

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, par1, par2);

		if (root == null) {
			System.out.println(true);
		}

		System.out.println(Boolean.toString(checkTreeSymmetric(root.getLeft(), root.getRight())));
	}

	private static boolean checkTreeSymmetric(BinaryTreeNode<Integer> rootLeft, BinaryTreeNode<Integer> rootRight) {

		if (rootLeft == null && rootRight == null) {
			return true;
		} else {
			if (rootLeft != null && rootRight != null && rootLeft.getData() == rootRight.getData()
					&& checkTreeSymmetric(rootLeft.getLeft(), rootRight.getRight())
					&& checkTreeSymmetric(rootLeft.getRight(), rootRight.getLeft())) {
				return true;
			}
		}

		return false;

	}

}
