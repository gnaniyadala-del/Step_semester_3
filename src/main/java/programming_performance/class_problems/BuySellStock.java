package programming_performance.class_problems;


    public class BuySellStock {
        public static int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;

            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {

                int currentProfit = prices[i] - minPrice;


                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }


                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }
            }
            return maxProfit;
        }

        public static void main(String[] args) {
            int[] prices = {7, 1, 5, 3, 6, 4};
            System.out.println(maxProfit(prices));
        }
    }

