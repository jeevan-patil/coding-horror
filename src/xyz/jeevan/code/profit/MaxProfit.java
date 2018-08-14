package xyz.jeevan.code.profit;

/**
 * Calculate the max profit one can earn. Given an array of prices of shares, the index define the
 * day at which value was the price.
 */
public class MaxProfit {

  public static void main(String[] args) {
    int[] data = {10, 5, 3, 1, 0, 4, 2, 3, 9};
    System.out.println(new MaxProfit().maxProfit(data));
  }

  public int maxProfit(int[] prices) {
    int maxPrice = 0;
    int minPrice = prices[0];

    for (int i = 0; i <= prices.length - 2; i++) {
      if (prices[i + 1] > prices[i]) {
        maxPrice = prices[i + 1];
        minPrice = (prices[i] < minPrice ? prices[i] : minPrice);
      }
    }

    return (maxPrice - minPrice);
  }
}