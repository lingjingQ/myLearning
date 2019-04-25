package com.ustc.view;

import com.ustc.service.AccountService;

public class AccountView {
    public static void main(String[] args) {
        //模拟用户转账
        // 输入付款人姓名，收款人姓名
        String fromName = "Jack";
        String toName = "Tom";
        double money = 1000;
        AccountService accountService = new AccountService();//怎么从视图层传到业务层？new一个对象，调用他的方法
        accountService.transfer(fromName,toName,money);
    }
}
