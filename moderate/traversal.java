package moderate;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class traversal {

	public static void main(String[] args) {
		// DS | BQ = DFS-->stack, BFS-->Queue
		/*
		 * 			1
		 *		2 		3
		 *    4	  5
		 * */
		/*Depth First Traversals:
		(a) Inorder (Left, Root, Right) : 4 2 5 1 3
		(b) Preorder (Root, Left, Right) : 1 2 4 5 3
		(c) Postorder (Left, Right, Root) : 4 5 2 3 1*/
		
		TreeNode root = new TreeNode(20);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.print("inorder:\t");
        inorder(root);
        System.out.print("\npre-order:\t");
        preorder(root);
        System.out.print("\npost-order:\t");
        postorder(root);
        System.out.print("\nbfs:\t");
        bfs(root);
        System.out.print("\nbfs2:\t");
        bfs2(root);
	}
	public static void inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			res.add(root.val);
			root=root.right;
		}
		for(int n:res)
			System.out.print(n+" ");
	}
	public static void preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				res.add(root.val);
				stack.push(root.right);
				root=root.left;
			}else {
				root=stack.pop();
			}
		}
		for(int n:res)
			System.out.print(n+" ");
	}
	public static void postorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				res.add(0,root.val);
				stack.push(root);
				root=root.right;
			}else {
				root=stack.pop().left;
			}
		}
		for(int n:res)
			System.out.print(n+" ");
	}
	public static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> res = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			res.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		for(int n:res)
			System.out.print(n+" ");
	}
	public static void bfs2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> sublist = new LinkedList<>();
			for(int i=0;i<level;i++) {
				TreeNode temp = queue.remove();
				sublist.add(temp.val);
				if(temp.left!=null) queue.add(temp.left);
				if(temp.right!=null) queue.add(temp.right);
			}
			res.add(sublist);
		}
		for(List<Integer> list:res) {
			System.out.print("[ ");
			for(int n:list)
				System.out.print(n+" ");
			System.out.print("]");
		}
	}

}
