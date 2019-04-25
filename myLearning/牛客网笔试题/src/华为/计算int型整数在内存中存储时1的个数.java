package 华为;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/3/31 11:11
 */
public class 计算int型整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 首先一个整数在内存中是怎么存的？补码？
        // 假设是补码，我直接拿这个补码和1相与，与完右移，直到整个数为0为止
        int count = 0;
        while(n!=0){
            if((n&1) == 1) {
                // 末位是1，
                count++;

            }
            n = n>>1;
        }
        System.out.println(count);
    }
}
