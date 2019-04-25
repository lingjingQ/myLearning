package bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/3/31 14:39
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = ","+ str;
        String [] arr = str.split(",");
        List<Integer> res = new ArrayList<>();
        myfunc(arr,res,1);
        for(int i=1;i<res.size(); i++)
            if(res.get(i) < res.get(i-1)) {
                System.out.println("False");
                return;
            }
        System.out.println("True");
    }
    public static void myfunc(String [] arr,List<Integer> res,int i){
        if(i >= arr.length) return;
        if(!arr[i].equals("None")){
            myfunc(arr,res,2*i);
            res.add(Integer.valueOf(arr[i]));
            myfunc(arr,res,2*i+1);
        }
    }
}
