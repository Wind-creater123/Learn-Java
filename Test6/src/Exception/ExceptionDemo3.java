package Exception;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        try {
            saveAge(30);
        } catch (AgeIlegalException e) {
            throw new AgeIlegalException("error");
        }
    }

    public static void saveAge(int age)throws  AgeIlegalException {
        if(age<1||age>200){
            throw new AgeIlegalException("age cannot <1 or >200");
        }else{
            System.out.println("ok");
            System.out.println("save:"+age);
        }
    }
}
