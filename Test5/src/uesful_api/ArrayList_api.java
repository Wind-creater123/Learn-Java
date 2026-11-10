package uesful_api;

import java.util.ArrayList;

public class ArrayList_api {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();

        list.add("java");
        list.add("java2");
        list.add("java3");
        list.add("java");

        String l1=list.get(0);
        System.out.println(l1);
        String l2=list.get(1);
        System.out.println(l2);

        for(int i=0;i<list.size();i++){
            String str=list.get(i);
            System.out.println(str);
        }

        list.remove(1);
        list.remove("java");
        System.out.println(list);
    }
}
