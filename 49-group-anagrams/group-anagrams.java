class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> m = new HashMap<>();
        for(String s:strs){
            int[] freq = new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            String key = Arrays.toString(freq);
            m.putIfAbsent(key,new ArrayList<String>());
            m.get(key).add(s);
        }
        for(String l:m.keySet()){
            List<String> temp = new ArrayList<>();
            for(String t: m.get(l)){
                temp.add(t);
            }
            ans.add(temp);
        }
        return ans;
    }
}