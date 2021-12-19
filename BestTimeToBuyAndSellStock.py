class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #We need to find min price to define max profit
        profit=0
        min_price = sys.maxsize
        
        for price in prices:
            min_price = min(price, min_price)
            profit = max(profit, price-min_price)
        
        return profit
