package ru.otus.java.basic.homeworks.homework19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayProcessorTest {

    @Test
    public void testProcessArray() {
        int[] input = {1, 2, 1, 2, 2};
        int[] expected = {2, 2};
        assertArrayEquals(expected, ArrayProcessor.processArray(input));
    }

    @Test
    public void testProcessArrayThrowsException() {
        int[] input = {2, 2, 2, 2};
        assertThrows(RuntimeException.class, () -> {
            ArrayProcessor.processArray(input);
        });
    }

    @Test
    public void testValidateArray() {
        assertTrue(ArrayProcessor.validateArray(new int[]{1, 2}));
        assertFalse(ArrayProcessor.validateArray(new int[]{1, 1}));
        assertFalse(ArrayProcessor.validateArray(new int[]{1, 3}));
        assertTrue(ArrayProcessor.validateArray(new int[]{1, 2, 2, 1}));
    }
}