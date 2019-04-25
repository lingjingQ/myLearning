package threadLocal线程提高篇;

public class ThreadLocalDemo {
    public static void main(String[] args) {
         final ThreadLocal<String> tl = new ThreadLocal();
        tl.set("abc");// 在底层源码中，键就是当前线程对象，值就是“abc”

        new Thread(){
            @Override
            public void run(){
                // 此方法就相当于新线程的main方法，不再本main线程中运行,在Thread-0中运行
                String value = tl.get();  // 当前对象不是main线程对象，所以取不出来abc

                System.out.println(value);
            }
        }.start();


//        System.out.println(tl.get()); // 在底层源码中，就是去当前线程对象为键的值，所以不需要设置键
    }
}
