package com.mycompany.lab7compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class Cell {
    private List<Token> tokenList;

    Cell()
    {
        tokenList = new ArrayList<>();
    }
    Cell(List<Token> toAdd)
    {
        tokenList = new ArrayList<>(toAdd);
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }
}
