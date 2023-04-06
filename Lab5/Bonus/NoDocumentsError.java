package com.mycompany.lab5bonus;

/**
 *
 * @author Roxana
 */
public class NoDocumentsError extends Exception {
    public NoDocumentsError(Catalog catalog){
        System.out.println(catalog.getName() + " doesn't have documents.");
    }
}
