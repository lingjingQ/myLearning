import java.io.*;

/**
 * @athor LingjingQ
 * @date 2019/4/17 9:38
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File fileP = new File("D:\\2\\");
        if(!fileP.exists()){
            fileP.mkdirs();
        }
        File file = new File("D:\\2\\number.txt");
//
        String content = myread(file);
        System.out.println(content);
            System.out.println("修改：");
        content = increase(content);
            System.out.println(content);
        write(file,content);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.flush();
        fileWriter.close();
    }

    private static String increase(String content) {
        int num = Integer.parseInt(content.trim());
        num++;
        return  String.valueOf(num);
    }

    private static String myread(File file) throws IOException{
        FileInputStream fileInputStream = new FileInputStream("D:\\2\\number.txt");
        byte[] seqByte = new byte[1024];
        fileInputStream.read(seqByte);
        String seq = new String(seqByte);
        fileInputStream.close();
        return seq;
    }
    private static void write(File file, String content)throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }
}
