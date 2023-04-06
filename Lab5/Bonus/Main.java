package com.mycompany.lab5bonus;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.net.URISyntaxException;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.tika.exception.TikaException;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        //app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("123", "book1", "C:\\Users\\Roxana\\Desktop\\stefana\\koal.png");
        var article = new Document("234", "article1", "C:\\Users\\Roxana\\Desktop\\stefana\\mer.png");
        var book2 = new Document("12", "book2", "E:\\ProgramareAvansata\\roxana.txt");
        book.addTag("author", "Ion Creanga");
        book.addTag("year", "1870");
        book2.addTag("auhor", "Mircea Eliade");
        article.addTag("author", "Mihai Eminescu");
        AddCommand.addDocument(book, catalog);
        AddCommand.addDocument(article, catalog);
        AddCommand.addDocument(book2, catalog);

        SaveCommand.save(catalog, "C:\\Users\\Roxana\\Desktop\\Programare avansata\\catalog.json");
        
        GetMetadata metadata = new GetMetadata();
        metadata.extractMetadata(catalog);
        InfoCommand information = new InfoCommand();
        information.info(catalog);
        
        Coloring coloring1 = new Coloring();
        coloring1.greedyColoring(catalog);
    }
   
}

