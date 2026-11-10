package array;

public class two_di_array {
    public static void main(String[] args) {
        String[][] arr={
                {"1"},
                {"1","2"},
                {"1","2","3"},
                {"1","2","3","4"},
        };

        String[] names=arr[2];
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.println(arr[1][1]);
        System.out.println(arr[0][1]);

        System.out.println(arr.length);//4
        System.out.println(arr[0].length);//1

        int[][] arr2=new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            String[] arr1=arr[i];
            for (int j = 0; j < arr1.length; j++) {
                System.out.println(arr1[j]+"\t");
            }
            System.out.println();
        }
        //
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.println(arr2[i][j]+"\t");
            }
        }
    }
}
