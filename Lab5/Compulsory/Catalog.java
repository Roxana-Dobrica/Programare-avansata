package lab5compulsory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class Catalog implements Serializable {
    private String name;
    private List<Document> documents = new ArrayList<>();
    
    @JsonCreator
    public Catalog(@JsonProperty("documents") List<Document> documents) {
        this.documents = documents;
    }
    
    public Catalog(String name){
        this.name = name;
    }
    
    public void addDocument(Document document) {
        documents.add(document);
    }
    
    public Document findById(String id) {
        return documents.stream()
                        .filter(d -> d.getId().equals(id))
                        .findFirst()
                        .orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", documents=" + documents + '}';
    }   
}
