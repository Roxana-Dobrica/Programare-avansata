package com.mycompany.lab5homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Roxana Dobrica
 */
public class LoadCommand extends Command {

    public static Catalog load(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = null;
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (catalog == null) {
                throw new InvalidCatalogException();
            }
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        return catalog;
    }
}
