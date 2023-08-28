package pillihuaman.com.segurity.basebd.imagen.dao;


import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.common.ProductStock;
import pillihuaman.com.segurity.basebd.imagen.DetailImage;
import pillihuaman.com.segurity.basebd.imagen.Imagen;

public interface ImagenSupportDAO extends BaseMongoRepository<Imagen> {
	Document saveImagenHeader(Imagen  request);
	List<Imagen> getCorrelativeImagen(Imagen request);

	default ObjectId saveImagenFile(DetailImage detail) throws Exception {
		return null;
	}

	List<Imagen> getTopImagen(int page ,int perpage);
	void countImagenClickEventSave(String idDetail);
	List<Imagen> getLastCountImagenRank(String id);
	 ProductStock getStockProduct(int idProduct);
	 ObjectId saveImagenStockFile(DetailImage detail) throws Exception;
}
