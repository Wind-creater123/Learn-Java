package oop_super;

public class outer_class {
    public static String schoolName="123";

    public static void test(){
        System.out.println("test");
    }

    public class Inner{
        private String name;
        public static String schoolName="123";

        public Inner(String name){
            this.name=name;
        }

        public Inner(){
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }

        public void show(){
            System.out.println(name);
            System.out.println(schoolName);
            test();
        }
    }

    public static void main(String[] args) {
        outer_class.Inner o=new outer_class().new Inner();
    }
}
