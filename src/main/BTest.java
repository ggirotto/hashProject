package main;

import java.util.Scanner;

public class BTest {

    public static void main(String[] args) {
        BTree T = new BTree();

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String temp = input.next();
            if (temp.equals("remove")) T.remove(input.next());
            if (temp.equals("quit")) System.exit(0);
            if (temp.matches("[0-9]+")) T.add(temp, input.nextInt());
            System.out.println();
            T.print();

        }
    }
}
