package pillihuaman.com.basebd.imagen.domain.dao.implement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.google.common.io.ByteStreams;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

import pillihuaman.com.basebd.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.imagen.domain.DetailImage;
import pillihuaman.com.basebd.imagen.domain.Imagen;
import pillihuaman.com.basebd.imagen.domain.dao.ImagenSupportDAO;

@Component
public class ImagenSupportDaoImplement extends AbstractMongoDBRepositoryImpl<Imagen> implements ImagenSupportDAO {
	ImagenSupportDaoImplement() {
		DS_WRITE = Constants.DW;
		// DS_READ = Constants.DR;
		COLLECTION = Constants.COLLECTION_IMAGEN;

	}

	@Override
	public Class<Imagen> provideEntityClass() {
		// TODO Auto-generated method stub
		return Imagen.class;
	}

	@Override
	public ObjectId saveImagenFile(DetailImage detail) throws Exception {

		InputStream iss = new ByteArrayInputStream(detail.getFiles());
		ByteArrayInputStream arrayIn = inputStreamToArrayInputStream(iss);

		GridFSBucket gridFSFilesBucket = getGridFSBucket("files");
		Document doc = new Document();
		doc.put("id_imagen", detail.getIdImagen());
		doc.put("id_head_imagen", detail.getIdHeadImagen());
		doc.put("name", detail.getName());
		doc.put("count_ranking", detail.getCountRanking());
		doc.put("click_count", detail.getClickCount());
		doc.put("id_detail", detail.getIdDetail());
		GridFSUploadOptions options = new GridFSUploadOptions().metadata(doc);
		ObjectId fileId = gridFSFilesBucket.uploadFromStream(detail.getName(), arrayIn, options);
		iss.close();
		arrayIn.close();
		arrayIn = null;
		iss = null;
		return fileId;
	}

	public static ByteArrayInputStream inputStreamToArrayInputStream(InputStream inStream) throws IOException {
		byte[] bytes = ByteStreams.toByteArray(inStream);
		ByteArrayInputStream bInput = new ByteArrayInputStream(bytes);
		return bInput;

	}

	@Override
	public Document saveImagenHeader(Imagen request) {
		Document doc = new Document();
		Document docAud = new Document();
		AuditEntity aud = new AuditEntity();
		aud.setCodUsuRegis("ZPH");
		aud.setFecRegis(new Date());
		request.setAuditEntity(aud);
		doc.put("description", request.getDescription());
		doc.put("name", request.getName());
		doc.put("id_user", request.getIdUser());
		doc.put("id_head_imagen", request.getIdHeadImagen());
		doc.put("id_product", request.getIdProduct());
		docAud.put("cod_usuRegis", aud.getCodUsuRegis());
		//save(doc);
		return save(doc);
	}

	@Override
	public List<Imagen> getCorrelativeImagen(Imagen request) {
		MongoCollection<Imagen> collection = getCollection(this.collectionName, Imagen.class);
		Document query = new Document();
		Document sort = new Document().append("id_head_imagen", -1);
		List<Imagen> lisProduct = collection.find(query, Imagen.class).sort(sort).limit(1)
				.into(new ArrayList<Imagen>());
		return lisProduct;
	}
}
