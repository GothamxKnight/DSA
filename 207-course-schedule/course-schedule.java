class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<>());
        for (int[] arr : prerequisites) {
            map.get(arr[0]).add(arr[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] nocycle = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!nocycle[i]) {
                visited[i] = true;
                if (dfs(map, visited, i, nocycle))
                    return false;
                visited[i] = false;
                nocycle[i] = true;
            }
        }
        return true;
    }

    static boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int j, boolean[] nocycle) {
        List<Integer> list = map.get(j);
        for (int i = 0; i < list.size(); i++) {
            if (!nocycle[list.get(i)]) {
                if (visited[list.get(i)]) {
                    return true;
                }
                visited[list.get(i)] = true;
                if (dfs(map, visited, list.get(i), nocycle))
                    return true;
                visited[list.get(i)] = false;
                nocycle[list.get(i)] = true;
            }
        }
        return false;
    }
}