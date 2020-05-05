package Informal.mybatis.DataStructure;

public class Fenzhi {
    public static void main(String args[]){
        int[][] arr={{1 ,0, 1, 0 ,0},{1 ,1 ,1 ,1 ,1},{1, 1, 1 ,1, 1},{1 ,0 ,0 ,1 ,0}};
        //求01矩阵最大正方形面积
        int maxSquareSize = findMaxSquareSize(arr);
        System.out.println(maxSquareSize);
        //求01矩阵最大矩形面积
        int maxRectangleSize = findMaxRectangleSize(arr);
        System.out.println(maxRectangleSize);

    }


    /** 给定一个矩阵，其中的元素为0或者1，要求找出其中元素全为1的面积最大的正方形。
     * 动态规划：对每个元素，把以其为右下角，元素全为1的正方形的最长边长记录下来。如果以元素a(i, j)为右下角的正方形边长为b，
     * 那么以a(i-1, j)为右下角的正方形边长肯定为b-1，且以a(i, j-1)为右下角的正方形边长为b-1，否则正方形的边不完整。
     * dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
     * @param arr
     * @return
     */
    private static int findMaxSquareSize(int[][] arr) {
        if(arr==null||arr.length==0) return 0;
        int rows = arr.length;
        int cols = arr[0].length;
        int len = 0;
        int[][] dp = new int[rows+1][cols+1];
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=cols;j++) {
                if(arr[i-1][j-1]==1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    len = Math.max(dp[i][j],len);
                }
            }
        }
        return len*len;
    }
————————————————
    版权声明：本文为CSDN博主「ArcherLue」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/weixin_40661297/article/details/89921838
}
