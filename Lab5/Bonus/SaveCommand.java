package com.mycompany.lab5bonus;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Roxana
 */
public class SaveCommand extends Command {
    public static void save(Catalog catalog, String path) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path),catalog);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());  //urmareste in sens invers de unde a aparut eroarea
        }
    }
}
