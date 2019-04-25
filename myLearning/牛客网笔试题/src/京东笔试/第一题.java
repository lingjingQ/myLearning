package 京东笔试;

import java.util.Scanner;

/**
 * @athor LingjingQ
 * @date 2019/4/13 20:17
 * 6
 * 1 2
 * 1 6
 * 2 5
 * 2 3
 * 3 4
 * 2
 */
public class 第一题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] points = new int[n-1][2];
            for(int i=0; i<n-1; i++){
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }
            System.out.println(getMinTime(points));
        }
    }

    private static int getMinTime(int[][] points) {
        //有points构建出一颗树，根节点是1号节点
        // 统计跟节点的最大子树的节点数，就是所求的最小时间。

        // 1 统计1号节点的直系孩子
        int[][] childs = new int[points.length][points.length];
        int k = 0;
        for(int i=0; i<points.length; i++){  //第一遍先统计直系孩子
            if(points[i][0]==1){
                childs[k++][0] = points[i][1];
            }else if(points[i][1] == 1){
                childs[k++][0] = points[i][0];
            }
        }

        // 2 分别统计每个直系孩子的相联系的节点个数
        int[] count = new int[k];
        for(int i=0; i<k; i++){
            count[i]++;             // 算上自身，初始值为1
        }

        for(int i=0; i<k; i++){//遍历直系孩子，每一个childs[i]
            int link = 0;
            for(int other = 0; childs[i][other]!=0; other++){
                for(int j=0; j<points.length; j++){
                    if(points[j][0] == childs[i][other] && points[j][1]!=1){//遇到直系孩子的相关节点，且该节点不是1号节点，就将该节点也放入child数组中
                        count[i]++;
                        childs[i][++link] = points[j][1];
                    }else if(points[j][1] == childs[i][other] && points[j][0]!=1){
                        count[i]++;
                        childs[i][++link] = points[j][0];
                    }
                }
            }
        }

        // 3 取最大的那个，就是结果
        int max = 0;
        for(int i=0; i<k; i++){
            max = Math.max(max,count[i]);
        }
        return max;
    }
}
