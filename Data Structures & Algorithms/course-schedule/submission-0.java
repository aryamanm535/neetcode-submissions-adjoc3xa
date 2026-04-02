class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] curr : prerequisites){
            if(!preMap.containsKey(curr[0])){
                preMap.put(curr[0], new ArrayList<>(Arrays.asList(curr[1])));
            }
            preMap.get(curr[0]).add(curr[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c))
                return false;
        }

        return true;
    }

    private boolean dfs(int course){
        if(visiting.contains(course))
            return false;
        
        if(preMap.get(course) == null)
            return true;
        
        visiting.add(course);
        for(int pre : preMap.get(course))
            if(!dfs(pre))
                return false;

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
