package pillihuaman.com.basebd.control.domain.dao;

import pillihuaman.com.base.request.ReqControl;
import pillihuaman.com.base.response.RespControl;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.control.domain.Control;

import java.util.List;

public interface ControlDAO extends BaseMongoRepository<Control> {

	List<Control> listControl(ReqControl reqControl);
	List<RespControl> saveControl(ReqControl reqControl);
}
