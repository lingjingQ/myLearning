package 华为;
/**
 * TreeSet 有序集合，不重复，有序
 */

import javax.management.InstanceNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Mingming {
    public static void main(String[] args) {
        // 输入相应的数字，然后对这些树排序并输出
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeSet<Integer> tree = new TreeSet<Integer>();
        if(N>0){
            for(int i=0 ; i<N; i++){
                tree.add(sc.nextInt());
            }
        }
        for(Integer i : tree){
            System.out.println(i);
        }
    }
}
