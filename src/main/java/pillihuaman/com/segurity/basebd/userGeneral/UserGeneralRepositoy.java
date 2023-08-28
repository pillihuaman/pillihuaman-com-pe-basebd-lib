package pillihuaman.com.segurity.basebd.userGeneral;


import pillihuaman.com.segurity.lib.request.ReqUser;
import pillihuaman.com.segurity.lib.response.RespBase;
import pillihuaman.com.segurity.lib.response.RespUser;

public interface UserGeneralRepositoy {
	RespBase<RespUser> getUserByMail(String mail);
	RespBase<RespUser> getUserByUserName(String mail);
	RespBase<RespUser>  lastUser ( ReqUser request);
	RespBase<RespUser>  registerUser ( ReqUser request);

}
