package com.ustc.domain;

/**
 * @date 2019/3/31 9:46
 */
public class Product {
    private  int pid;  // 名字必须和数据库中的字段名一样，因为后面查询的时候用的是QerryRunner，它是直接创建一个类，将记录封装到对象中去
    private String name;
    private int price;
    private String flag;

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(int pid, String name, int price, String flag, String category_id) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.flag = flag;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", flag='" + flag + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }



    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    private String category_id;

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getFlag() {
        return flag;
    }

    public String getCategory_id() {
        return category_id;
    }
}
