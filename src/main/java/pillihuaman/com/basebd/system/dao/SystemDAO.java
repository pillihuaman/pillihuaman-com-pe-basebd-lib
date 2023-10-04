package pillihuaman.com.basebd.system.dao;

import pillihuaman.com.basebd.common.MyJsonWebToken;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.system.System;

import java.util.List;

public interface SystemDAO extends BaseMongoRepository<System> {

	List<System> listSystem(int page, int pageSize);
	System saveSystem(System req, MyJsonWebToken to);
	System systemById(Object id);
	boolean deleteSystem(Object id);
}
