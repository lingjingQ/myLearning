package 华为;

/**
 * @athor LingjingQ
 * @date 2019/3/31 13:15
 *      校验QQ号合法性：
 *          1. 必须是0-9的数字
 *          2. 开头必须是1-9
 *          3. 位数必须是5-12位
 *       书写正则表达式的技巧：
 *       · 一位一位的写
 *        2. 中括号表示范围
 *        3. 大括号表示个数
 */
public class 正则表达式 {
    public static void main(String[] args) {
        String qq = "65s3213";
        System.out.println(qq.matches("[1-9][0-9]{4,11}"));
    }
}
