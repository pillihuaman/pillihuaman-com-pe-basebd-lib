package pillihuaman.com.product.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoCollection;

import pillihuaman.com.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.help.AuditEntity;
import pillihuaman.com.help.Constants;
import pillihuaman.com.product.domain.Product;
import pillihuaman.com.product.domain.dao.ProductSupportDAO;

@Component
public class ProductSupportDaoImplement extends AbstractMongoDBRepositoryImpl<Product> implements ProductSupportDAO {
	ProductSupportDaoImplement() {
		DS_WRITE = Constants.DW;
		// DS_READ = Constants.DR;
		COLLECTION = Constants.COLLECTION_PRODUCT;

	}

	@Override
	public boolean SaveProduct(Product request) {
		Document doc = new Document();
		Document docAud = new Document();
		AuditEntity aud = new AuditEntity();
		aud.setCodUsuRegis("ZPH");
		aud.setFecRegis(new Date());
		request.setAuditEntity(aud);
		doc.put("description", request.getDescription());
		doc.put("name", request.getName());
		doc.put("id_user", request.getIdUser());
		doc.put("id_product", request.getIdProduct());
		docAud.put("cod_usuRegis", aud.getCodUsuRegis());
		docAud.put("fec_regis", aud.getFecRegis());

		doc.put("auditEntity", docAud);
		save(doc);
		return true;
	}

	@Override
	public List<Product> getCorrelativeProduct(Product request) {

		MongoCollection<Product> collection = getCollection(this.collectionName, Product.class);
		Document query = new Document();
		Document sort = new Document().append("id_product", -1);
		List<Product> lisProduct = collection.find(query, Product.class).sort(sort).limit(1)
				.into(new ArrayList<Product>());
		return lisProduct;
	}

	@Override
	public Class<Product> provideEntityClass() {
		// TODO Auto-generated method stub
		return Product.class;
	}
}
