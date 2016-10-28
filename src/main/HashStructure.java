package main;

import java.util.LinkedList;

public class HashStructure {

	private final BTree[] table;
	private int size;
	private int capacity;
	private int colisions;

	public HashStructure(){
		table = new BTree[20];
		size = 0;
		capacity = 20;
		colisions = 0;
	}
	
	public HashStructure(int cap){
		table = new BTree[cap];
		size = 0;
		capacity = cap;
		colisions = 0;
	}

	private int hashFunction(String key){

		int hashNumber = 0;
		int keySize = key.length();
		for(int i=0; i<key.length(); i++)
			hashNumber += ((int) key.charAt(i))*keySize;

		return hashNumber%capacity;

	}

	public void add(String key, int value){

		int hashFunc = hashFunction(key);
		if(table[hashFunc] == null){
			BTree arvore = new BTree();
			arvore.add(key,value);
			table[hashFunc] = arvore;
		}else{
			colisions++;
			BTree arvore = table[hashFunc];
			arvore.add(key,value);
		}

	}
	
	public LinkedList<Integer> get(String key){
		
		int hashFunc = hashFunction(key);
		BTree arvore = table[hashFunc];
		return arvore.getValuesFromKey(key);
		
	}

	public int getColisions(){ return colisions;}



}