package pillihuaman.com.basebd.parameter.domain.dao.implement;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Component;
import pillihuaman.com.base.commons.MyJsonWebToken;
import pillihuaman.com.basebd.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.help.Util;
import pillihuaman.com.basebd.parameter.domain.Parameter;
import pillihuaman.com.basebd.parameter.domain.dao.ParameterRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParameterDaoImplement extends AbstractMongoDBRepositoryImpl<Parameter> implements ParameterRepository {
	ParameterDaoImplement() {
		DS_WRITE = Constants.DW;
		// DS_READ = Constants.DR;
		COLLECTION = Constants.COLLECTION_PARAMETER;
	}

	@Override
	public Class<Parameter> provideEntityClass() {
		// TODO Auto-generated method stub
		return Parameter.class;
	}

	@Override
	public boolean saveParemeter(Parameter request , MyJsonWebToken tok) {
		Document doc = new Document();
		//request.setAuditEntity( Util.InsertAuditEntity(tok));
		doc.put("idCode", request.getIdCode());
		doc.put("name", request.getName());
		doc.put("description", request.getDescription());
		doc.put("parameterItems", request.getParameterItems());
		doc.put("auditEntity", Util.insertAuditEntity(tok));

		save(doc);
		return true;
	}

	@Override
	public List<Parameter> getParameterByIdCode(Parameter request) {
		MongoCollection<Parameter> collection = getCollection(this.collectionName, Parameter.class);
		Document query = new Document().append("idCode", request.getIdCode());
		List<Parameter> lisParameter= collection.find(query, Parameter.class)
				.into(new ArrayList<Parameter>());
		return lisParameter;
	}



}
