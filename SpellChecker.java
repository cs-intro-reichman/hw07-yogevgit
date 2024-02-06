public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		//int threshold = Integer.parseInt(args[1]);
		//String[] dictionary = readDictionary("dictionary.txt");
		//String correction = spellChecker(word, threshold, dictionary);
		//System.out.println(correction);
		String word1 = args[1];
		System.out.println(levenshtein(word,word1));

		
	}

	public static String tail(String str) {
		// Your code goes here
		return str.substring(1,str.length());

	}
	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word2.length() == 0) 
		{
			return word1.length();	
		}
		if (word1.length() == 0) 
		{
			return word2.length();	
		}
		if (word1.charAt(0) == word2.charAt(0)) 
		{
			return levenshtein(tail(word1),tail(word2));	
		}
		else
		{
			return Math.min((levenshtein(tail(word1),word2)),Math.min((levenshtein(word1,tail(word2))),levenshtein(tail(word1),tail(word2)))) + 1;


		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0;i < 3000 ;i++ ) 
		{
			dictionary[i] = in.readLine();	
		}

		return dictionary;
	}
	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int [] editDistance = new int[3000];
		for (int i = 0;i < 3000 ;i++) 
		{
			editDistance[i] = levenshtein(word,dictionary[i]);	
		}
		int minEditDistance = minOfArray(editDistance);
		int indexOfMin = indexOfMinInArray(editDistance);
		if (minEditDistance <= threshold) 
		{
			return dictionary[indexOfMin];	
		}
		else
		{
			return word;
		}

	}
	public static int minOfArray(int [] array)
	{
		int min = array[0];
		for (int i = 1;i < array.length ;i++) 
		{
			if (array[i] < min) 
			{
				min = array[i];	
					
			}	
		}
		return min;
	}
	public static int indexOfMinInArray(int [] array)
	{
		int index = 0;
		for (int i = 0;i < array.length ;i++) 
		{
			if (array[i] == minOfArray(array)) 
			{
				index = i;	
				break;
			}
		}
		return index;
	}
	public static void print(int [] array)
	{
		for (int i = 0;i < array.length ;i++) 
		{
			System.out.println(array[i]);	
		}
	}
}