package 华为;

/**
 * @athor LingjingQ
 * @date 2019/3/31 13:21
 *      11位0-9的数字
 *      第一位必须是1
 *      第二位必须是3,4，5,7,8中的一个
 *      后面9位为0-9之间的任何一个数字。
 */
public class 正则表达式之校验手机号码 {
    public static void main(String[] args) {
        String phone = "16130124320";
        boolean b = phone.matches("1[34578][0-9]{9}");
        System.out.println(b);
    }
}
