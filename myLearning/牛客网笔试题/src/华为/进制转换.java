package 华为;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            s = s.substring(2);
            System.out.println(Integer.parseInt(s,16));
        }
    }
}
