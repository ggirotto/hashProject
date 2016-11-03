package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class referenciaCruzada {

	public static void main(String[] args) throws FileNotFoundException {

		HashStructure myHash = new HashStructure(32);

		File f = new File("bibliaacentuada.txt");

		Scanner in = new Scanner(f);
		int actualLine = 0;
		String line;

		while(in.hasNextLine()){

			line = in.nextLine();
			actualLine++;
			String[] spaceSplit = line.split(" ");

			for(int i=0; i<spaceSplit.length; i++)
				myHash.add(spaceSplit[i], actualLine);
			
		}

		int [] colisoes = myHash.getColisions();
		for(int i=0; i<colisoes.length; i++)
			System.out.println("Indice  " + i + "\tColisões  " + colisoes[i]);


	}

}
