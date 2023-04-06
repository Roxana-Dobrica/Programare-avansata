package com.mycompany.lab5bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class FileNotFound extends Exception{
    public FileNotFound(){
        System.out.println("The file you try to open doesn't exist.");
    }
}
