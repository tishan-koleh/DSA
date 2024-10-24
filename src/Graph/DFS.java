package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(Arrays.asList(2, 3));
        graph.add(Arrays.asList(1, 5, 6));
        graph.add(Arrays.asList(1, 4, 7));
        graph.add(Arrays.asList(3, 8));
        graph.add(List.of(2));
        graph.add(List.of(2));
        graph.add(Arrays.asList(3, 8));
        graph.add(Arrays.asList(4, 7));

        int[] visited = new int[9];
        dfs(1, graph, visited);
    }

    public static void dfs(int node, List<List<Integer>> graph, int[] visited){
        visited[node] = 1;
        System.out.print(node + " ");

        for (int i : graph.get(node)){
            if (visited[i] == 0){
                visited[i] = 1;
                dfs(i, graph, visited);
            }
        }
    }
}
