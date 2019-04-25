package _260;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/3 20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int [] p = new int[2];
        for(int i=0; i<m; i++){
            p[0] = sc.nextInt();
            p[1] = sc.nextInt();
            if(p[0] == 0){
                // 升序排列 0...p[1]
                Arrays.sort(a,0,p[1]);
            }else {
                // 降序排列  0...p[1]
                Arrays.sort(a,0,p[1]);//先升序，再首尾调换，从而降序
                for(int j=0; j<=(0+p[1])/2; j++){
                    int temp = a[j];
                    a[j] = a[p[1]-j-1];
                    a[p[1]-j-1] = temp;
                }
            }
        }

        //输出
        for(int i=0; i<a.length-1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(a[a.length-1]);
    }
}
