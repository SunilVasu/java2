package moderate;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        
        inorder(root);
        System.out.println("\n");
        preorder(root);
        System.out.println("\n");
        postorder(root);
        System.out.println("\n");
        bfs(root);
        System.out.println("\n");
        bfs2(root);
	}
	public static void inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>(); 
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			list.add(root.val);
			root=root.right;
		}
		for(int n:list)
			System.out.print(n+" ");
	}
	public static void preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				list.add(root.val);
				stack.push(root.right);
				root=root.left;
			}else {
				root=stack.pop();
			}
		}
		for(int n:list)
			System.out.print(n+" ");
	}
	public static void postorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack();
		LinkedList<Integer> list = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				stack.push(root);
				list.addFirst(root.val);
				root=root.right;
			}else {
				root=stack.pop().left;
			}
		}
		
		for(int n:list)
			System.out.print(n+" ");
	}
	public static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		for(int n:list)
			System.out.print(n+" ");
	}
	public static void bfs2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			
			List<Integer> sublist = new LinkedList();
			int level = queue.size();
			for(int i=0;i<level;i++) {
				TreeNode temp = queue.poll();
				sublist.add(temp.val);
				if(temp.left!=null) queue.add(temp.left);
				if(temp.right!=null) queue.add(temp.right);
			}
			list.add(sublist);
		}
		for(List<Integer> l:list) {
			System.out.print("[ ");
			for(int n:l)
				System.out.print(n+" ");
			System.out.print("]");
		}
	}

}
