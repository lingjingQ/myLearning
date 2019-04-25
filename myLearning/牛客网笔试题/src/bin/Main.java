package bin;

import java.util.Scanner;

/**
 * 输入：一行整数，逗号隔开
 * 输出：判断该数列是否符合二叉搜索树
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean res = isFull(input);
        if(res){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    public static boolean isFull(String input){
        if("none".equalsIgnoreCase(input) || input == null || input.isEmpty()){
            return true;
        }else{
            String[] nums = input.split(",");
            int[] ns = new int[nums.length];
            for( int i=0; i< nums.length; i++){
                ns[i] = Integer.parseInt(nums[i]);
            }//获得输入的数组
            boolean is = true;
            int j = ns.length-1;
            while(j>0){
                int parent = (j-1)/2;
                double p = (j-1)/2.0;
                if(p>parent){
                    //右孩子
                    if(ns[j] > ns[parent]){
                        j--;
                        continue;
                    }else {
                        is = false;
                        break;
                    }
                }else {
                    // 左孩子
                    if(ns[j] < ns[parent]){
                        j--;
                        continue;
                    }else {
                        is = false;
                        break;
                    }
                }
            }
            return is;
        }
    }
}
