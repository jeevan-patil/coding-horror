package xyz.jeevan.code.arraystrings;

/**
 * Check if two strings contain same characters.
 *
 * @author jeevan
 */
public class StringEquality {

  public static void main(String[] args) {
    System.out.println(new StringEquality().areStringsEqual("name", "mane"));
  }

  public boolean areStringsEqual(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] letters = new int[128];
    for (char c : str1.toCharArray()) {
      letters[c]++;
    }

    for (int i = 0; i < str2.length(); i++) {
      int index = (int) str2.charAt(i);
      letters[index]--;

      if (letters[index] < 0) {
        return false;
      }
    }

    return true;
  }
}
