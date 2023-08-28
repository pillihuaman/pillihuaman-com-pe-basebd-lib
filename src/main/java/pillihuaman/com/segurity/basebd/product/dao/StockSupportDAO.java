package pillihuaman.com.segurity.basebd.product.dao;

import org.bson.types.ObjectId;
import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.common.ProductStock;
import pillihuaman.com.segurity.lib.request.ImagenDetail;

public interface StockSupportDAO extends BaseMongoRepository<ProductStock> {

	 boolean saveStock(ProductStock request) throws Exception;
	ObjectId saveImagenFileOfStock(ImagenDetail detail) throws Exception;
}
