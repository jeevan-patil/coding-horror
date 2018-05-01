package xyz.jeevan.code.arraystrings;

/**
 * String compression. Convert aabbbcdde to a2b3c1d2e1. Return original string if could not be
 * compressed.
 *
 * @author jeevan
 */
public class StringCompression {

  public static void main(String[] args) {
    System.out.println(new StringCompression().compress("aabbbcdde"));
  }

  private String compress(String word) {
    StringBuilder compressed = new StringBuilder();

    int consecutiveCount = 0;
    for (int i = 0; i < word.length(); i++) {
      consecutiveCount++;

      if ((i + 1 >= word.length()) || (word.charAt(i) != word.charAt(i + 1))) {
        compressed.append(word.charAt(i));
        compressed.append(consecutiveCount > 1 ? consecutiveCount : "");
        consecutiveCount = 0;
      }
    }

    return compressed.toString();
  }
}
