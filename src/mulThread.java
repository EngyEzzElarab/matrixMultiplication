import java.util.concurrent.Callable;

public class mulThread implements Callable {

    private static String[] col;
    private static String[] row;
    //private static int res = 0;

    public mulThread(String[] m1Row , String[] m2Col)
    {
      this.row = m1Row;
      this.col = m2Col;
    }
//    @Override
//    public void run() {
//
//        for(int i=0;i< this.row.length;i++)
//        {
//                this.res+= Integer.parseInt(row[i])*Integer.parseInt(col[i]);
//                // System.out.println("Hello, thread is running");
//        }
//    }

//    public int getValue() {
//        return this.res;
//    }

    @Override
    public Object call() throws Exception {
        int res=0;
        for(int i=0;i< this.row.length;i++)
        {
            res+= Integer.parseInt(row[i])*Integer.parseInt(col[i]);
             System.out.println("Hello, thread is running");
        }
        return res;
    }
}
