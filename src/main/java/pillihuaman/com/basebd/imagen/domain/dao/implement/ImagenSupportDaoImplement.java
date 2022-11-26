package pillihuaman.com.basebd.imagen.domain.dao.implement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
		doc.put("idImagen", detail.getIdImagen());
		doc.put("idHeadImagen", detail.getIdHeadImagen());
		doc.put("name", detail.getName());
		doc.put("countRanking", detail.getCountRanking());
		doc.put("clickCount", detail.getClickCount());
		doc.put("idDetail", detail.getIdDetail());
		doc.put("index", detail.getIndex());
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
		doc.put("description", request.getDescription());
		doc.put("name", request.getName());
		doc.put("idUser", request.getIdUser());
		doc.put("idHeadImagen", request.getIdHeadImagen());
		doc.put("idProduct", request.getIdProduct());
		doc.put("countRanking", 0);
		doc.put("clickCount", 0);
		docAud.put("codUsuRegis", request.getAuditEntity().getCodUsuRegis());
		docAud.put("fecRegis", new Date());
		doc.put("auditEntity", docAud);
		return save(doc);
	}

	@Override
	public List<Imagen> getCorrelativeImagen(Imagen request) {
		MongoCollection<Imagen> collection = getCollection(this.collectionName, Imagen.class);
		Document query = new Document();
		Document sort = new Document().append("idHeadImagen", -1);
		List<Imagen> lisProduct = collection.find(query, Imagen.class).sort(sort).limit(1)
				.into(new ArrayList<Imagen>());
		return lisProduct;
	}
	@Override
	public List<Imagen> getTopImagen(int page ,int perpage) {

		Document quer=new Document();
		int skip=0;

		if(page==1) {
			skip=0;
		}else {
			if(page>0) {
				skip= (perpage*(page-1));
			}
		}
		List<Document> pipeline = Arrays.asList(new Document()
				.append("$sort", new Document()
						.append("countRanking", -1)), new Document()
				.append("$skip", skip), new Document()
				.append("$limit", perpage));

		MongoCollection<Imagen> collection = getCollection(this.collectionName, Imagen.class);

		//int cantTotalRegistros = collection.aggregate(pipeline).into(new ArrayList<Imagen>()).size();
		List<Imagen> lisImg	=	collection.aggregate(pipeline).into(new ArrayList<Imagen>());
		return lisImg;
	}
}
