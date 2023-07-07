package pillihuaman.com.basebd.parameter.domain;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Parameter implements Serializable {
    private static final long serialVersionUID = 1L;

    @BsonProperty(value = "_id")
    private ObjectId id;


    private String idCode;

    private String name;
    private String description;
    private List<String> parameterItems;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getParameterItems() {
        return parameterItems;
    }

    public void setParameterItems(List<String> parameterItems) {
        this.parameterItems = parameterItems;
    }
}