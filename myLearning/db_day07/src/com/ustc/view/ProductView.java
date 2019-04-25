package com.ustc.view;

import com.ustc.domain.Product;
import com.ustc.service.ProductService;
import com.ustc.utils.C3p0Utils02;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @date 2019/3/31 9:06
 */
public class ProductView {
    public static void main(String[] args) throws SQLException {
        // 显示菜单
        System.out.println("欢迎来到商品管理系统，请输入以下命令进行操作");
        while (true){
            System.out.println("C:新增  U:修改  D:删除  DA：批量删除  FI：查询  FA：查询所有  Q:退出");
            // 获取用户键盘输入
            Scanner sc = new Scanner(System.in);
            String userSelect = sc.nextLine();
            // 判断用户输入的是哪一个命令
            switch (userSelect.toUpperCase()){
                case "C" :
                    // 新增方法
                    addProduct();
                    break;
                case "U" :
                    editProduct();
                    break;
                case "D" :
                    deleteProduct();
                    break;
                case "DA" :
                    deleteAllProducts();
                    break;
                case "FI" :
                    findById();
                    break;
                case "FA" :
                    findAll();
                    break;
                case "Q" :
                    System.out.println("欢迎您下次再来哦~~么么哒");
                    System.exit(0);
                    break;
                default:System.out.println("别瞎几把乱输入");
            }
        }

    }

    private static void findAll() {
        System.out.println("您选择了 查询所有商品 的功能");

        System.out.println("查询所有商品成功！");
    }

    private static void findById() {
        System.out.println("您选择了查找单个商品的功能");
        System.out.println("请输入您要查询的商品编号：");
        Scanner sc = new Scanner(System.in);
        int pid = Integer.parseInt(sc.nextLine());
        // 调用service的查询方法
        ProductService productService = new ProductService();
        Product product = productService.findById(pid);
        // 判断查询结果
        if(product == null){
            System.out.println("查询的商品不存在，请确认后输入..");

        }else{
            System.out.println("您查询的商品是："+product);
            System.out.println("查找单个商品成功！");
        }

    }

    private static void deleteAllProducts() {
        System.out.println("您选择了批量删除商品的功能");


        System.out.println("批量删除商品成功！");
    }

    private static void deleteProduct() {
        System.out.println("您选择了删除商品的功能");


        System.out.println("删除商品成功！");
    }

    private static void editProduct() {
        System.out.println("您选择了修改商品的功能");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的商品编号：");
        int pid = Integer.parseInt(sc.nextLine());
        // 查询数据库，告诉用户，选择的商品的具体信息，如果没有这条记录，也要提示用户：商品不存在


        System.out.println("修改商品成功！");
    }

    private static void addProduct() {
        System.out.println("您选择了新增商品的功能");
        Scanner sc = new Scanner(System.in);
        // 1. 请用户输入新的商品名
        System.out.println("请输入新的商品名：");
        String name = sc.nextLine();
        System.out.println("请输入新的商品价格：");
        int price = Integer.parseInt(sc.nextLine());
        // 为了传递参数方便，我们创建一个商品类
        // 封装成商品对象
        Product p = new Product(name,price);
        // 调用Service层的  添加商品方法
        ProductService service = new ProductService();
        service.addProduct(p); // view 层把数据拿到了给 service层，sevice层把数据给dao层

        System.out.println("添加商品成功！");
    }
}
