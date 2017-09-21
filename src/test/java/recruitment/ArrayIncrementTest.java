package recruitment;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * @author Piotr_Sekula
 * @since 19.09.2017.
 */
public class ArrayIncrementTest {

    @Test
    public void shouldIncrementSimpleNumber() {
        // Given
        ArrayIncrement arrayIncrement = new ArrayIncrement();
        int[] testArray = new int[] {4,2,4};
        int[] expectedArray = new int[] {4,2,5};

        // When
        int[] result = arrayIncrement.increment(testArray);

        // Then
        assertEquals(result[0], expectedArray[0]);
        assertEquals(result[1], expectedArray[1]);
        assertEquals(result[2], expectedArray[2]);
    }

    @Test
    public void shouldIncrementWithNineAtEnd() {
        // Given
        ArrayIncrement arrayIncrement = new ArrayIncrement();
        int[] testArray = new int[] {4,2,9};
        int[] expectedArray = new int[] {4,3,0};

        // When
        int[] result = arrayIncrement.increment(testArray);

        // Then
        assertEquals(result[0], expectedArray[0]);
        assertEquals(result[1], expectedArray[1]);
        assertEquals(result[2], expectedArray[2]);
    }

    @Test
    public void shouldIncrementWithTwoNinesAtEnd() {
        // Given
        ArrayIncrement arrayIncrement = new ArrayIncrement();
        int[] testArray = new int[] {4,2,9,9};
        int[] expectedArray = new int[] {4,3,0,0};

        // When
        int[] result = arrayIncrement.increment(testArray);
        System.out.println("Result: " + result[0] + result[1] + result[2] + result[3]);
        // Then
        assertEquals(result[0], expectedArray[0]);
        assertEquals(result[1], expectedArray[1]);
        assertEquals(result[2], expectedArray[2]);
        assertEquals(result[3], expectedArray[3]);
    }

    @Test
    public void shouldAllNinesExceptFirstNumber() {
        // Given
        ArrayIncrement arrayIncrement = new ArrayIncrement();
        int[] testArray = new int[] {4,9,9,9};
        int[] expectedArray = new int[] {5,0,0,0};

        // When
        int[] result = arrayIncrement.increment(testArray);
        System.out.println("Result: " + result[0] + result[1] + result[2] + result[3]);
        // Then
        assertEquals(result[0], expectedArray[0]);
        assertEquals(result[1], expectedArray[1]);
        assertEquals(result[2], expectedArray[2]);
        assertEquals(result[3], expectedArray[3]);
    }

    @Test
    public void shouldIncrementAllNinesExceptFirstNumber() {
        // Given
        ArrayIncrement arrayIncrement = new ArrayIncrement();
        int[] testArray = new int[] {9,9,9};
        int[] expectedArray = new int[] {1,0,0,0};

        // When
        int[] result = arrayIncrement.increment(testArray);
        System.out.println("Result: " + result[0] + result[1] + result[2] + result[3]);
        // Then
        assertEquals(result[0], expectedArray[0]);
        assertEquals(result[1], expectedArray[1]);
        assertEquals(result[2], expectedArray[2]);
        assertEquals(result[3], expectedArray[3]);
    }
}