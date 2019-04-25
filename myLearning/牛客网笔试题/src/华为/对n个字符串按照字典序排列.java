package 华为;

import com.sun.tools.jconsole.JConsoleContext;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @date 2019/3/30 22:47
 * Array.sort 可以直接对单词进行排序
 */
public class 对n个字符串按照字典序排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr);
        for(int i=0; i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
