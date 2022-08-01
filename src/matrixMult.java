import java.util.Arrays;
import java.util.Scanner;

public class matrixMult {

//    public static multiplyArrays(int sum , int[] arr1, int[] arr2)
//    {
//
//    }
    public static int[][] matrixMul(String[][] m1 , String[][] m2) throws Exception {
        if(m1[0].length != m2.length)
           throw new Exception();
        int[][] mOut = new int[m1.length][m2[0].length];
        for (int i=0;i<m1.length;i++)
        {

            for(int j=0;j<m2[0].length;j++)
            {
                int res=0;
               for(int k=0;k<m1[0].length;k++)
               {
                   res+= Integer.parseInt(m1[i][k])*Integer.parseInt(m2[k][j]);
               }
               mOut[i][j]=res;
            }
        }
        return mOut;
    }

    public static String[][] Transpose(String[][] m) {
        String[][] transpose = new String[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                transpose[j][i] = m[i][j];
            }

        }
        return transpose;
    }


    public static int[][] matrixMulEfficient(String[][] m1 , String[][] m) throws Exception {
        if(m1[0].length != m.length)
            throw new Exception("incompatible sizes");
        int[][] mOut = new int[m1.length][m[0].length];
        String[][] m2 = Transpose(m);
        for (int i=0;i<m1.length;i++)
        {

            for(int j=0;j<m2.length;j++)
            {
                int res=0;
                mulThread t = new mulThread(m1[i], m2[j]);
               // t.start();
                res= (int) t.call();
                System.out.println("Hello, res "+ res);
                mOut[i][j]=res;
            }
        }
        return mOut;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NUmber of rows of matrix 1");
        int x1 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter NUmber of cols of matrix 1");
        int y1 = Integer.parseInt(sc.nextLine());
        String[][] s1 = new String[x1][y1];
        System.out.println("x1 "+x1);
        for (int i=0;i<x1;i++)
        {
            System.out.println("Enter rows of matrix 1");
            String text = sc.nextLine();
            s1[i] = text.split(" ");
            System.out.println(text);
        }
        System.out.println("Enter NUmber of rows of matrix 2");
        int x2 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter NUmber of cols of matrix 2");
        int y2 = Integer.parseInt(sc.nextLine());
        String[][] s2 = new String[x2][y2];
        System.out.println("x2 "+x2);

        for (int i=0;i<x2;i++)
        {
            System.out.println("Enter rows of matrix 2");
            s2[i] = sc.nextLine().split(" ");
        }

//        int[][]m1 = new int[][]{{1, 2}, {3,4}};
//       int[][] m2= new int[][]{{2,1}, {3,1}};
       int[][] m3 = matrixMulEfficient(s1,s2);
       for (int i =0;i<m3.length;i++)
       {
           System.out.println(Arrays.toString(m3[i]));
       }

    }
}
