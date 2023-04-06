package com.mycompany.lab5bonus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import org.apache.tika.metadata.Metadata;

/**
 * @author Roxana Dobrica
 */
public class GetMetadata {

    public void extractMetadata(Catalog catalog) throws IOException {

        for (Document document : catalog.getDocuments()) {

            File file = new File(document.getLocation());

            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(file);
            ParseContext context = new ParseContext();

            try {
                try {
                    parser.parse(inputstream, handler, metadata, context);
                } catch (TikaException e) {
                    throw new RuntimeException(e);
                }
            } catch (SAXException ex) {
            } finally {
                inputstream.close();
            }
            String[] metadataNames = metadata.names();
            for (String name : metadataNames) {
                String value = metadata.get(name);
                document.addTag(name, value);
            }
        }
    }

    public void info(Catalog catalog) {
        for (Document document : catalog.getDocuments()) {
            System.out.println(document.getTags());
        }
    }
}
