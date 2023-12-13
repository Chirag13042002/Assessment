/**
 * 
 */
package Solution;

/**
 * @author chiragdahiya02
 *
 */
public class Assignment {

	/**
	 * @param args
	 */

	// I've separated each of the conditions into functions in order to allow unit
	// testing
	public static boolean is_Sentence(String sentence) {

// To check if the sentence is valid or not		
		boolean isValid = true;
		if (periodChecker(sentence) == false) {
			isValid = false;
		}
		if (punctuationChecker(sentence) == false) {
			isValid = false;
		}
		if (quotationChecker(sentence) == false) {
			isValid = false;
		}
		if (capitalChecker(sentence) == false) {
			isValid = false;
		}
		if (belowThirteenChecker(sentence) == false) {
			isValid = false;
		}

		if (isValid == false) {
			return false;
		} else {
			System.out.println("String is a valid sentence");
			return true;
		}
	}

	public static boolean periodChecker(String sentence) {

		// To check if string has no periodChecker characters other than last character
		for (int i = 0; i < sentence.length() - 1; i++) {
			if (sentence.charAt(i) == '.') {
				System.out.println("Invalid sentence: There shouldn't be period character other than last character");
				return false;
			}
		}
		return true;
	}

	public static boolean punctuationChecker(String sentence) {

		// To check if string ends with one of the following termination character: ".",
		// "?", "!"
		switch (sentence.charAt(sentence.length() - 1)) {
		case '!':
		case '?':
		case '.':
			break;
		default:
			System.out.println("Invalid sentence: String must end with termination character");
			return false;
		}
		return true;
	}

	public static boolean quotationChecker(String sentence) {

		// To check if string has an even number of quotation marks
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == 34 || sentence.charAt(i) == 39) {
				count++;
			}
		}
		if (count % 2 == 1) {
			System.out.println("Invalid sentence: There can only be even number of quotation marks ");
			return false;
		}
		return true;
	}

	public static boolean capitalChecker(String sentence) {

		// To check if string starts with capital letter
		if (sentence.charAt(0) < 65 || sentence.charAt(0) > 90) {
			System.out.println("Invalid sentence: String must start with capital letter ");
			return false;
		}
		return true;
	}

	public static boolean belowThirteenChecker(String sentence) {

		// To check if numbers below 13 are spelled out
		int len = sentence.length();
		String numStr = "";
		for (int i = 0; i < len; i++) {
			numStr = "";
			int increment = 0;
			if (sentence.charAt(i) >= 48 && sentence.charAt(i) <= 57) {
				numStr += sentence.charAt(i);

				for (int j = i + 1; j < sentence.length(); j++) {
					if (sentence.charAt(j) >= 48 && sentence.charAt(j) <= 57) {
						increment++;
						numStr += sentence.charAt(j);
					} else {
						break;
					}
				}
				i += increment;
				int numint = Integer.parseInt(numStr);
				if (numint < 13) {

					System.out.println("Invalid sentence: Numbers below 13 should be spelled out");
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Unit tests - belowthirteenChecker()

		if (belowThirteenChecker("I have 11 dogs") == false) {
			System.out.println("Test1 passed");
		} else {
			System.out.println("Test1 failed");
		}
		// Unit tests - capitalChecker()

		if (capitalChecker("one lazy dog is too few, thirteen is too many.") == false) {
			System.out.println("Test2 passed");
		} else {
			System.out.println("Test2 failed");
		}

		// Unit tests - periodChecker()

		if (periodChecker("the quick brown fox said. “hello Mr lazy dog.") == false) {
			System.out.println("Test3 passed");
		} else {
			System.out.println("Test3 failed");
		}
		// Unit tests - quotationChecker()

		if (quotationChecker("I like to travel \"and explore new cultures") == false) {
			System.out.println("Test4 passed");
		} else {
			System.out.println("Test4 failed");
		}
		// Unit tests - punctuationChecker()

		if (punctuationChecker("My favourite city is London") == false) {
			System.out.println("Test5 passed");
		} else {
			System.out.println("Test5 failed");
		}
		is_Sentence("Hello my name is Chirag and I am '21' years old!");
	}
}
