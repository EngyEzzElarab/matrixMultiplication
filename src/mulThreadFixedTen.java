import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class mulThreadFixedTen extends Thread {

    private int[][] matrixOut;
    private int[][] matrix1;
    private int[][] matrix2;
    public Vector<Vector<Integer>> positions = new Vector<Vector<Integer>>();
//    private int x;
//    private int y;
//    private int[] row;
//    private int[] col;
    public mulThreadFixedTen(int[][] mOUt, int[][] m1 , int[][] m2) {
            matrixOut = mOUt;
            matrix1 = m1;
            matrix2 = m2;
//            this.positions = positions;
    }




    @Override
    public void run() {

        while (!positions.isEmpty())
        {
            Vector<Integer> position = positions.remove(0);
            int x = position.get(0);
            int y = position.get(1);
            int sum = 0;
            int[] row = matrix1[x];
            int[] col = matrix2[y];



            for (int i = 0; i < row.length; i++) {

                // this.res+= row[i]*col[i];
                sum += row[i] * col[i];
            }
            matrixOut[x][y] = sum;
            //System.out.println("Hello, I am thread " + getId() + "responsible for row "+x+" and column "+y+" Result is " + sum);
        }

    }


}
