package pillihuaman.com.basebd.userGeneral.domain.dao;

import pillihuaman.com.base.request.ReqUser;
import pillihuaman.com.base.response.RespBase;
import pillihuaman.com.base.response.RespUser;

public interface UserGeneralRepositoy {
	RespBase<RespUser> getUserByMail(String mail);
	RespBase<RespUser> getUserByUserName(String mail);
	RespBase<RespUser>  lastUser ( ReqUser request);
	RespBase<RespUser>  registerUser ( ReqUser request);

}
