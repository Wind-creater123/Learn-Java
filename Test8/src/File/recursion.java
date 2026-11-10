package File;

import java.io.File;

public class recursion {
    public static void main(String[] args) {
        System.out.println(fun1(5));
        System.out.println(fun2(5));
        System.out.println(fun3(1));
        File dir=new File("D:/");
        searchFile(dir,"abc");
    }

    //找文件
    private static void searchFile(File dir, String fileName) {
        if(dir==null||!dir.exists()||dir.isFile()){
            return;
        }

        File[]  files=dir.listFiles();

        if(files!=null&&files.length>0){
            for(File file:files){
                if(file.isFile()){
                    if(file.getName().contains(fileName)){
                        System.out.println(file.getAbsolutePath());
                    }
                }else{
                    searchFile(file,fileName);
                }
            }
        }
    }

    public static int  fun1(int n){
        if(n==1){
            return 1;
        }

        return  fun1(n-1)*n;
    }

    public static int fun2(int n){
        if(n==1){
            return 1;
        }
        return fun2(n-1)+n;
    }

    public static int  fun3(int n){
        if(n==10){
            return 1;
        }else{
            return 2*fun3(n+1)+2;
        }
    }
}


