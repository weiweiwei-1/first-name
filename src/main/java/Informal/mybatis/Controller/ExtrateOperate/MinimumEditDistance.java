package Informal.mybatis.Controller.ExtrateOperate;

public class MinimumEditDistance {
    public static int minEditDistance(String dest, String src) {
        int[][] f = new int[dest.length()+1][src.length() + 1];
        f[0][0] = 0;
        for (int i = 1; i < dest.length() + 1; i ++ ) {
            f[i][0] = i;
        }
        for (int i = 1; i < src.length() + 1; i ++ ) {
            f[0][i] = i;
        }
        for (int i = 1; i < dest.length() + 1; i ++ ) {
            for (int j = 1; j < src.length() + 1; j ++  ) {
                // 替换的开销
                int cost = 0;
                if (dest.charAt(i - 1) != src.charAt(j - 1)) {
                    cost = 1;
                }
                int minCost;
                if (f[i - 1][j] < f[i][j - 1]) {
                    minCost = f[i - 1][j] + 1;
                } else {
                    minCost = f[i][j - 1] + 1;
                }
                if (minCost > f[i - 1][j - 1] + cost) {
                    minCost = f[i - 1][j - 1] + cost;
                }
                f[i][j] = minCost;
            }
        }
        return f[dest.length()][src.length()];

    }
    public static void main(String[] args) {
        System.out.println(minEditDistance("中兴通讯", "海康威视"));
    }

}
