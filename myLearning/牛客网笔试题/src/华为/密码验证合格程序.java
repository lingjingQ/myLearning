package 华为;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/4 16:52
 */
public class 密码验证合格程序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new LinkedHashMap<String,String>();
        while(sc.hasNextLine()){
            String inputLine = sc.nextLine();
            map.put(inputLine,judge(inputLine));
        }
        for(String key: map.keySet()){
            System.out.println(map.get(key));
        }
    }

    private static String judge(String inputLine) {
        boolean flag = true;
        if(inputLine.length()<=8){
            return "NG";
        }
        int [] category = new int[4];
        for(int i=0; i<inputLine.length(); i++){
            if(inputLine.charAt(i)>='a'&&inputLine.charAt(i)<='z'){
                if(category[0]==0){
                    category[0]++;
                }
            }else if(inputLine.charAt(i)>='A'&&inputLine.charAt(i)<='Z'){
                if(category[1] == 0){
                    category[1]++;
                }
            } else if(inputLine.charAt(i)>='0'&&inputLine.charAt(i)<='9'){
                if(category[2]==0){
                    category[2]++;
                }
            }else if(category[3]==0){
                category[3]++;
            }
        }
        int sum = 0;
        for(int i=0; i<4; i++){
            sum += category[i];
        }
        if(sum<3){
            return "NG";
        }
        for(int i=0; i<inputLine.length()-6; i++){
            String sub3 = inputLine.substring(i,i+3);
            if(inputLine.indexOf(sub3,i+3)>0){
                return "NG";
            }
        }
        return "OK";
    }
}
