package com.mycompany.lab5homework;

/**
 *
 * @author Roxana Dobrica
 */
abstract class Command {

    public static Catalog load(String path) throws InvalidCommand {
        throw new InvalidCommand("load");
    }

    public static void save(Catalog catalog, String path) throws InvalidCommand {
        throw new InvalidCommand("save");
    }

    public static void list(Catalog catalog) throws InvalidCommand {
        throw new InvalidCommand("list");
    }

    public static void view(Document document) throws InvalidCommand {
        throw new InvalidCommand("view");
    }

    public static void report(Catalog catalog) throws InvalidCommand {
        throw new InvalidCommand("report");
    }

    public static void add(Document document) throws InvalidCommand {
        throw new InvalidCommand("add");
    }
}
