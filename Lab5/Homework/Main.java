package com.mycompany.lab5homework;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String args[]) throws IOException, InvalidCatalogException, TemplateException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("123", "book1", "C:\\Users\\Roxana\\Desktop\\stefana\\koal.png");
        var article = new Document("234", "article1", " RandomLocation2");
        book.addTag("author", "Ion Creanga");
        book.addTag("year", "1870");
        article.addTag("author", "Mihai Eminescu");
        AddCommand.addDocument(book, catalog);
        AddCommand.addDocument(article, catalog);

        SaveCommand.save(catalog, "C:\\Users\\Roxana\\Desktop\\Programare avansata\\catalog.json");
    }

    private void testLoadView() {
        Catalog catalog = LoadCommand.load("C:\\Users\\Roxana\\Desktop\\Programare avansata\\catalog.json");
        ViewCommand.view(catalog.findById("123"));
        ViewCommand.view(catalog.findById("234"));
        ReportCommand.report(catalog);
    }
}
