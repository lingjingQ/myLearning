package 华为;

import java.util.Scanner;

public class 质数因子 {
    /**
     * 输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
     *
     * 最后一个数后面也要有空格
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long uDataInput = sc.nextInt();
            String res = getResult(uDataInput);
            System.out.println(res);
        }
    }
    public static String getResult(long uDataInput){
        int i = 2;
        String res = "";
        while(uDataInput>=i){
            if(uDataInput%i == 0){
                res = res + i + " ";
                uDataInput = uDataInput/i;
            }else {
                i++;
            }
        }
        return res;
    }
}
