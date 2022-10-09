package pillihuaman.com.imagen.domain.dao;


import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import pillihuaman.com.config.BaseMongoRepository;
import pillihuaman.com.imagen.domain.DetailImage;
import pillihuaman.com.imagen.domain.Imagen;

public interface ImagenSupportDAO extends BaseMongoRepository<Imagen> {
	Document saveImagenHeader(Imagen  request);
	List<Imagen> getCorrelativeImagen(Imagen request);
	ObjectId saveImagenFile(DetailImage detail) throws Exception;
}
