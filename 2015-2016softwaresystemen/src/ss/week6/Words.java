package ss.week6;

import java.util.Scanner;

public class Words {
	static Scanner req = new Scanner(System.in);
	
	public static void main(String[] args){
		String[] words;
		System.out.println("Give sentence:");
		
		while (req.hasNextLine()){
			String input = req.nextLine();
			System.out.println("Line (or \"end\") :" + input);
			words = input.split(" ");
			if (words[0].equals("")){
				System.out.println("End of programme");
			}
			for(int i=0; i<words.length; i++){
				System.out.println("Word "+(i+1)+": "+words[i]);
			}
			System.out.println("Line (or \"end\") : end");
			System.out.println("End of programme.");
		}
	}
}