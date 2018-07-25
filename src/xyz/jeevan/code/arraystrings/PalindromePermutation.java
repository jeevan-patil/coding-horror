package xyz.jeevan.code.arraystrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, check if it is a permutation of a palindrome.
 *
 * For example - Any permutation of "code" can not be a palindrome. However, permutation of "aab"
 * can be a palindrome.
 *
 * @author jeevan
 */
public class PalindromePermutation {

  public static void main(String[] args) {
    System.out.println(new PalindromePermutation().isPermutationOfPalindrome("aab"));
  }

  /**
   * Implementation using Set of characters.
   */
  boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (!set.add(s.charAt(i))) {
        set.remove(s.charAt(i));
      }
    }
    return set.size() <= 1;
  }

  /**
   * Implementation using array.
   */
  boolean isPermutationOfPalindrome(String word) {
    int oddCount = 0;
    int[] characters = new int[Character.getNumericValue('z') -
        Character.getNumericValue('a') + 1];

    for (char c : word.toCharArray()) {
      int cValue = getCharacterNumber(c);

      if (cValue != -1) {
        characters[cValue]++;
        if (characters[cValue] % 2 == 1) {
          oddCount++;
        } else {
          oddCount--;
        }
      }
    }

    return oddCount <= 1;
  }

  /**
   * Map a->0, b->1 ....
   */
  private int getCharacterNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int value = Character.getNumericValue(c);

    if (a <= value && value <= z) {
      return value - a;
    }

    return -1;
  }
}
