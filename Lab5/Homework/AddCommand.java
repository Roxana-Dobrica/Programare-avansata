package com.mycompany.lab5homework;

/**
 *
 * @author Roxana Dobrica
 */
public class AddCommand extends Command {

    public static void addDocument(Document document, Catalog catalog) {
        try {
            if (catalog == null) {
                throw new InvalidCatalogException();
            }
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        catalog.addDocument(document);
    }
}
