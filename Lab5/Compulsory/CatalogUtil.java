package lab5compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Roxana Dobrica
 */
public class CatalogUtil {

    public static void save(Catalog catalog, String path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path),catalog);
    }

    public static Catalog load(String path) throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        if (catalog == null) {
            throw new InvalidCatalogException(path);
        }
        return catalog;
    }

    public static void view(Document doc) {
        System.out.println(doc);
    }

}
