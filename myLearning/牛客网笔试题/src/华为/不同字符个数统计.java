package 华为;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @date 2019/3/30 22:31
 * 可以使用集合工具类
 * 也可以使用计数排序思想
 */
public class 不同字符个数统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int res = getResult(input);
        System.out.println(res);
    }
    public static int getResult(String input){

        TreeSet<Character> ts = new TreeSet<Character>();
        for(int i= 0; i<input.length(); i++){
            ts.add(input.charAt(i));
        }
        return ts.size();
    }
}
