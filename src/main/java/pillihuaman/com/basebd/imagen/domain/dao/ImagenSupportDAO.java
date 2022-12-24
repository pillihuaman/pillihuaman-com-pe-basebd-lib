package pillihuaman.com.basebd.imagen.domain.dao;


import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.imagen.domain.DetailImage;
import pillihuaman.com.basebd.imagen.domain.Imagen;
import pillihuaman.com.basebd.imagenProducer.domain.ImagenFile;

public interface ImagenSupportDAO extends BaseMongoRepository<Imagen> {
	Document saveImagenHeader(Imagen  request);
	List<Imagen> getCorrelativeImagen(Imagen request);
	ObjectId saveImagenFile(DetailImage detail) throws Exception;
	List<Imagen> getTopImagen(int page ,int perpage);
	void countImagenClickEventSave(String idDetail);
	List<Imagen> getLastCountImagenRank(String id);
}
