package bin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] a = new int[N];
        for(int i=0; i<N; i++){
            a[i] = sc.nextInt();
        }
        int result = trap(a);
        System.out.println(result);
    }
    public static int trap(int[] a){
        int result = 0;
        int len = a.length;
        if(len<=2){
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i=1; i < len ; i++) {
            left[i] = Math.max(left[i - 1], a[i - 1]);// 求出每个位置左边的最小值。
            right[len - 1 - i] = Math.max(right[len - i], a[len - i]);  // 求出每个位置右边的最小值
        }
        int tmp = 0;
        for(int i=0; i<len; i++){
            tmp = Math.min(left[i], right[i]);
            if(a[i] < tmp){
                result += (tmp - a[i]);
            }
        }
        return result;
    }
}
