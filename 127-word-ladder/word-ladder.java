class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
     if(!wordSet.contains(endWord)) return 0;
     Queue<String> q = new LinkedList<String>();
     q.offer(beginWord);
     if(wordSet.contains(beginWord))wordSet.remove(beginWord);
     int curDist = 1;
     while(!q.isEmpty()){
        int curLen = q.size();
        for(int i=0;i<curLen;i++){
            String curWord = q.poll();
            for(int j=0;j<curWord.length();j++){
                for(char c='a'; c<='z'; c++){
                    StringBuilder sb = new StringBuilder(curWord);
                    if(curWord.charAt(j)==c)continue;
                    sb.setCharAt(j,c);
                    String cur = sb.toString();
                    if(cur.equals(endWord))return 1+curDist;
                    if(!wordSet.contains(cur))continue;
                    q.offer(cur);
                    wordSet.remove(cur);
                }
            }
                       
        }
        curDist++;
         
     }
     return 0;  
    }
}