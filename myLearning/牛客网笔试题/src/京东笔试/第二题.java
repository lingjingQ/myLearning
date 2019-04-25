package 京东笔试;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/13 19:20
 */
public class 第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            String s = sc.nextLine();
            String[] inputSub = new String[m];
            for(int i=0; i<m; i++){
                inputSub[i] = sc.nextLine();
            }
            String inputT = sc.nextLine();
            System.out.println(getResult(inputSub,inputT));
        }
    }

    private static int getResult(String[] inputSub, String inputT) {
        //如果子串只有一个，那么我直接遍历一遍即可即可得出个数
        // 贪心算法，对于每一个子串，都在inputSub中寻找是否有匹配的，从短到长，一旦有匹配的，立刻匹配。
        int i = 0;
        int count = 0;
        while(i<inputT.length()){//i待匹配串表示起始地址
            int j=i+1;
            for(; j<=inputT.length(); j++){ //j表示当前串末位地址，不包含
                String sub = inputT.substring(i,j);
                if(isContain(inputSub,sub)){
                    count++;
                    break;
                }
            }
            i = j;
        }
        return count;
    }

    private static boolean isContain(String[] inputSub, String sub) {
        for(int i=0; i<inputSub.length; i++){
            if(sub.equals(inputSub[i])){
                return true;
            }
        }
        return false;
    }
}
