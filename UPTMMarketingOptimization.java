import java.util.*;
public class UPTMMarketingOptimization {
    // Cost Matrix (Adjacency Matrix)
    static int[][] costMatrix = {
              {0, 15, 25, 35},
              {15, 0, 30, 28},
             {25, 30, 0, 20},
             {35, 28, 20, 0}
    };
    // Location names
    static String[] locations = {"UPTM", "City B", "City C", "City D"};
    // Greedy TSP
   public static String greedyMCOP(int[][] dist) {
    int n = dist.length;
    boolean[] visited = new boolean[n];
    StringBuilder route = new StringBuilder();
    
    int current = 0;
    visited[current] = true;
    route.append(locations[current]);
    int totalCost = 0;

    for (int i = 1; i < n; i++) {
        int nextCity = -1;
        int minCost = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            if (!visited[j] && dist[current][j] < minCost) {
                minCost = dist[current][j];
                nextCity = j;
            }
        }
        visited[nextCity] = true;
        route.append(" -> ").append(locations[nextCity]);
        totalCost += minCost;
        current = nextCity;
    }

    totalCost += dist[current][0];
    route.append(" -> ").append(locations[0]);
    return "Greedy Route: " + route.toString() + " | Total Cost: " + totalCost;
  }
  public static void main(String[] args) {
      System.out.println(greedyMCOP(costMatrix));
  }
}
