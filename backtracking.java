import java.util.*;
public class backtracking {

    static int[][] costMatrix = {
        {0, 15, 25, 35},
        {15, 0, 30, 28},
        {25, 30, 0, 20},
        {35, 28, 20, 0}
    };

    static String[] locations = {"UPTM", "City B", "City C", "City D"};

    // backtracking
    static int minCostBT;
    static String bestPathBT;

    public static String backtrackingMCOP(int[][] dist) {
        minCostBT = Integer.MAX_VALUE;
        bestPathBT = "";

        boolean[] visited = new boolean[dist.length];
        visited[0] = true;

        backtrack(0, dist, visited, 1, 0, "UPTM");

        return "Backtracking Route: " + bestPathBT + " | Total Cost: " + minCostBT;
    }

    static void backtrack(int pos, int[][] dist, boolean[] visited, int count, int cost, String path) {
        if (count == dist.length) {
            int totalCost = cost + dist[pos][0];

            if (totalCost < minCostBT) {
                minCostBT = totalCost;
                bestPathBT = path + " -> UPTM";
            }
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                backtrack(i, dist, visited, count + 1, cost + dist[pos][i], path + " -> " + locations[i]);

                visited[i] = false;
            }
        }
    }

    // main
    public static void main(String[] args) {
        System.out.println("Sample output:\n");
        System.out.println(backtrackingMCOP(costMatrix));
    }
}
