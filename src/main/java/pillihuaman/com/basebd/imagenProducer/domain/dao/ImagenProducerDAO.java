package pillihuaman.com.basebd.imagenProducer.domain.dao;

import java.util.List;

import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.imagenProducer.domain.ImagenFile;

public interface ImagenProducerDAO extends BaseMongoRepository<ImagenFile> {
	List<ImagenFile> getImagen(String idImagen);
	
	byte[] getImagenInputStream(String idImagen);
	List<ImagenFile> getTopImagen(int page,int perPage,String idDetail);
}
