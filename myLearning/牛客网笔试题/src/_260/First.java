package _260;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/3 19:43
 */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] a = new int[n][4];
            for(int j=0; j<n; j++){
                for(int i=0; i<4; i++){
                    a[j][i] = Integer.parseInt(sc.next());
                }
            }
            int [] res = getResult(a);
            for(int i=0; i<res.length; i++){
                System.out.println(res[i]);
            }
        }
    }

    private static int[] getResult(int[][] a) {
        int[] res = new int[a.length];
        for(int i=0; i<a.length; i++){ //对每一行做判断，输出一个结果存储到res中
            /**
             * 4人队伍肯定直接加到最后结果中去
             * 3人队伍需要1人队伍
             * 2人队伍需要2个1人队伍或者一个2人队伍
             * 由于要尽可能生成多的队伍，贪心算法：
             *      对于2人队伍，优先内部消化，
             */
            res[i] = get(a[i]);
        }
        return res;
    }

    private static int get(int[] ints) {
        int count = ints[3]; //4人队
        count += ints[1]/2;//加上2人队内部生成的
        int k2 = ints[1]%2;//剩余的2人队，要么是0，要么是1
        int k1 = ints[0]; //1人队
        int k3 = ints[2];
        if(k1>0&&k3>0){
            int t3 = (k1>k3?k3:k1);
            count += t3;
            k1 -= t3;
        }

        if(k1>0&&k2>0){
            int t2 = (k1>k2?k2:k1);
            count += t2;
            k1 -= t2;
        }
        count += k1/4;
        return count;
    }
}
