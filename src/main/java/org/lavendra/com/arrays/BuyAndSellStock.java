package org.lavendra.com.arrays;

public class BuyAndSellStock {

    public static void main(String[] args) {
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        int[] stockPriceArray = {7, 1, 5, 3, 2};
        System.out.println(buyAndSellStock.maxProfitDay(stockPriceArray));
    }

    public int maxProfitDay(int[] daysArray) {
        int maxProfit = Integer.MIN_VALUE;
        int minimumPurchase = daysArray[0];
        int currentProfit = 0;
        int maxProfitDay = -1;
        for (int i = 1; i < daysArray.length; i++) {
            currentProfit = daysArray[i] - minimumPurchase;
            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
                maxProfitDay = i;
            }
            if (daysArray[i] < minimumPurchase) {
                minimumPurchase = daysArray[i];
            }
        }
        return maxProfitDay + 1;
    }
}
