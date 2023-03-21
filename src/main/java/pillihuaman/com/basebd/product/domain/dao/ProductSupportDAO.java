package pillihuaman.com.basebd.product.domain.dao;

import java.io.IOException;
import java.util.List;

import pillihuaman.com.basebd.common.ProductStock;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.product.domain.Product;

public interface ProductSupportDAO extends BaseMongoRepository<Product> {
	boolean  SaveProduct(Product request);
	List<Product> getCorrelativeProduct(Product request);
	List<Product> getallProductbyUser (Product request);

	 boolean saveStock(ProductStock request) throws IOException;
}
