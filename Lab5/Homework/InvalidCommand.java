package com.mycompany.lab5homework;

/**
 *
 * @author Roxana Dobrica
 */
public class InvalidCommand extends Exception {

    public InvalidCommand(String message) {
        System.err.println("Invalid call of command " + message);
    }
}
