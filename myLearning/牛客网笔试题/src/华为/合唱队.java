//package 华为;
//
//import java.util.Scanner;
//
///**
// * @athor LingjingQ
// * @date 2019/4/13 12:07
// */
//public class 合唱队 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] h = new int[n];
//        for(int i=0; i<n; i++){
//            h[i] = sc.nextInt();
//        }
//        System.out.println(getResult(h));
//    }
//    public static int getResult(int[] h){
//        // 对于每一个同学，计算以他为中心时左边递增序列长度+右边递减序列长度-1,取最大值，就是我们想要的maxk值
//        int maxk = 0;
//
//        for(int i=0; i<h.length; i++){
//            // 从0到i的最长递增子序列的长度
//            int leftMaxUpLength = getLeftMaxUpLength(h,i);
//            int rightMaxDownLength = getRightMaxDownLength(h,i);
//            int k = leftMaxUpLength + rightMaxDownLength - 1;
//            maxk = Math.max(maxk,k);
//        }
//        return h.length-maxk;
//    }
//
//    private static int getRightMaxDownLength(int[] h, int i) {
//       int[] dp = new int[h.length-i];
//
//    }
//
//    private static int getLeftMaxUpLength(int[] h, int i) {
//        int[] dp = new int[i+1];
//        dp[0] = 1;
//        for(int j = 1; j<=i; j++){// 构造从1到i的dp数组
//            for(int k=0; k<j; k++ ){
//                // 对于dp数组的每一个元素，我都要判断该元素之前的所有元素，只要能满足以该元素结尾，就考虑其所构成的长度是否为最大值
//                if(h[k]<h[j]){
//                    dp[j] = Math.max(dp[j],dp[k]+1);
//                }
//            }
//        }
//        int leftMaxUpLength = 0;
//        for(int j=0; j<=i; j++){
//            leftMaxUpLength = Math.max(leftMaxUpLength,dp[j]);
//        }
//        return leftMaxUpLength;
//    }
//}
