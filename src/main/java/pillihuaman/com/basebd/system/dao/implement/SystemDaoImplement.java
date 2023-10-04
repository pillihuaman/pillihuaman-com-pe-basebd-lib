package pillihuaman.com.basebd.system.dao.implement;

import com.mongodb.client.MongoCollection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pillihuaman.com.basebd.common.MyJsonWebToken;
import pillihuaman.com.basebd.config.AbstractMongoRepositoryImpl;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.system.System;
import pillihuaman.com.basebd.system.dao.SystemDAO;
import pillihuaman.com.basebd.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SystemDaoImplement extends AbstractMongoRepositoryImpl<System> implements SystemDAO {
    SystemDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = Constants.COLLECTION_SYSTEM;
    }

    @Override
    public Class<System> provideEntityClass() {
        // TODO Auto-generated method stub
        return System.class;
    }
    protected final Log log = LogFactory.getLog(getClass());
    private final String NAME_OBJECT = "SystemDaoImplement";

    @Override
    public List<System> listSystem(int page, int pageSize) {
        MongoCollection<System> collection = getCollection(COLLECTION, System.class);
        Document query = new Document();
        // Calculate the number of documents to skip based on the page and pageSize
        int skipCount = (page - 1) * pageSize;
        // Sort by a field (e.g., id_user) or any other field you want
        Document sort = new Document("id_user", -1);
        // Use the skip and limit methods to implement pagination
        List<System> respo = collection.find(query, System.class)
                .sort(sort)
                .skip(skipCount)
                .limit(pageSize)
                .into(new ArrayList<System>());

        return respo;
    }

    @Override
    public System saveSystem(System request, MyJsonWebToken jwt) {
        System system = null;
        MongoCollection<System> collection = getCollection(COLLECTION, System.class);

        try {
            if (request != null && request.getId() == null) {
                AuditEntity auditEntity = new AuditEntity();
                auditEntity.setDateRegister(new Date());
                auditEntity.setMail(jwt.getUser().getMail()); // Assuming you have email information in the token
                auditEntity.setCodUser(jwt.getUser().get_id());
                request.setAudit(auditEntity);
                system = save(request);
            } else if (request != null) {
                Document query = new Document("_id", request.getId());
                Document updatedDoc = new Document();
                updatedDoc.putAll(request.toDocument()); // Implement the toDocument method in your System class

                // Set the last updated audit information
                updatedDoc.append("audit.dateUpdate", new Date());
                updatedDoc.append("audit.mail", jwt.getUser().getMail());

                // Create an update operation
                Document updateOperation = new Document("$set", updatedDoc);
                collection.updateOne(query, updateOperation);
                return systemById(request.getId());
            }
        } catch (Exception e) {
            log.error("Error in " + NAME_OBJECT+": ", e);
        }
        return system;
    }

    @Override
    public System systemById(Object id) {
        MongoCollection<System> collection = getCollection(COLLECTION, System.class);
        Document query = new Document().append("id", id);
        List<System> respo = collection.find(query, System.class).into(new ArrayList<System>());
        return respo.stream().findFirst().orElseThrow();
    }

    @Override
    public boolean deleteSystem(Object id) {
        try {
            MongoCollection<System> collection = getCollection(COLLECTION, System.class);
            Document query = new Document("_id", id);
            System existingSystem = collection.find(query, System.class).into(new ArrayList<System>()).stream().findFirst().orElseThrow();
            if (existingSystem.getId() != null) {
                System sys = new System();
                sys = existingSystem;
                sys.setActive(false);
                save(sys);
                // Update the system in the database

            }
            return true;
        } catch (Exception e) {
            log.error("Error in " + NAME_OBJECT+": ", e);
            return false;
        }
    }

}