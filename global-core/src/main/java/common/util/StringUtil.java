package common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Utility class for String data type.
 * 
 * @author Leo Sendra
 */
public class StringUtil {

	/**
	 * Add n character on left side of word.
	 * 
	 * @param word
	 *            word string to be added
	 * @param addedChar
	 *            character to be added to word
	 * @param totalFinalChars
	 *            total character to be added
	 * @return full word with added character
	 */
	public static String addCharToLeft(String word, char addedChar,
			int totalFinalChars) {
		for (int n = word.length() + 1; n <= totalFinalChars; n++) {
			word = addedChar + word;
		}

		return word;
	}

	public static String conversion(Long number) {
		String[] letter = { "", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam",
				"Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas" };
		String result = "";
		if (number < 12) {
			int temp = number.intValue();
			result = result + letter[temp];
		} else if (number < 20)
			result = result + conversion(number - 10) + " Belas";
		else if (number < 100)
			result = result + conversion(number / 10) + " Puluh "
					+ conversion(number % 10);
		else if (number < 200)
			result = result + "Seratus " + conversion(number - 100);
		else if (number < 1000)
			result = result + conversion(number / 100) + " Ratus "
					+ conversion(number % 100);
		else if (number < 2000)
			result = result + "Seribu " + conversion(number - 1000);
		else if (number < 1000000)
			result = result + conversion(number / 1000) + " Ribu "
					+ conversion(number % 1000);
		else if (number < 1000000000)
			result = result + conversion(number / 1000000) + " Juta "
					+ conversion(number % 1000000);
		else if (number < (new Long("1000000000000")))
			result = result + conversion(number / 1000000000) + " Miliyar "
					+ conversion(number % 1000000000);
		else if (number < (new Long("1000000000000000")))
			result = result
					+ conversion(number
							/ (new Long("1000000000000")).longValue())
					+ " Triliun "
					+ conversion(number
							% (new Long("1000000000000")).longValue());
		return result;
	}

	/**
	 * Add n character on right side of word.
	 * 
	 * @param word
	 *            word string to be added
	 * @param addedChar
	 *            character to be added to word
	 * @param totalFinalChars
	 *            total character to be added
	 * @return full word with added character
	 */
	public static String addCharToRight(String word, char addedChar,
			int totalFinalChars) {
		for (int n = word.length() + 1; n <= totalFinalChars; n++) {
			word = word + addedChar;
		}

		return word;
	}

	/**
	 * Convert a value into default / other value. Conversion happen if checked
	 * value is null or empty.
	 * 
	 * @param val
	 *            checked / to be converted value
	 * @param defVal
	 *            replacement value if checked value is null / empty
	 * @return result
	 */
	public static String nevl(String val, String defVal) {
		if (val == null)
			return defVal;

		if (val.isEmpty())
			return defVal;

		if (val.equals("null"))
			return defVal;

		return val;
	}

	/**
	 * Convert a value into default / other value. Conversion happen if checked
	 * value is null or empty.
	 * 
	 * @param val
	 *            checked / to be converted value
	 * @param defVal
	 *            replacement value if checked value is null / empty
	 * @param added
	 *            added string
	 * @return result
	 */
	public static String nevlo(String val, String defVal) {
		if (val == null || val.isEmpty() || val.equals("null"))
			return surroundString("", defVal);

		return surroundString(val, defVal);
	}

	/**
	 * Add another string in front and behind a string
	 * 
	 * @param word
	 *            String to be added
	 * @param added
	 *            added string
	 * @return
	 */
	public static String surroundString(String word, String added) {
		return added + word + added;
	}

	/**
	 * Replace multiple spaces with single space
	 * 
	 * @param word
	 * @return
	 */
	public static String eliminateSpace(String word) {
		return word.trim().replaceAll(" +", " ");
	}

	/**
	 * Convert something into camel case format. Usually to convert db property
	 * name into java standard format.
	 * 
	 * @param s
	 *            string to be formatted
	 * @return
	 */
	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part);
		}
		return camelCaseString;
	}

	private static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	public static String toCapitalSnakeCase(String camelCase) {
		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";

		return camelCase.replaceAll(regex, replacement).toUpperCase();
	}

	public static String toCapitalSnakeCaseWithNumber(String camelCase) {
		String regex = "([a-z0-9])([A-Z0-9])";
		String replacement = "$1_$2";

		return camelCase.replaceAll(regex, replacement).toUpperCase();
	}

	public static List<Object[]> removeDuplicates(List<Object[]> list) {

		// Store unique items in result.
		List<Object[]> result = new ArrayList<>();

		// Record encountered Strings in HashSet.
		HashSet<Object[]> set = new HashSet<>();

		// Loop over argument list.
		for (Object[] item : list) {

			// If String is not in set, add it to the list and the set.
			if (!set.contains(item)) {
				result.add(item);
				set.add(item);
			}
		}
		return result;
	}

	public static String replaceChar(String value, char delimiterValue,
			char newDelimiterValue) {
		if (value == null) {
			return null;
		}

		return value.replace(delimiterValue, newDelimiterValue);
	}

	public static String rataKanan(int length, String str) {
		StringBuffer result = new StringBuffer();
		if (str == null) {
			throw new RuntimeException("Woy nilainya dikasih donk!");
		}

		StringBuffer sb = new StringBuffer();
		sb.append(str);
		if (length < sb.length()) {
			length = sb.length();
		}

		for (int i = 0; i < length; i++) {
			result.append(" ");
		}

		for (int i = 0; i < sb.length(); i++) {
			int countToInsert = (length - i) - 1;
			result.setCharAt(countToInsert, sb.charAt((sb.length() - 1) - i));
		}

		return result.toString();

	}
}