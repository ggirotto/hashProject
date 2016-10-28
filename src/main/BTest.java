package main;

public class BTest {

	public static void main(String[] args) {
		
		BTree arvbin = new BTree();
		
		arvbin.add("111", 4);
		arvbin.add("1", 12);
		arvbin.add("1111", 25);
		
		arvbin.print();

	}

}
