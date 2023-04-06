package com.mycompany.lab5homework;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roxana Dobrica
 */
public class ReportCommand extends Command {

    public static void report(Catalog catalog) {
        Configuration config = new Configuration(Configuration.VERSION_2_3_31);
        config.setClassForTemplateLoading(Main.class, "/templates");
        config.setDefaultEncoding("UTF-8");

        try {

            Template template = config.getTemplate("catalog.ftl");

            Map<String, Object> content = new HashMap<>();
            content.put("name", catalog.getName());
            content.put("documents", catalog.getDocuments());

            File file = new File("C:\\Users\\Roxana\\Desktop\\Programare avansata\\Lab5Homework\\doc.html");
            Writer writer = new FileWriter(file);

            template.process(content, writer);
            try {
                if (!file.exists()) {
                    throw new FileNotFound();
                }
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.OPEN)) {
                        desktop.open(file);
                    } else {
                        System.out.println("File not supported.");
                    }
                }
            } catch (FileNotFound e) {

            }
            writer.close();

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
