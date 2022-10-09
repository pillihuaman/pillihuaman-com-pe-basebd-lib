package pillihuaman.com.product.domain.dao;

import java.util.List;

import pillihuaman.com.config.BaseMongoRepository;
import pillihuaman.com.product.domain.Product;

public interface ProductSupportDAO extends BaseMongoRepository<Product> {
	boolean  SaveProduct(Product request);

	List<Product> getCorrelativeProduct(Product request);
}
