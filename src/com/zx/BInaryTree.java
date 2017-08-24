package com.zx;

import java.util.Stack;

public class BInaryTree {

	public static void main(String[] args) {
		BInaryTree bt = new BInaryTree();
		bt.createBinaryTree(bt.root);
		System.out.println("The size of the tree is:" + bt.count());
		System.out.println("The height of the tree is:" + bt.height());
		
		System.out.println("深度遍历是：");
		bt.getNode(bt.root);
		
		System.out.println("\n前序遍历是：");
		bt.preOrder(bt.root);
		
		System.out.println("\n中序遍历是：");
		bt.inOrder(bt.root);
		
		System.out.println("\n后序遍历是：");
		bt.postOrder(bt.root);
		
		System.out.println("\n非递归前序遍历是：");
		bt.nonPreOrder(bt.root);
		
		System.out.println("\n非递归中序遍历是：");
		bt.nonInOrder(bt.root);
		
		System.out.println("\n非递归后序遍历是：");
		bt.nonPostOrder(bt.root);
	}
	
	private TreeNode root = null;
	
	public BInaryTree() {
		root = new TreeNode(1,"A");
	}
	
	public void createBinaryTree(TreeNode root) {
		TreeNode nodeB = new TreeNode(2, "B");
		TreeNode nodeC = new TreeNode(3, "C");
		TreeNode nodeD = new TreeNode(4, "D");
		TreeNode nodeE = new TreeNode(5, "E");
		TreeNode nodeF = new TreeNode(6, "F");
		
		root.setLeftChild(nodeB);
		root.setRightChild(nodeC);
		nodeB.setLeftChild(nodeD);
		nodeB.setRightChild(nodeE);
		nodeC.setRightChild(nodeF);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		} else {
			int i = height(subTree.getLeftChild());
			int j = height(subTree.getRightChild());
			return i > j ? i + 1 : j + 1;
		}
	}
	
	public int count() {
		return count(root);
	}
	
	private int count(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		} else {
			return 1 + count(subTree.getLeftChild()) + count(subTree.getRightChild());
		}
	}
	
	public void deleteTree(TreeNode subTree) {
		if (subTree != null) {
			deleteTree(subTree.getLeftChild());
			deleteTree(subTree.getRightChild());
			subTree = null;
		}
	}
	
	public void getNode(TreeNode subTree) {
		if (subTree != null) {
			System.out.print("key:" + subTree.getKey() + "->node " + subTree.getData() + " ");
			getNode(subTree.getLeftChild());
			getNode(subTree.getRightChild());
		}
		
	}
	
	public void preOrder(TreeNode subTree) {
		if (subTree != null) {
			System.out.print(subTree.getData() + " ");
			preOrder(subTree.getLeftChild());
			preOrder(subTree.getRightChild());
		}
	}
	
	public void inOrder(TreeNode subTree) {
		if (subTree != null) {
			inOrder(subTree.getLeftChild());
			System.out.print(subTree.getData() + " ");
			inOrder(subTree.getRightChild());
		}
	}
	
	public void postOrder(TreeNode subTree) {
		if (subTree != null) {
			postOrder(subTree.getLeftChild());
			postOrder(subTree.getRightChild());
			System.out.print(subTree.getData() + " ");
		}
	}
	
	public void nonPreOrder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		stack.push(p);
		
		while (stack.size() > 0) {
			node = stack.pop();
			System.out.print(node.getData() + " ");
			
			if (node.getRightChild() != null) {
				stack.push(node.getRightChild());
			}
			
			if (node.getLeftChild() != null) {
				stack.push(node.getLeftChild());
			}
		}
	}
	
	public void nonInOrder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftChild();
			}
			
			node = stack.pop();
			System.out.print(node.getData() + " ");
			node = node.getRightChild();
		}
	}
	
	public void nonPostOrder(TreeNode p) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode node = p;
		TreeNode temp = null;
		stack1.push(p);
		
		while (stack1.size() > 0) {
			node = stack1.pop();
			if (node.getLeftChild() != null) {
				stack1.push(node.getLeftChild());
			}
			
			if (node.getRightChild() != null) {
				stack1.push(node.getRightChild());
			}
			
			stack2.push(node);
		}
		
		while (stack2.size() > 0) {
			temp = stack2.pop();
			System.out.print(temp.getData() + " ");
		}
	}
}

class TreeNode {
	
	private int key = 0;
	private String data = null;
	private TreeNode leftChild = null;
	private TreeNode rightChild = null;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int key, String data) {
		
		this.key = key;
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
}