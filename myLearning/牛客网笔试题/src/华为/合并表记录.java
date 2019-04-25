package 华为;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * TreeMap 有序map，键不重复，键有序,
 *          增加键值对、修改值都是put
 */
public class 合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            TreeMap<Integer,Integer> tm = new TreeMap<Integer, Integer>();
            for(int i=0;i < n; i++){
                int k = sc.nextInt();
                int v = sc.nextInt();
                if(tm.containsKey(k)){
                    tm.put(k,tm.get(k)+v);
                }else {
                    tm.put(k,v);
                }
            }
            for(Integer key:tm.keySet()){
                System.out.println(key + " " + tm.get(key));
            }
        }
    }
}
