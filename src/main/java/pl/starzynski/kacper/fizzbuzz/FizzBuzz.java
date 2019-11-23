package pl.starzynski.kacper.fizzbuzz;

class FizzBuzz {

    static final String FIZZ = "Fizz";
    static final String BUZZ = "Buzz";
    static final String FIZZBUZZ = "FizzBuzz";

    private static final int MINIMAL_MATRIX_SIZE = 1;
    private static final int MAX_MATRIX_SIZE = 10000;

    private Object[] fizzBuzzMatrix;
    private int fizzBuzzNumericValue = 0;

    Object[] getFizzBuzzMatrix(int matrixSize) {
        validateMaxSize(matrixSize);
        fizzBuzzMatrix = new Object[matrixSize];
        generateFizzBuzz();
        return fizzBuzzMatrix;
    }

    private void validateMaxSize(int matrixSize) {
        if (matrixSize < MINIMAL_MATRIX_SIZE || matrixSize > MAX_MATRIX_SIZE)
            throw new InvalidMatrixSizeException();
    }

    private void generateFizzBuzz() {
        for (int i = 0; i < fizzBuzzMatrix.length; i++) {
            //Could be strategy but meh
            setNumericValue(i);

            if (dividesByFive(fizzBuzzNumericValue) && dividesByThree(fizzBuzzNumericValue))
                fizzBuzzMatrix[i] = FIZZBUZZ;
            else if (dividesByFive(fizzBuzzNumericValue))
                fizzBuzzMatrix[i] = BUZZ;
            else if (dividesByThree(fizzBuzzNumericValue))
                fizzBuzzMatrix[i] = FIZZ;

        }
    }

    private boolean dividesByThree(int fizzBuzzNumericValue) {
        return fizzBuzzNumericValue % 3 == 0;
    }

    private boolean dividesByFive(int fizzBuzzNumericValue) {
        return fizzBuzzNumericValue % 5 == 0;
    }

    private void setNumericValue(int i) {
        fizzBuzzNumericValue = i + 1;
        fizzBuzzMatrix[i] = fizzBuzzNumericValue;
    }

    class InvalidMatrixSizeException extends RuntimeException {

    }
}
