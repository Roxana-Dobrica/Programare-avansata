package com.mycompany.lab7compulsory;

/**
 *
 * @author Roxana Dobrica
 */
public class Token {
    private final int number;

    Token(int n)
    {
        number = n;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }

}
