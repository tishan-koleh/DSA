package Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(10);
        graph.add(List.of(1));
        graph.add(Arrays.asList(2,6));
        graph.add(Arrays.asList(1,3,4));
        graph.add(List.of(2));
        graph.add(Arrays.asList(2,5));
        graph.add(Arrays.asList(4,8));
        graph.add(Arrays.asList(1,7,9));
        graph.add(Arrays.asList(6,8));
        graph.add(Arrays.asList(7,5));
        graph.add(List.of(6));

        int[] visited = new int[10];
        bfs(graph, visited);
    }

    private static void bfs(List<List<Integer>> graph, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        int startNode = 1;
        queue.offer(startNode);
        visited[startNode] = 1;

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current+ " ");

            for (int i : graph.get(current)){
                if (visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
