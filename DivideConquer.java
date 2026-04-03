import java.util.*;

public class DivideConquer {

    // Cost Matrix (Adjacency Matrix)
    static int[][] costMatrix = {
        {0,  15, 25, 35},
        {15, 0,  30, 28},
        {25, 30, 0,  20},
        {35, 28, 20, 0}
    };

    // Location names
    static String[] locations = {"UPTM", "City B", "City C", "City D"};
    
    // Divide and Conquer TSP
    static int minCostDC = Integer.MAX_VALUE;
    static String bestRouteDC = "";

    public static String divideAndConquerMCOP(int[][] dist) {
        minCostDC = Integer.MAX_VALUE;
        boolean[] visited = new boolean[dist.length];
        visited[0] = true;
        StringBuilder path = new StringBuilder(locations[0]);
        divideAndConquerHelper(0, visited, 0, dist, dist.length, path);
        return "Divide & Conquer Route: " + bestRouteDC + " | Total Cost: " + minCostDC;
    }

    private static void divideAndConquerHelper(int pos, boolean[] visited, int currentCost, int[][] dist, int n, StringBuilder path) {
        if (allVisited(visited)) {
            int totalCost = currentCost + dist[pos][0];
            if (totalCost < minCostDC) {
                minCostDC = totalCost;
                bestRouteDC = path.toString() + " -> " + locations[0];
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int len = path.length();
                path.append(" -> ").append(locations[i]);
                divideAndConquerHelper(i, visited, currentCost + dist[pos][i], dist, n, path);
                path.setLength(len);
                visited[i] = false;
            }
        }
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean b : visited) if (!b) return false;
        return true;
    }
    
    // Driver method
    public static void main(String[] args) {
        System.out.println(divideAndConquerMCOP(costMatrix));
        
    }
}
