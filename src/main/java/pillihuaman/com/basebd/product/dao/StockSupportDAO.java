package pillihuaman.com.basebd.product.dao;

import org.bson.types.ObjectId;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.common.ProductStock;
import pillihuaman.com.lib.request.ImagenDetail;

public interface StockSupportDAO extends BaseMongoRepository<ProductStock> {

	 boolean saveStock(ProductStock request) throws Exception;
	ObjectId saveImagenFileOfStock(ImagenDetail detail) throws Exception;
}
