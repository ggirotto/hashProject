package main;

import java.util.LinkedList;

public class BTree {
	
	private Node root;
	
	private static class Node{
		
		Node right;
		Node left;
		String key;
		LinkedList<Integer> values;
		
		public Node(String key){
			this.key = key;
			values = new LinkedList<>();
			right = null;
			left = null;
		}
	}
	
	public BTree(){
		root = null;
	}
	
	public void add(String key, int val){
		if(root == null){
			root = new Node(key);
			root.values.add(val);
			return;
		}
		Node aux = get(key);
		if(aux != null){
			aux.values.add(val);
			return;
		}
		aux = new Node(key);
		aux.values.add(val);
		
		findWhereToAdd(aux,root);
	}
	
	private void findWhereToAdd(Node p, Node a){
		if(p.key.length() >= a.key.length()){
			if(a.left == null){
				a.left = p;
				return;
			}
			findWhereToAdd(p,a.left);
		}else{
			if(a.right == null){
				a.right = p;
				return;
			}
			findWhereToAdd(p,a.right);
		}
		
	}
	
	public boolean exist(String key){
		if(root.key.equals(key)) return true;
		return exist(key,root);
	}
	
	private boolean exist(String key, Node p){
		if(p == null) return false;
		if(p.key.equals(key)) return true;
		if(key.length() >= p.key.length()) exist(key,p.left);
		if(key.length() < p.key.length()) exist(key,p.right);
		return false;
	}

	public Node get(String key){
		if(root.key.equals(key)) return root;
		return get(key,root);
	}
	
	private Node get(String key, Node p){
		if(p == null) return null;
		if(p.key.equals(key)) return p;
		if(key.length() >= p.key.length()) return get(key,p.left);
		if(key.length() < p.key.length()) return get(key,p.right);
		return null;
	}
	
	public LinkedList<Integer> getValuesFromKey(String key){
		
		Node p = get(key);
		return p.values;
		
	}
	
 	public void print(){
		print(root);
	}
	
	private void print(Node p){
		if(p == null) return;
		System.out.print(p.key + "(");
		print(p.left);
		System.out.print(")");
		System.out.print("(");
		print(p.right);
		System.out.print(")");
	}

}
