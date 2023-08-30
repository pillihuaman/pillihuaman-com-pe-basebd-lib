package pillihuaman.com.basebd.control.dao;

import pillihuaman.com.lib.commons.MyJsonWebToken;
import pillihuaman.com.lib.request.ReqControl;
import pillihuaman.com.lib.response.RespControl;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.control.Control;

import java.util.List;

public interface ControlDAO extends BaseMongoRepository<Control> {

	List<Control> listControl(ReqControl reqControl);
	List<RespControl> saveControl(ReqControl reqControl, MyJsonWebToken to);
}
