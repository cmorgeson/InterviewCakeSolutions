/*
    Problem #1
    Apple Stocks
    https://www.interviewcake.com/question/java/stock-price

    Expected Output:
    6
*/

class AppleStocks {
    public static int getMaxProfit(int[] stockPricesYesterday) {
        if (stockPricesYesterday == null || stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Bad input");
        }

        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1]-stockPricesYesterday[0];

        for (int i=1; i<stockPricesYesterday.length; i++) {
            int price = stockPricesYesterday[i];
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        System.out.println(String.valueOf(getMaxProfit(stockPrices)));
    }
}