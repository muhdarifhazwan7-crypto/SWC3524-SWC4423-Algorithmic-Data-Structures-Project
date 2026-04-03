import java.util.*;
public class dynamicprogramming
 {
    static int[][] costMatrix = {
        {0, 15, 25, 35},
        {15, 0, 30, 28},
        {25, 30, 0, 20},
        {35, 28, 20, 0}
    };
    static String[] locations = {"UPTM", "City B", "City C", "City D"};

    // dynamic programming
    public static String dynamicProgrammingMCOP(int[][] dist) {
        int n = dist.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] memo = new int[n][1 << n];
        String[][] pathMemo = new String[n][1 << n];
        
        for (int[] row : memo) Arrays.fill(row, -1);
        
        int cost = tsp(0, 1, dist, memo, pathMemo, VISITED_ALL);
        String path = "UPTM" + (pathMemo[0][1] == null ? "" : pathMemo[0][1]) + " -> UPTM";
        
        return "Dynamic Programming Route: " + path + " | Total Cost: " + cost;
    }

    static int tsp(int pos, int mask, int[][] dist, int[][] memo, String[][] pathMemo, int VISITED_ALL) {
        if (mask == VISITED_ALL)
            return dist[pos][0];
        
        if (memo[pos][mask] != -1)
            return memo[pos][mask];

        int ans = Integer.MAX_VALUE;
        String bestPath = "";
        
        for (int city = 0; city < dist.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(city, mask | (1 << city), dist, memo, pathMemo, VISITED_ALL);
                if (newCost < ans) {
                    ans = newCost;
                    bestPath = " -> " + locations[city] + (pathMemo[city][mask | (1 << city)] == null ? "" : pathMemo[city][mask | (1 << city)]);
                }
            }
        }
        pathMemo[pos][mask] = bestPath;
        return memo[pos][mask] = ans;
    }

    //main
    public static void main(String[] args) {
        System.out.println("Sample output:\n");
        System.out.println(dynamicProgrammingMCOP(costMatrix));
    }
}
