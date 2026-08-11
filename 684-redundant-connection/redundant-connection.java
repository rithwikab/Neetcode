class Solution {
    class UnionSet{
        int parent;
        int size;
        UnionSet(){}
        UnionSet(int p, int s){
            this.parent = p;
            this.size = s;
        }
    }
    Map<Integer,UnionSet> map = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int idx = 0;
        for(int i=1;i<=n;i++){
            UnionSet cur = new UnionSet(i,1);
            map.put(i,cur);
        }
        for(int i=0;i<n;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!union(a,b)){
                idx = i;
            }

        }
        return edges[idx];
    }
    public boolean union(int a, int b){
        UnionSet p1 = find(a);
        UnionSet p2 = find(b);
        if(p1.parent == p2.parent)return false;
        if(p1.size <= p2.size){
            p1.parent = p2.parent;
            p2.size += p1.size;
            p1.size = p2.size;
            map.put(p1.parent,p2);
            map.put(p2.parent,p2);
        }
        else{
            p2.parent = p1.parent;
            p1.size += p2.size;
            p2.size = p1.size;
            map.put(p1.parent,p1);
            map.put(p2.parent,p1);
        }
        return true;
    }
    public UnionSet find(int a){
        if(map.get(a).parent == a)return map.get(a);
        while(map.get(a).parent != a){
            a = map.get(a).parent;
        }
        return map.get(a);
    }
}