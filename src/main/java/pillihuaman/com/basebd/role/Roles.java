package pillihuaman.com.basebd.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.menu.Menu;
import pillihuaman.com.basebd.user.User;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "roles")
public class Roles implements Serializable   {
    @Id
    private ObjectId id;
    private String name;
    private List<System> system;
    private List<Menu> menus;
    private String description;
    private List<String> permissions;
    private boolean active;
    @DBRef
    private List<User> assignedUsers;
    private AuditEntity audit;
    public Roles() {

    }

}




