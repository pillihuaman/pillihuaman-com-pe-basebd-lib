package pillihuaman.com.basebd.product.domain.dao;

import org.bson.types.ObjectId;
import pillihuaman.com.base.request.ImagenDetail;
import pillihuaman.com.basebd.common.ProductStock;
import pillihuaman.com.basebd.config.BaseMongoRepository;

public interface StockSupportDAO extends BaseMongoRepository<ProductStock> {

	 boolean saveStock(ProductStock request) throws Exception;
	ObjectId saveImagenFileOfStock(ImagenDetail detail) throws Exception;
}
