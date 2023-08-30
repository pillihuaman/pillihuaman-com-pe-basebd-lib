package pillihuaman.com.basebd.userGeneral;


import pillihuaman.com.lib.request.ReqUser;
import pillihuaman.com.lib.response.RespBase;
import pillihuaman.com.lib.response.RespUser;

public interface UserGeneralRepositoy {
	RespBase<RespUser> getUserByMail(String mail);
	RespBase<RespUser> getUserByUserName(String mail);
	RespBase<RespUser>  lastUser ( ReqUser request);
	RespBase<RespUser>  registerUser ( ReqUser request);

}
