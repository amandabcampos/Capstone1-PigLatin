import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 * 
 */

public class PigLatin {
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		boolean looping = true;	
		while(looping) {
				
			System.out.println("Enter a sentence: ");
			String sentence = scnr.nextLine();
			
			boolean hasNumbersOrSymbols = false;
			for(int i=0; i<sentence.length();i++) {
				if (!Character.toString(sentence.charAt(i)).matches("(?i)[a-z\\s'!?,.:;]")) {
					hasNumbersOrSymbols = true;
					break;
				}
			}
				
			if((!sentence.isBlank()) && (!hasNumbersOrSymbols)) { 
			
				String[] words = sentence.split(" ");			
				String[] wordsLowerCase = sentence.toLowerCase().split(" ");
				
				String sentenceTranslated = "";
					
				int index = 0;
						
				for (int i=0; i<words.length; i++) { 
					for (int j=0; j<words[i].length(); j++) { 
						if (wordsLowerCase[i].charAt(j) == 'a' || wordsLowerCase[i].charAt(j) == 'e' || 
							wordsLowerCase[i].charAt(j) == 'i' || wordsLowerCase[i].charAt(j) == 'o' ||
							wordsLowerCase[i].charAt(j) == 'u') {
							index = j;	
							break;
						}
					}
					if (index == 0) {
						sentenceTranslated += words[i] + "way" + " ";
					} else {
						sentenceTranslated += words[i].substring(index) + words[i].substring(0,index) + "ay" + " ";
					}
					
				}
				
				System.out.println(sentenceTranslated);
			
			} else if (!sentence.isBlank() && hasNumbersOrSymbols){
				System.out.println(sentence);
			} else {
				System.out.println("You didn't enter any text");
			}
			
			System.out.println("Translate another line? (y/n)?: ");
			if (scnr.nextLine().startsWith("n")) {
				System.out.print("Bye");
				looping = false;
			}
				
		}
		scnr.close();		
	}

}
