class Solution {
     public int maxProfit(int[] prices) {
         
         int l = 0, r = 1, profit = 0;
         //l means buying , right means selling
         while(r < prices.length){
             if(prices[l] < prices[r]){ //find minimum price
                 if(profit < prices[r]-prices[l]) profit = prices[r] - prices[l]; //find maximum profit
             }
             else
                l = r;
            
             r += 1;
         }
         
         return profit;
         
         
         
//         int profit = 0;
//         int min_price = Integer.MAX_VALUE;
        
//         for(int i=0;i<prices.length;i++){
//             if(prices[i] < min_price){
//                 min_price = prices[i];
//             }
//             if(profit < prices[i] - min_price){
//                 profit = prices[i] - min_price;
//             }
//         }
//         return profit;
     }
    

}
