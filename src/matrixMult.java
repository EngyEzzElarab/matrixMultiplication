import java.util.Arrays;
import java.util.Scanner;

public class matrixMult {

    public static int[][] matrixMul(int[][] m1 , int[][] m2) throws Exception {
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
                   res+= m1[i][k]*m2[k][j];
               }
               mOut[i][j]=res;
            }
        }
        return mOut;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int[][]m1 = new int[][]{{1, 2}, {3,4}};
       int[][] m2= new int[][]{{2,1}, {3,1}};
       int[][] m3 = matrixMul(m1,m2);
       for (int i =0;i<m3.length;i++)
       {
           System.out.println(Arrays.toString(m3[i]));
       }

    }
}
