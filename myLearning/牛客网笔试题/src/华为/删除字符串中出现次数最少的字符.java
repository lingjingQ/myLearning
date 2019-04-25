package 华为;

import java.util.Scanner;
/**
 * @athor LingjingQ
 * @date 2019/4/13 10:25
 */
public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getResult(input));
    }
    public static String getResult(String input){
        String res = "";
        int[] count = new int[26];
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            count[ch-'a']++;
        }
        int min = input.length();
        for(int i=0; i<26; i++){
            if(count[i]>0 && count[i]<min){
                min = count[i];
            }
        }
        for (int i=0; i<input.length(); i++){
            if(count[input.charAt(i)-'a']>min){
                res += input.charAt(i);
            }
        }
        return res;
    }
}