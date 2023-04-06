package com.mycompany.lab5bonus;

/**
 *
 * @author Roxana
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
