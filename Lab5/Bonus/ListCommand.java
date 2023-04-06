package com.mycompany.lab5bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class ListCommand extends Command {

    public static void list(Catalog catalog) {
        try {
            if (catalog.getDocuments() == null) {
                throw new NoDocumentsError(catalog);
            }
        } catch (NoDocumentsError e) {
            System.out.println(e.getMessage());
        }
        for (Document doc : catalog.getDocuments()) {
            System.out.println(doc);
        }
    }
}
