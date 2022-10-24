package pillihuaman.com.basebd.imagenTemp.domain.dao;

import org.bson.types.ObjectId;

import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.imagenTemp.domain.ImagenTemp;

public interface ImagenTempDAO extends BaseMongoRepository<ImagenTemp> {
	ObjectId saveImagenFile(ImagenTemp detail) throws Exception;
	byte[] getImagenInputStream(String idImagen);
}
