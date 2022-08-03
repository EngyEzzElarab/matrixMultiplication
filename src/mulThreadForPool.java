import java.util.concurrent.CountDownLatch;

public class mulThreadForPool extends Thread {


    private int[] col;
    private int[] row;
    private int res = 0;
    private int x;
    private int y;
    public int[][] m;
    private CountDownLatch latch;

    public mulThreadForPool(int[] m1Row, int[] m2Col, int[][] mOut, int x, int y, CountDownLatch latch) {
        this.row = m1Row;
        this.col = m2Col;
        m = mOut;
        this.x = x;
        this.y = y;
        this.latch = latch;
    }

    @Override
    public void run() {

        int sum = 0;
        for (int i = 0; i < this.row.length; i++) {
            sum += row[i] * col[i];

        }
        m[x][y] = sum;
        System.out.println("Hello, thread " + getName() + " is running resulting in " + sum);
        this.latch.countDown();

    }
}
