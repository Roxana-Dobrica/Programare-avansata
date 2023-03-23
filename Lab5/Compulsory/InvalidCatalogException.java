package lab5compulsory;

/**
 *
 * @author Roxana Dobrica
 */
class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String ex) {
        super("Invalid catalog file :" + ex);
    }
}
