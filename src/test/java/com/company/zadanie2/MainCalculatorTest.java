package com.company.zadanie2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainCalculatorTest {


    @Test
    void calculate_noNumbers_shouldReturnZero() {

        //given
        String stringNumbers = "" + MainCalculator.possibleSeparators + "*";

        //when
        double result = MainCalculator.calculate(stringNumbers);

        //then
        assertEquals(0.0, result);
    }

    @Test
    void calculate_shouldReturnRightResultOfAdding() {

        //given
        String stringNumbers = "40;60" + MainCalculator.possibleSeparators + "+";

        //when
        double result = MainCalculator.calculate(stringNumbers);

        //then
        assertEquals(100.0, result);
    }

    @Test
    void calculate_shouldReturnRightResultOfSubtracting() {

        //given
        String stringNumbers = "0;100" + MainCalculator.possibleSeparators + "-";

        //when
        double result = MainCalculator.calculate(stringNumbers);

        //then
        assertEquals(-100.0, result);
    }

    @Test
    void calculate_shouldReturnRightResultOfDividing() {

        //given
        String stringNumbers = "200;2" + MainCalculator.possibleSeparators + "/";

        //when
        double result = MainCalculator.calculate(stringNumbers);

        //then
        assertEquals(100.0, result);
    }

    @Test
    void calculate_zeroAfterFirstNumberInDividing_shouldThrowArithmeticException() {

        //given
        String stringNumbers = "200;10,0" + MainCalculator.possibleSeparators + "/";

        //when + then
        assertThrows(ArithmeticException.class, () -> MainCalculator.calculate(stringNumbers));
    }

    @Test
    void calculate_shouldReturnRightResultOfMultiplying() {

        //given
        String stringNumbers = "50;2" + MainCalculator.possibleSeparators + "*";

        //when
        double result = MainCalculator.calculate(stringNumbers);

        //then
        assertEquals(100.0, result);
    }

    @Test
    void calculate_noMathSymbolAtTheEnd_shouldThrowIllegalArgumentException() {

        //given
        String stringNumbers = "50;2" + MainCalculator.possibleSeparators;

        //when + then
        assertThrows(IllegalArgumentException.class, () -> MainCalculator.calculate(stringNumbers));
    }

}
