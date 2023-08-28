package pillihuaman.com.segurity.basebd.imagenProducer.dao;

import java.util.List;

import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.imagenProducer.ImagenFile;

public interface ImagenProducerDAO extends BaseMongoRepository<ImagenFile> {
	List<ImagenFile> getImagen(String idImagen);
	
	byte[] getImagenInputStream(String idImagen);
	List<ImagenFile> getTopImagen(int page,int perPage,String idDetail);
	List<ImagenFile> getLastCountImagen(String id);

	void  saveClickCountImagen(ImagenFile imFile);
}
