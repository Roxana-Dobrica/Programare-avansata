package lab5compulsory;

import java.io.IOException;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String args[]) throws IOException, InvalidCatalogException{
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1", "123", " RandomLocation1");
        var article = new Document("book1", "234", " RandomLocation2");
        catalog.addDocument(book);
        catalog.addDocument(article);

        CatalogUtil.save(catalog, "C:\\Users\\Roxana\\Desktop\\Programare avansata\\catalog.json");
    }

    private void testLoadView() throws IOException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Roxana\\Desktop\\Programare avansata\\catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }
}
