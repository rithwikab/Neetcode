class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] in = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            graph[src].add(dest);
            in[dest]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<graph[cur].size();i++){
                int nei = graph[cur].get(i);
                in[nei]--;
                if(in[nei]==0)q.add(nei);
            }
        }
        for(int i:in){
            if(i!=0)return false;
        }
        return true;
    }
}