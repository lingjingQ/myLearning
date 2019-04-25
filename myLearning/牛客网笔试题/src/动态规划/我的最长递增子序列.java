package 动态规划;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/13 11:41
 * 测试用例：
 *        输入：
         *  9
         * 10 22 9 33 21 50 41 60 80
 *     输出：6
 */
public class 我的最长递增子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new  int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(LongestSubString(arr));
    }

    private static int LongestSubString(int[] arr) {
        int res = 0;
        int [] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1; i<arr.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int i=0; i<dp.length; i++){
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
