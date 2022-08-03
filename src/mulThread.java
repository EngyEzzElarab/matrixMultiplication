import java.util.concurrent.Callable;

public class mulThread extends Thread {

    private  int[] col;
    private  int[] row;
    private static int res = 0;
    private  int x;
    private  int y;
    public int[][] tempMatrix;

    public mulThread(int[] m1Row, int[] m2Col, int[][] mOut, int x, int y) {
        this.res = 0;
        this.row = m1Row;
        this.col = m2Col;
        tempMatrix = mOut;
        this.x = x;
        this.y = y;

    }

    @Override
    public void run() {
        //
        int sum = 0;
        for (int i = 0; i < this.row.length; i++) {

            // this.res+= row[i]*col[i];
            sum += row[i] * col[i];
            tempMatrix[x][y] = sum;

        }
        System.out.println("Hello, I am thread " + getId() + "responsible for row "+x+" and column "+y+" Result is " + sum);

    }
}
