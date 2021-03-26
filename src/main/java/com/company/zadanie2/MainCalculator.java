package com.company.zadanie2;

import java.util.StringTokenizer;


public class MainCalculator {

    public static final String possibleSeparators = ",.;";
    public static final String mathOperation = "+-*/";

    public static void main(String[] args) {

        System.out.println(calculate("5;3;0;/"));
    }

    public static double calculate(String stringNumbers) {

        String delimiters = possibleSeparators + mathOperation;
        StringTokenizer tokenizer = new StringTokenizer(stringNumbers, delimiters);

        double result = 0;
        if(!tokenizer.hasMoreTokens()){
            return result;
        }

        if(stringNumbers.charAt(stringNumbers.length()-1) == '*') {
            result = 1;
            while(tokenizer.hasMoreElements()){
                result *= Double.parseDouble(tokenizer.nextToken());
            }
        } else if(stringNumbers.charAt(stringNumbers.length()-1) == '/') {
            if(tokenizer.hasMoreElements()) {
                result = Double.parseDouble(tokenizer.nextToken());
            }
            while(tokenizer.hasMoreElements()) {
                result /= Double.parseDouble(tokenizer.nextToken());
                if(result == Double.POSITIVE_INFINITY) {
                    throw new ArithmeticException("Dividing by 0");
                }
            }
        } else if (stringNumbers.charAt(stringNumbers.length()-1) == '-') {
            while(tokenizer.hasMoreElements()){
                result -= Double.parseDouble(tokenizer.nextToken());
            }
        } else if (stringNumbers.charAt(stringNumbers.length()-1) == '+') {
            while(tokenizer.hasMoreElements()){
                result += Double.parseDouble(tokenizer.nextToken());
            }
        } else {
            throw new IllegalArgumentException("No math symbol at the end of the argument [+-*/]. " +
                                                "Unable to return a result.");
        }
        return result;
    }

}
