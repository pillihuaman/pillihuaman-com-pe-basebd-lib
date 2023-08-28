package pillihuaman.com.segurity.basebd.parameter.dao;

import pillihuaman.com.segurity.lib.commons.MyJsonWebToken;
import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.parameter.Parameter;

import java.util.List;

public interface ParameterRepository extends BaseMongoRepository<Parameter> {


    Parameter  saveParemeter(Parameter request, MyJsonWebToken tok);
    List<Parameter> getParameterByIdCode(Parameter request);
    List<Parameter> getParameterByName(String request);
}
