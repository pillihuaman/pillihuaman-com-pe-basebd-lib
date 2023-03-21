package pillihuaman.com.basebd.control.domain.dao.implement;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import pillihuaman.com.base.request.ReqControl;
import pillihuaman.com.base.response.RespControl;
import pillihuaman.com.basebd.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.basebd.control.domain.Control;
import pillihuaman.com.basebd.control.domain.dao.ControlDAO;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.help.ConstantsUseful;
import pillihuaman.com.basebd.user.domain.User;
import pillihuaman.com.basebd.user.domain.dao.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ControlDaoImplement extends AbstractMongoDBRepositoryImpl<Control> implements ControlDAO {

    ControlDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = Constants.COLLECTION_CONTROL;
    }

    private UserRepository userRepository;

    @Override
    public Class<Control> provideEntityClass() {
        return Control.class;
    }

    @Override
    public List<Control> listControl(ReqControl reqControl) {
        MongoCollection<Control> collection = getCollection(this.collectionName, Control.class);
        Document query = null;
        if (reqControl != null) {
            if (reqControl.getId_user() != null) {
                query = new Document().append("id_user", reqControl.getId_user());
            }
        } else {
            query = new Document().append("status", ConstantsUseful.CONTROL_ESTATE_PUBLIC);

        }
        List<Control> lisControl = collection.find(query, Control.class)
                .into(new ArrayList<Control>());
        return lisControl;
    }

    @Override
    public List<RespControl> saveControl(ReqControl request) {
        RespControl re = new RespControl();
        List<RespControl> lstre = new ArrayList<>();
        Document doc = new Document();
        Document docAud = new Document();
        //	List<User> lst=	userRepository.findUserById(request.getId_user());
        AuditEntity aud = new AuditEntity();
        aud.setCodUsuRegis(request.getId_user().toString());
        aud.setFecRegis(new Date());
        //
        List<Control> code = listControlbyCode(request);
        if (code ==null   || code.isEmpty()  || code.size()==0) {
            // doc.put("idCode", request.getIdCode());
            doc.put("idMenu", request.getIdMenu());
            doc.put("idSystem", request.getIdSystem());
            doc.put("idCode", createCodeControl(request));
            doc.put("idPage", request.getIdPage());
            doc.put("description", request.getDescription().toUpperCase());
            doc.put("icono", request.getIcono());
            doc.put("iconClass", request.getIconClass());
            doc.put("status", 1);
            doc.put("styleClass", request.getStyleClass());
            doc.put("text", request.getText());
            doc.put("id_user", request.getId_user());
            docAud.put("cod_usuRegis", aud.getCodUsuRegis());
            docAud.put("fec_regis", aud.getFecRegis());
            doc.put("auditEntity", docAud);

            Document co = save(doc);
            RespControl r = new RespControl();
            List<ReqControl> l = new ArrayList<>();
            ReqControl reco = new ReqControl();
            reco.set_id(new ObjectId(co.get("_id").toString()));
            //List<ReqControl> lsre= new ArrayList<>();
            l.add(reco);

            re.setLstControles(l);
            lstre.add(re);
        } else {
            lstre = null;
        }
        return lstre;
    }

    public String createCodeControl(ReqControl re) {
        //1  idSystem 1 support
        //2 idMenu 1 Support control
        //3 idPage 1 Save and Update control
        //4 text SAVE =SAVE  SAVE CONTROL= SC
        //5 purpose save =SA  Update=UP delete=DE export=EX select=SE count=CO  Search=SE  ETC TO MIX LIKE SAVE AND DELETE SADE , save and update SAUP
        String code = re.getIdSystem() +""+ re.getIdMenu() +""+ re.getIdPage() + re.getText() + re.getDescription().toUpperCase();

        return code;
    }

    public List<Control> listControlbyCode(ReqControl reqControl) {
        MongoCollection<Control> collection = getCollection(this.collectionName, Control.class);
        Document query = null;
        if (reqControl != null) {
            if (reqControl.getId_user() != null) {
                query = new Document()
                        .append("idMenu", reqControl.getIdMenu())
                        .append("idSystem", reqControl.getIdSystem())
                        .append("idPage", reqControl.getIdPage())
                        .append("text", reqControl.getText())
                        .append("description", reqControl.getDescription());
            }
        }
        List<Control> lisControl = collection.find(query, Control.class)
                .into(new ArrayList<Control>());
        return lisControl;
    }
}
