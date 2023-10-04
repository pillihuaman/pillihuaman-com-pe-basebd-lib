package pillihuaman.com.basebd.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pillihuaman.com.basebd.page.Page;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Document(collection = "menu")
@Builder
@Data
public class Menu implements Serializable {
    @Id
    private ObjectId id;
    private String name;
    private List<Page> pages;
    private System parentSystem; // Relationship to the System collection
}
