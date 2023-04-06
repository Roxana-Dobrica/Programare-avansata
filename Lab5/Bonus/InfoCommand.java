package com.mycompany.lab5bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class InfoCommand extends Command {
    public void info(Catalog catalog) {
        try {
            if (catalog == null) {
                throw new InvalidCatalogException();
            }
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        for (Document document : catalog.getDocuments()) {
            System.out.println(document.getTags());
        }
    }
}
