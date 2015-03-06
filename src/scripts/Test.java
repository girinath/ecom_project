package scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Test {
	public static void main(String args[]) throws FileNotFoundException {

		File f = new File("D:\\oapt.txt");
		Scanner sc = new Scanner(f);
		ArrayList<String> words = new ArrayList<String>();
		while (sc.hasNext()) {

			// System.out.println(sc.next());

			words.add(sc.next());

		}
		sc.close();

		for (String w : words) {
			
			System.out.println(w + " - " + Collections.frequency(words, w));
		}
	}
}