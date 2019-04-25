package 华为;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/4 16:41
 */
public class 简单错误记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String messageLine = null;
        Map<String,Integer> map = new LinkedHashMap<String, Integer>();
        while(sc.hasNext()){
            messageLine = sc.nextLine();
            String[] error_message = messageLine.split(" ");
            String error = error_message[0];
            String line_no = error_message[1];
            String fileName = error.substring(error.lastIndexOf("\\")+1);
            if(fileName.length()>16){
                fileName = fileName.substring(fileName.length()-16);
            }
            String errorName = fileName + " " + line_no;
            if(map.containsKey(errorName)){
                map.put(errorName,map.get(errorName)+1);
            }else{
                map.put(errorName,1);
            }
        }
        int count = 0;
        for(String key:map.keySet()){
            count++;
            if(count>map.size()-8){
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
