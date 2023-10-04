package pillihuaman.com.basebd.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.menu.Menu;
import pillihuaman.com.basebd.user.User;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "page")
public class Page implements Serializable {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private String url;
    private Menu parentMenu;

    // Additional properties
    private boolean isPublished;
    private String metaKeywords;
    private String metaDescription;
    private List<User> authorizedUsers;
    private AuditEntity audit;
}