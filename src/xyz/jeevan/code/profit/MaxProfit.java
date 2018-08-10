package xyz.jeevan.code.profit;

public class MaxProfit {

  public static void main(String[] args) {
    int[] data = {2, 5, 6, 1, 3, 0};

    System.out.println(new MaxProfit().maxProfit(data));
  }

  public int maxProfit(int[] prices) {
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      for (int j = (i + 1); j < prices.length; j++) {
        if ((prices[j] - prices[i]) > maxProfit) {
          maxProfit = (prices[j] - prices[i]);
        }
      }
    }

    return maxProfit;
  }
}