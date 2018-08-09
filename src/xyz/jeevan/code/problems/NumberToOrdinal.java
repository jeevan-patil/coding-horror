package xyz.jeevan.code.problems;

import java.util.logging.Logger;

/**
 * Convert 1 -> 1st, 2 -> 2nd, 31 -> 31st, 12 -> 12th
 */
public class NumberToOrdinal {

  private static Logger log = Logger.getLogger("NumberToOrdinal");

  public static void main(String[] args) {
    log.info(new NumberToOrdinal().convert(13));
  }

  String convert(final int number) {
    String[] ordinals = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
    int modBy100 = number % 100;

    switch (modBy100) {
      case 11:
      case 12:
      case 13:
        return number + "th";
      default:
        return number + ordinals[number % 10];
    }
  }
}
