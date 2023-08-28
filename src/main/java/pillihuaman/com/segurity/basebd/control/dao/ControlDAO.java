package pillihuaman.com.segurity.basebd.control.dao;

import pillihuaman.com.segurity.lib.commons.MyJsonWebToken;
import pillihuaman.com.segurity.lib.request.ReqControl;
import pillihuaman.com.segurity.lib.response.RespControl;
import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.control.Control;

import java.util.List;

public interface ControlDAO extends BaseMongoRepository<Control> {

	List<Control> listControl(ReqControl reqControl);
	List<RespControl> saveControl(ReqControl reqControl, MyJsonWebToken to);
}
