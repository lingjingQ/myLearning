package 华为;

import java.util.Scanner;

public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String res = getResult(input);
        System.out.println(res);
    }
    public static String getResult(String input){
        String res = "";
        for(int i=input.length()-1; i>=0; i--){
            if(res.indexOf(input.charAt(i))<0){
                res += input.charAt(i);
            }
        }
        return res;
    }
}
