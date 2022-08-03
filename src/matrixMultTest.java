import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class matrixMultTest {

    @org.junit.jupiter.api.Test
    void matrixMul1() throws Exception {
        String[][] m1 = new String[][]{new String[]
                        {"0", "0"},
                new String[]
                        {"0", "0"}};
        String[][]  m2= (new String[][]{new String[]{"1000", "50","800"}, new String[]{"577", "199","455"}});
        int[][] expected = {{0,0,0},{0,0,0}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void matrixMul2() throws Exception {
        String[][] m1 = new String[][]{new String[]
                {"1", "2"},
                new String[]
                        {"3", "4"}};
        String[][]  m2= (new String[][]{new String[]{"1", "1"}, new String[]{"1","1"}});
        int[][] expected = {{3,3},{7,7}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void matrixMul3() throws Exception {
        String[][] m1 = new String[][]{new String[]
                {"1", "2","3"},
                new String[]
                        {"4", "5","6"}};
        String[][]  m2= (new String[][]{new String[]{"1", "2"}, new String[]{"3","4"}, new String[]{"2","4"}});
        int[][] expected = {{13,22},{31,52}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void incompatibleRowsAndColumnsSizeTest() throws Exception {
        String[][] m1 = new String[][]{new String[]
                {"1", "2","3"},
                new String[]
                        {"4", "5","6"}};
        String[][]  m2= (new String[][]{new String[]{"1", "2"}, new String[]{"3","4"}});
        var mult = new matrixMult();
        assertThrows(Exception.class, () -> {
            mult.matrixMul(m1,m2);
        });

    }




    @org.junit.jupiter.api.Test
    void multiplyingByZerosEfficiently() throws Exception {
        int[][] m1 = new int[][]{{0,0},{0,0}};
        int[][]  m2= (new int[][]{{1000, 50,800},{577, 199,455}});
        int[][] expected = {{0,0,0},{0,0,0}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMulEfficient(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void multiplyingByOnesEfficiently() throws Exception {
        int[][] m1 = new int[][]{{1,2},{3,4}};
        int[][]  m2= (new int[][]{{1,1}, {1,1}});
        int[][] expected = {{3,3},{7,7}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMulEfficient(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void hundredByHundred() throws Exception {
        int[][] m1 = new int[100][100];
        int[][] m2 = new int[100][100];
        for (int i=0;i<100;i++)
        {
            for (int j=0;j<100;j++)
            {
                m1[i][j]=6;
            }
        }

        for (int i=0;i<100;i++)
        {
            for (int j=0;j<100;j++)
            {
                if(j==i)
                    m2[i][j]=1;
                else
                    m2[i][j]=0;
            }
        }

        int[][] expected = m1;
        var mult = new matrixMult();
        int[][] actual = mult.matrixMulEfficient(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void incompatibleRowsAndColumnsSizeEfficientTest() throws Exception {
        int[][] m1 = new int[][]{
                {1,2,3}, {4,5,6}};

        int[][]  m2= (new int[][]{{1,2}, {3,4}});
        var mult = new matrixMult();
        assertThrows(Exception.class, () -> {
            mult.matrixMulEfficient(m1,m2);
        });

    }
}