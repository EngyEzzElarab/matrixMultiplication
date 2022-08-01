import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class matrixMultTest {

    @org.junit.jupiter.api.Test
    void matrixMul1() {
        int[][] m1 = new int[][]{new int[]
                        {0, 0},
                new int[]
                        {0, 0}};
        int[][]  m2= (new int[][]{new int[]{1000, 50,800}, new int[]{577, 199,455}});
        int[][] expected = {{0,0,0},{0,0,0}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void matrixMul2() {
        int[][] m1 = new int[][]{new int[]
                {1, 2},
                new int[]
                        {3, 4}};
        int[][]  m2= (new int[][]{new int[]{1, 1}, new int[]{1,1}});
        int[][] expected = {{3,3},{7,7}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void matrixMul3() {
        int[][] m1 = new int[][]{new int[]
                {1, 2,3},
                new int[]
                        {4, 5,6}};
        int[][]  m2= (new int[][]{new int[]{1, 2}, new int[]{3,4}, new int[]{2,4}});
        int[][] expected = {{13,22},{31,52}};
        var mult = new matrixMult();
        int[][] actual = mult.matrixMul(m1,m2);
        Assertions.assertArrayEquals(expected, actual);
    }
}