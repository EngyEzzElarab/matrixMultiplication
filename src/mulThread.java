import java.util.concurrent.Callable;

public class mulThread extends Thread {

    private static int[] col;
    private static int[] row;
    private static int res = 0;
    private static int x;
    private static int y;
    public int[][] m;

    public mulThread(int[] m1Row , int[] m2Col, int[][] mOut , int x, int y)
    {
      this.row = m1Row;
      this.col = m2Col;
      m=mOut;
      this.x=x;
      this.y=y;
    }

    @Override
    public void run() {

        for(int i=0;i< this.row.length;i++)
        {
            this.res+= row[i]*col[i];
           // System.out.println("Hello, thread is running "+this.res);
        }
        m[x][y]= this.res;
        this.res = 0;

    }




//    @Override
//    public Object call() throws Exception {
//
//        return res;
//    }
}
