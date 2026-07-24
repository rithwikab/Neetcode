class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m = new HashMap();
        int n = s.length();
        int len = 0;
        int l =0, r = 0;
        while(r<n){
            char c= s.charAt(r);
            if(m.containsKey(c)){
                // char already in map, encountered before
                int pos = m.get(c);
                while(l<=pos){
                    if(m.get(s.charAt(l)) <= pos){
                        m.remove(s.charAt(l));
                    }
                    l++;
                }
            }
            m.put(c,r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}