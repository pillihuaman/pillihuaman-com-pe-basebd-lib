package pillihuaman.com.basebd.control.dao;

import pillihuaman.com.basebd.user.User;
import pillihuaman.com.basebd.common.MyJsonWebToken;
import pillihuaman.com.lib.request.ReqControl;
import pillihuaman.com.lib.response.RespControl;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.control.Control;

import java.util.List;

public interface ControlDAO extends BaseMongoRepository<Control> {

	List<Control> listControl(ReqControl reqControl);
	Control saveControl(Control reqControl, MyJsonWebToken to);
	List<Control> findByUser(User user);

}
