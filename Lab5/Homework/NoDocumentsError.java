package com.mycompany.lab5homework;

/**
 *
 * @author Roxana Dobrica
 */
public class NoDocumentsError extends Exception {

    public NoDocumentsError(Catalog catalog) {
        System.out.println(catalog.getName() + " doesn't have documents.");
    }
}
