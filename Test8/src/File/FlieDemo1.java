package File;

import java.io.File;
import java.io.IOException;

public class FlieDemo1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\21230\\IdeaProjects\\project\\Test8\\src\\File\\FileDemo1.txt");
        System.out.println(f1.length());

        System.out.println(f1.getName());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());

        File f2 = new File("src/File/FileDemo2.txt");
        System.out.println(f2.exists());
        System.out.println(f2.createNewFile());

        File f3 = new File("src/File/FileDemo3");
        System.out.println(f3.mkdir());//一级
        System.out.println(f3.mkdirs());//多级

        File f4=new File("src/File/FileDemo1.txt");
        System.out.println(f4.delete());
        System.out.println(f4.delete());//删空文件夹

        //遍历获取一级文件名
        File f5=new File("src/File/FileDemo2.txt");
        String[] names=f5.list();
        if (names != null) {
            for(String name:names){
                System.out.println(name);
            }
        }

        File[] files=f5.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }
}
