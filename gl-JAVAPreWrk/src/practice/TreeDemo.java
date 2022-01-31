package practice;

import java.util.ArrayList;

public class TreeDemo {
	
	static class Node{
		Node leftNode;
		Node rightNode;
		int nodeData;
	}
	
	static Node newNode(int Data) {
		Node temp = new Node();
		temp.leftNode = null;
		temp.rightNode = null;
		temp.nodeData = Data;
		return temp;
	}
	
	
	public static void main(String[] args) {
		
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		
		TreeDemo td = new TreeDemo();
		ArrayList<Integer> list = td.findLongestPath(root);
		int size = list.size();
		for(int i = size-1; i>=0; i--) {
			System.out.println(list.get(i));
		}
	}
	
	public ArrayList<Integer> findLongestPath(Node root){
		if(root == null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
		}
		
		ArrayList<Integer> leftArray = findLongestPath(root.leftNode);
		ArrayList<Integer> rightArray = findLongestPath(root.rightNode);
		
		if(leftArray.size() > rightArray.size()) {
			leftArray.add(root.nodeData);
		}else {
			rightArray.add(root.nodeData);
		}
		
		return leftArray.size() > rightArray.size() ? leftArray : rightArray;
	}
	
	
}
