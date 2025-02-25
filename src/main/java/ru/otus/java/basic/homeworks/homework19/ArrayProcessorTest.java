package ru.otus.java.basic.homeworks.homework19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayProcessorTest {

    @Test
    public void testGetElementsAfterLastOne_Normal() {
        int[] input = {1, 2, 1, 2, 2};
        int[] expected = {2, 2};

        int[] result = ArrayProcessor.getElementsAfterLastOne(input);

        assertArrayEquals(expected, result, "Should return elements after the last 1");
    }

    @Test
    public void testGetElementsAfterLastOne_LastElement() {
        int[] input = {2, 2, 1};
        int[] expected = {};

        int[] result = ArrayProcessor.getElementsAfterLastOne(input);

        assertArrayEquals(expected, result, "Should return empty array when 1 is the last element");
    }

    @Test
    public void testGetElementsAfterLastOne_FirstElement() {
        int[] input = {1, 2, 2, 2};
        int[] expected = {2, 2, 2};

        int[] result = ArrayProcessor.getElementsAfterLastOne(input);

        assertArrayEquals(expected, result, "Should return all elements after 1 when it's the first element");
    }

    @Test
    public void testGetElementsAfterLastOne_NoOnes() {
        int[] input = {2, 2, 2, 2};
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ArrayProcessor.getElementsAfterLastOne(input);
        });

        assertEquals("Input array doesn't contain any 1's", exception.getMessage());
    }

    @Test
    public void testGetElementsAfterLastOne_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayProcessor.getElementsAfterLastOne(null);
        });
    }

    @Test
    public void testContainsOnlyOnesAndTwos_ValidCase() {
        int[] input = {1, 2};
        assertTrue(ArrayProcessor.containsOnlyOnesAndTwos(input), "Array with 1 and 2 should return true");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_OnlyOnes() {
        int[] input = {1, 1};
        assertFalse(ArrayProcessor.containsOnlyOnesAndTwos(input), "Array with only 1's should return false");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_OnlyTwos() {
        int[] input = {2, 2};
        assertFalse(ArrayProcessor.containsOnlyOnesAndTwos(input), "Array with only 2's should return false");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_OtherNumbers() {
        int[] input = {1, 3};
        assertFalse(ArrayProcessor.containsOnlyOnesAndTwos(input), "Array with numbers other than 1 and 2 should return false");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_LongerValidArray() {
        int[] input = {1, 2, 2, 1};
        assertTrue(ArrayProcessor.containsOnlyOnesAndTwos(input), "Array with multiple 1's and 2's should return true");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_EmptyArray() {
        int[] input = {};
        assertFalse(ArrayProcessor.containsOnlyOnesAndTwos(input), "Empty array should return false");
    }

    @Test
    public void testContainsOnlyOnesAndTwos_NullArray() {
        assertFalse(ArrayProcessor.containsOnlyOnesAndTwos(null), "Null array should return false");
    }
}