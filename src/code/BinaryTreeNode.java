package code;

public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> left, right;
	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public synchronized T getData() {
		return data;
	}

	public synchronized void setData(T data) {
		this.data = data;
	}

	public synchronized BinaryTreeNode<T> getLeft() {
		return left;
	}

	public synchronized void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public synchronized BinaryTreeNode<T> getRight() {
		return right;
	}

	public synchronized void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode<T> other = (BinaryTreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
}
