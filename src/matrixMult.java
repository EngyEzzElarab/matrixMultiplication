import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class matrixMult {

    //    public static multiplyArrays(int sum , int[] arr1, int[] arr2)
//    {
//
//    }
    public static int[][] matrixMul(String[][] m1, String[][] m2) throws Exception {
        if (m1[0].length != m2.length)
            throw new Exception();
        int[][] mOut = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m2[0].length; j++) {
                int res = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    res += Integer.parseInt(m1[i][k]) * Integer.parseInt(m2[k][j]);
                }
                mOut[i][j] = res;
            }
        }
        return mOut;
    }

    public static int[][] Transpose(int[][] m) {
        int[][] transpose = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                transpose[j][i] = m[i][j];
            }

        }
        return transpose;
    }


    public static int[][] matrixMulEfficient(int[][] m1, int[][] m) throws Exception {
        Vector<Thread> threads = new Vector<Thread>();
        if (m1[0].length != m.length)
            throw new Exception("incompatible sizes");
        int[][] mOut = new int[m1.length][m[0].length];
        int[][] m2 = Transpose(m);
        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m2.length; j++) {
                System.out.println("i= " + i + " j= " + j);
                mulThread t = new mulThread(m1[i], m2[j], mOut, i, j);
                t.start();
                threads.add(t);
            }

        }
        System.out.println(threads.size());
        for (Thread t : threads) {
            System.out.println("Thread's " + t.getId() + " state" + t.getState());
            if (t.isAlive() == true || t.getState().equals(Thread.State.RUNNABLE)) {
                t.join();

            }


        }
        return mOut;
    }

    public static int[][] matrixMulEfficientTenThreads(int[][] m1, int[][] m) throws Exception {

        if (m1[0].length != m.length)
            throw new Exception("incompatible sizes");
        int[][] mOut = new int[m1.length][m[0].length];
        int[][] m2 = Transpose(m);
        int taskNum =  0;
        int totalNumberOfTasks = m1.length * m[0].length;

        mulThreadFixedTen[] threads = new mulThreadFixedTen[10];
        for(int i=0;i<10;i++)
            threads[i] = new mulThreadFixedTen(mOut,m1,m2);

        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m2.length; j++) {
                  //  Task task = new Task(taskNum);
                    int threadIndex = taskNum%10;
                    mulThreadFixedTen t = threads[threadIndex];
                    //System.out.println(t.positions.isEmpty());
                    Vector v = new Vector<Integer>();
                    v.add(i);
                    v.add(j);
                    t.positions.add(v);
                    //System.out.println(t.positions.isEmpty());
                    //System.out.println(t.positions.get(0));
                    taskNum++;

            }

        }

        for(int i=0;i<10;i++)
        {
            mulThreadFixedTen t = threads[i];
            t.start();
        }
        for (Thread t : threads) {
            //System.out.println("Thread's " + t.getId() + " state" + t.getState());
            if (t.isAlive() == true || t.getState().equals(Thread.State.RUNNABLE)) {
                t.join();

            }


        }
        return mOut;
    }

    public static int[][] matrixMulEfficientUsingFixedThreads(int[][] m1, int[][] m) throws Exception {

        if (m1[0].length != m.length)
            throw new Exception("incompatible sizes");
        int[][] mOut = new int[m1.length][m[0].length];
        int[][] m2 = Transpose(m);
        int totalNumberOfTasks = m1.length * m[0].length;
        CountDownLatch latch = new CountDownLatch(totalNumberOfTasks);
        int numOfCore = Runtime.getRuntime().availableProcessors();
        System.out.println("CORES " + numOfCore);
        ExecutorService service = Executors.newFixedThreadPool(numOfCore);
        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m2.length; j++) {
                service.execute(new mulThreadForPool(m1[i], m2[j], mOut, i, j, latch));
                System.out.println("Latch " + latch);
            }

        }

        latch.await();
        service.shutdown();


        return mOut;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NUmber of rows of matrix 1");
        int x1 = sc.nextInt();
        System.out.println("Enter NUmber of cols of matrix 1");
        int y1 = sc.nextInt();
        int[][] s1 = new int[x1][y1];
        System.out.println("x1 " + x1);
        System.out.println("y1 " + y1);
        for (int i = 0; i < x1; i++) {
            System.out.println("Enter rows of matrix 1");
            for (int j = 0; j < y1; j++) {
                s1[i][j] = sc.nextInt();
                System.out.println(s1[i][j]);
            }

        }

        System.out.println("Enter NUmber of rows of matrix 2");
        int x2 = sc.nextInt();
        System.out.println("Enter NUmber of cols of matrix 2");
        int y2 = sc.nextInt();
        int[][] s2 = new int[x2][y2];
        System.out.println("x2 " + x2);

        for (int i = 0; i < x2; i++) {
            System.out.println("Enter rows of matrix 2");
            for (int j = 0; j < y2; j++) {
                s2[i][j] = sc.nextInt();
            }

        }
        int[][] m3 = matrixMulEfficientTenThreads(s1, s2);
        for (int i = 0; i < m3.length; i++) {
            System.out.println(Arrays.toString(m3[i]));
        }

    }
}
