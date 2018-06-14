package code;

public class LCA {

	private static class Status {
		int count;
		boolean isFound;
		int parentNode;

		public Status(int count, boolean isFound) {
			super();
			this.count = count;
			this.isFound = isFound;
		}

		public Status(int count, boolean isFound, int parentNode) {
			super();
			this.count = count;
			this.isFound = isFound;
			this.parentNode = parentNode;
		}
	}

	public static Status findLCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		if (tree == null) {
			return new Status(0, false);
		}

		Status s1 = findLCA(tree.getLeft(), node1, node2);
		if (s1.count == 2) {
			return s1;
		}

		Status s2 = findLCA(tree.getRight(), node1, node2);
		if (s2.count == 2) {
			return s2;
		}

		int count = s1.count + s2.count + (node1.getData() == tree.getData() ? 1 : 0)
				+ (node2.getData() == tree.getData() ? 1 : 0);
		if (count == 2) {
			return new Status(count, count == 2, tree.getData());
		}

		return new Status(count, count == 2);

	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> end = new BinaryTreeNode<Integer>(0, null, null);

		BinaryTreeNode<Integer> leaf1 = new BinaryTreeNode<Integer>(4, end, null);
		BinaryTreeNode<Integer> leaf2 = new BinaryTreeNode<Integer>(5, null, null);

		BinaryTreeNode<Integer> par1 = new BinaryTreeNode<Integer>(2, leaf1, leaf2);
		BinaryTreeNode<Integer> par2 = new BinaryTreeNode<Integer>(3, null, null);

		BinaryTreeNode<Integer> par3 = new BinaryTreeNode<Integer>(6, null, null);

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, par1, par2);

		Status s = findLCA(root, leaf1, par3);
		if (s.isFound) {
			System.out.println(s.parentNode);
		}
	}
}
