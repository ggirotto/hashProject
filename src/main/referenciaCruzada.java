package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class referenciaCruzada {

	public static void main(String[] args) throws FileNotFoundException {

		HashStructure myHash = new HashStructure();

		File f = new File("biblia.txt");

		Scanner in = new Scanner(f);
		int actualLine = 0;
		String line;
		int entry = 0;

		while(in.hasNextLine()){

			line = in.nextLine();
			actualLine++;
			String[] spaceSplit = line.split(" ");

			for(int i=0; i<spaceSplit.length; i++){
				myHash.add(spaceSplit[i], actualLine);
				entry++;
				System.out.println("Entrada:" + entry + "  " + "Colisões" + myHash.getColisions());
			}
		}

		//System.out.println(myHash.get("Noé"));


	}

}
