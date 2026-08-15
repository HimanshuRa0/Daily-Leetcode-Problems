class Solution {
    public int maxProfit(int[] prices) {
        int mini=Integer.MAX_VALUE;
        int Maxprofit=0;
        for(int price:prices)
        {
            if(price<mini){
            mini=price;
            }
            else{
                Maxprofit=Math.max(Maxprofit,price-mini);
            }
        }
        return Maxprofit;
    }
}