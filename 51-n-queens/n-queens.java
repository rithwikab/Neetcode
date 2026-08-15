class Solution {
    List<List<String>> ans = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pdiag = new HashSet<>();
    Set<Integer> ndiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        backtrack(n,0,new int[n]);
        return ans;
    }
    public void backtrack(int n, int row,int[] curList){
        if(row==n){
            populateList(curList);
            return;
        }
        for(int c=0;c<n;c++){
            if(cols.contains(c) || pdiag.contains(c+row) || ndiag.contains(c-row)){
                continue;
            }
            curList[row] = c;
            cols.add(c);
            pdiag.add(row+c);
            ndiag.add(c-row);
            backtrack(n,row+1,curList);
            curList[row] = 0;
            cols.remove(c);
            pdiag.remove(c+row);
            ndiag.remove(c-row);
        }
        return;
    }
    public void populateList(int[] curList){
        List<String> l = new ArrayList<>();
        int n = curList.length;
        for(int i:curList){
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            sb.setCharAt(i,'Q');
            l.add(sb.toString());
        }
        ans.add(l);
        return;
    }

}