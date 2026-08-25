class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set <Integer> set=new HashSet<>();
        for(int x:nums){
        set.add(x);
        }
        for(int x=k;;x+=k){
            if(!set.contains(x)){
                return x;
            }
        }
    }
}