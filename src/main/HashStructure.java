package main;

import java.util.LinkedList;
import java.util.Random;

public class HashStructure {

	private final BTree[] table;
	private int size;
	private int capacity;
	private int colisions[];
	private double fracRandom;

	public HashStructure(){
		table = new BTree[20];
		size = 0;
		capacity = 20;
		colisions = new int [capacity];
		Random r = new Random();
		fracRandom = r.nextDouble();
	}
	
	public HashStructure(int cap){
		table = new BTree[cap];
		size = 0;
		capacity = cap;
		colisions = new int [capacity];
		Random r = new Random();
		fracRandom = r.nextDouble();
	}

	private int hashFunction(String key){

		int hashNumber = 0;
		int keySize = key.length();
		for(int i=0; i<key.length(); i++)
			hashNumber += ((int) key.charAt(i))*keySize;

		return hashNumber%capacity;

	}
	
	private int knuthHashFunction(String key){
		
		int k = hashFunction(key);
		k += k*(k+3);
		return k%capacity;
		
	}
	
	private int multiplicacaoHashFunction(String key){
		
		double frac = fracRandom;
		
		double x = hashFunction(key) * frac;
		x = x-(Math.floor(x));
				
		return (int) Math.floor(capacity * x);
		
	}
	
	public void add(String key, int value){
		
//		if(key.contains(".")){
//			key.replace(".", "");
//		}
		int hashFunction = multiplicacaoHashFunction(key);
		if(table[hashFunction] == null){
			BTree arvore = new BTree();
			arvore.add(key,value);
			table[hashFunction] = arvore;
		}else{
			colisions[hashFunction]++;
			BTree arvore = table[hashFunction];
			arvore.add(key,value);
		}

	}
	
	public void remove(String key){
		int hashFunc = hashFunction(key);
		table[hashFunc].remove(key);
	}
	
	public boolean contains(String key){
		int hashFunc = hashFunction(key);
		return table[hashFunc].exist(key);
	}
	
	public LinkedList<Integer> get(String key){
		
		int hashFunc = hashFunction(key);
		BTree arvore = table[hashFunc];
		return arvore.getValuesFromKey(key);
		
	}

	public int [] getColisions(){ return colisions;}



}
