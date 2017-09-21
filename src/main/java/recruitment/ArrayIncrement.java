package recruitment;

import java.util.Arrays;

/**
 * @author Piotr_Sekula
 * @since 19.09.2017.
 */
class ArrayIncrement {

    int[] increment(int[] input) {
        boolean isTen = true;
        int index = input.length - 1;

        while (isTen) {
            int newNumber = input[index] + 1;
            if (newNumber == 10) {
                if (index != 0) {
                    input[index] = 0;
                    index--;
                } else {
                    input = buildNewArray(input);
                    isTen = false;
                }
            } else {
                input[index] = newNumber;
                isTen = false;
            }
        }
        return input;
    }

    private int[] buildNewArray(int[] input) {
        input = Arrays.copyOf(input, input.length + 1);
        input[0] = 1;
        for (int i = 1; i < input.length - 1; i++) {
            input[i] = 0;
        }
        return input;
    }
}
