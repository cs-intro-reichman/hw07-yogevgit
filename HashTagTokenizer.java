

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");

		breakHashTag(hashTag, dictionary);
		
		//for (int i = 0; i < dictionary.length; i++)
		//{
		//	System.out.println(dictionary[i]);
		//}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		
		In in = new In(fileName);
		
		for (int i = 0; i < dictionary.length; i++)
		{
			dictionary[i] = in.readLine();
		}
		

		// Your code here

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		
          for (int i = 0; i < dictionary.length; i++)
		  {
			if (word.equals(dictionary[i])) return true;
		  }
		  return false;
        
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		String newword = "";

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
            newword = newword +hashtag.charAt(i-1);
			if (existInDictionary(newword, dictionary)==true) 
			{
				System.out.println(newword);
				
				breakHashTag(hashtag.substring(i), dictionary);
		
            }
		}
		
    }

}
