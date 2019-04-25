package 华为;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/3/31 12:53
 * 难点：
 *      将无效的字符丢弃------正则表达式-----匹配的才要，否则不要
 */
public class 坐标移动 {
    static class Position{
        int x;
        int y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.nextLine();
            Position position = new Position();
            handle(position,input);
            System.out.println(position.x + "," + position.y);
        }

    }

    private static void handle(Position position, String input) {
        String[] arr = input.split(";");
        for(int i=0; i<arr.length; i++){
            if(arr[i].isEmpty()){
                continue;
            }
            if((arr[i].charAt(0)=='A') && arr[i].substring(1).matches("[0-9]+")){ // 中括号表示范围
                position.x -= Integer.parseInt(arr[i].substring(1));
            }else if(arr[i].charAt(0)=='D' && arr[i].substring(1).matches("[0-9]+")){
                position.x += Integer.parseInt(arr[i].substring(1));
            }else if(arr[i].charAt(0)=='W' && arr[i].substring(1).matches("[0-9]+")){
                position.y += Integer.parseInt(arr[i].substring(1));
            } else if(arr[i].charAt(0)=='S' && arr[i].substring(1).matches("[0-9]+")){
                position.y -= Integer.parseInt(arr[i].substring(1));
            }
        }
    }
}
