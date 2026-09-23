class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> lastseen=new HashMap<>();
        int left=0;
        int maxlength=0;
        for(int right=0;right<s.length();right++){
        char ch =s.charAt(right);
        if(lastseen.containsKey(ch) &&lastseen.get(ch)>=left){
            left=lastseen.get(ch)+1;
        }
        lastseen.put(ch,right);
        maxlength=Math.max(maxlength, right-left+1);
    }
    return maxlength;
    }
}