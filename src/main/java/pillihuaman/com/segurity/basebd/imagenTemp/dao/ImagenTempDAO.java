package pillihuaman.com.segurity.basebd.imagenTemp.dao;

import org.bson.types.ObjectId;

import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.imagenTemp.ImagenTemp;

public interface ImagenTempDAO extends BaseMongoRepository<ImagenTemp> {
	ObjectId saveImagenFile(ImagenTemp detail) throws Exception;
	byte[] getImagenInputStream(String idImagen);
}
