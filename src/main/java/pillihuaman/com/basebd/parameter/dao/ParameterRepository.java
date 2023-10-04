package pillihuaman.com.basebd.parameter.dao;

import pillihuaman.com.basebd.common.MyJsonWebToken;
import pillihuaman.com.basebd.parameter.Parameter;
import pillihuaman.com.basebd.config.BaseMongoRepository;

import java.util.List;

public interface ParameterRepository extends BaseMongoRepository<Parameter> {


    Parameter  saveParemeter(Parameter request, MyJsonWebToken tok);
    List<Parameter> getParameterByIdCode(Parameter request);
    List<Parameter> getParameterByName(String request);
}
