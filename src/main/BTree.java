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
		
		public Node(String key, int value){
			this.key = key;
			values = new LinkedList<>();
			values.add(value);
			right = null;
			left = null;
		}
	}
	
	public BTree(){
		root = null;
	}
	
	public void add(String key, int value) {
        root = add(root, key, value);
    }

    private Node add(Node node, String key, int value) {

        if (node == null) {
            return new Node(key,value);
        }
        if(node.key.equals(key)) {
        	node.values.add(value);
        	return node;
        }
        if (key.length() < node.key.length()) {
            node.left = add(node.left, key, value);
        }

        else {
            node.right = add(node.right, key, value);
        }
        return node;
    }
	
    public void remove (String key){
    	remove(root, key);
    }
    
    private void remove (Node n, String key ){
    	Node pai = encontraPai(n,key);
    	if (pai == null) return;
    	Node filho = pai.left;
    	if (key.length() > pai.key.length()) filho = pai.right;
    	int netos = 0;
    	if(filho.left != null) netos++;
    	if(filho.right != null) netos++;
    	
    	Node refNeto = null;
    	switch(netos){
    		case 1: refNeto = filho.right;
    				if(filho.left != null) refNeto = filho.left;
    		
    		case 0: if (key.length() > pai.key.length()) pai.right = refNeto;
    				else pai.left = refNeto;
    			break;
    			
    		case 2: Node maxMin = filho.left;
    				while(maxMin.right != null){
    					maxMin = maxMin.right;
    				}
    				String aux = maxMin.key;
    				remove(filho, maxMin.key);
    				filho.key = aux;
    			break;
    	}
    }
    
    private Node encontraPai(Node n, String key ){
    	Node pai = null;
    	Node atual = n;
    	
    	while(true){
			if(atual == null) return null;
			if(atual.key == key) return pai;
			pai = atual;
			if (key.length() < atual.key.length()) atual = atual.left;
			else atual = atual.right;
    	}
    }
	
	public boolean exist(String key){
		if(root.key.equals(key)) return true;
		return exist(key,root);
	}
	
	private boolean exist(String key, Node p){
		if(p == null) return false;
		if(p.key.equals(key)) return true;
		if(key.length() < p.key.length()) exist(key,p.left);
		if(key.length() >= p.key.length()) exist(key,p.right);
		return false;
	}

	public Node get(String key){
		if(root.key.equals(key)) return root;
		return get(key,root);
	}
	
	private Node get(String key, Node p){
		if(p == null) return null;
		if(p.key.equals(key)) return p;
		if(key.length() < p.key.length()) return get(key,p.left);
		if(key.length() >= p.key.length()) return get(key,p.right);
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
