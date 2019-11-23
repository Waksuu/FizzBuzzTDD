package pl.starzynski.kacper.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    private static final List<Integer> NUMBERS_WHERE_SHOULD_BE_FIZZ = Arrays.asList(3, 6, 9, 12, 18, 21, 24, 27, 33);
    private static final List<Integer> NUMBERS_WHERE_SHOULD_BE_BUZZ = Arrays.asList(5, 10, 20, 25, 35, 40);
    private static final List<Integer> NUMBERS_WHERE_SHOULD_BE_FIZZ_BUZZ = Arrays.asList(15, 30, 45, 60);
    private static final int MATRIX_OFFSET = 1;

    private FizzBuzz fizzBuzz;

    @Before
    public void init() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void shouldSetInitialSizeToMatrixSize() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(10);

        //Assert
        assertEquals(10, matrix.length);
    }

    @Test
    public void shouldSetInitialSizeToMatrixSize_differentSizes() {
        //Arrange
        final int initialMatrixSize = 10;
        final int differentMatrixSize = 20;

        //Act
        var initialMatrix = fizzBuzz.getFizzBuzzMatrix(initialMatrixSize);
        var matrixWithDifferentSize = fizzBuzz.getFizzBuzzMatrix(differentMatrixSize);

        //Assert
        assertEquals(initialMatrixSize, initialMatrix.length);
        assertEquals(differentMatrixSize, matrixWithDifferentSize.length);
    }

    @Test(expected = FizzBuzz.InvalidMatrixSizeException.class)
    public void shouldThrowException_negativeMatrixSize() {
        //Act
        fizzBuzz.getFizzBuzzMatrix(-1);

        //Exception
    }

    @Test(expected = FizzBuzz.InvalidMatrixSizeException.class)
    public void shouldThrowException_zeroMatrixSize() {
        //Act
        fizzBuzz.getFizzBuzzMatrix(0);

        //Exception
    }

    @Test(expected = FizzBuzz.InvalidMatrixSizeException.class)
    public void shouldThrowException_tooLargeMatrixSize() {
        //Act
        fizzBuzz.getFizzBuzzMatrix(10001);

        //Exception
    }

    @Test()
    public void shouldNotThrowExceptionPerfectLimit_min() {
        //Act
        fizzBuzz.getFizzBuzzMatrix(1);
    }

    @Test()
    public void shouldNotThrowExceptionPerfectLimit_max() {
        //Act
        fizzBuzz.getFizzBuzzMatrix(10000);
    }

    @Test
    public void shouldReturnNumberFromOneToTwo() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(2);

        //Assert
        assertInts(matrix);
    }

    @Test
    public void shouldReturnFizzForNumbersThatDivideByThreeButNotFive() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(34);

        //Assert
        assertFizz(matrix);
    }

    @Test
    public void shouldReturnBuzzForNumbersThatDivideByFiveButNotThree() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(44);

        //Assert
        assertBuzz(matrix);
    }

    @Test
    public void shouldReturnFizzBuzzForNumbersThatDivideByFiveAndThree() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(66);

        //Assert
        assertFizzBuzz(matrix);
    }

    @Test
    public void shouldReturnHappyPathMatrix() {
        //Act
        var matrix = fizzBuzz.getFizzBuzzMatrix(66);

        //Assert
        assertInts(matrix);
        assertFizz(matrix);
        assertBuzz(matrix);
        assertFizzBuzz(matrix);
    }

    private void assertInts(Object[] matrix) {
        int expectedValue = 0;

        for (Object element : matrix) {
            expectedValue++;
            if (element.getClass() == int.class)
                assertEquals(expectedValue, matrix[(int) element]);
        }
    }

    private void assertFizz(Object[] matrix) {
        for (Integer threeDividers : NUMBERS_WHERE_SHOULD_BE_FIZZ) {
            assertEquals(FizzBuzz.FIZZ, matrix[threeDividers - MATRIX_OFFSET]);
        }
    }

    private void assertBuzz(Object[] matrix) {
        for (Integer fiveDividers : NUMBERS_WHERE_SHOULD_BE_BUZZ) {
            assertEquals(FizzBuzz.BUZZ, matrix[fiveDividers - MATRIX_OFFSET]);
        }
    }

    private void assertFizzBuzz(Object[] matrix) {
        for (Integer fiveAndThreeDividers : NUMBERS_WHERE_SHOULD_BE_FIZZ_BUZZ) {
            assertEquals(FizzBuzz.FIZZBUZZ, matrix[fiveAndThreeDividers - MATRIX_OFFSET]);
        }
    }

}
