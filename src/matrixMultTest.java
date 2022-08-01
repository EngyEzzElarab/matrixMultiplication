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
}