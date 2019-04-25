package 华为;

import java.util.Scanner;

/**
 * @date 2019/3/30 22:39
 *
 *
 */
public class 句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String res = getResult(input);
        System.out.println(res);
    }

    private static String getResult(String input) {
        String res = "";
        String[] arr = input.split(" ");
        for(int i= arr.length-1; i>0; i--){
            res = res + arr[i] + " ";
        }
        res += arr[0];
        return res;
    }
}
