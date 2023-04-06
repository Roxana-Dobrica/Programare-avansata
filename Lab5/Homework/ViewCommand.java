package com.mycompany.lab5homework;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Roxana Dobrica
 */
public class ViewCommand extends Command {

    public static void view(Document document) {
        if (document != null) {
            File file = new File(document.getLocation());
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
                System.out.println("File doesn't exist. " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Failed to open the file " + e.getMessage());
            }
        }
    }
}
