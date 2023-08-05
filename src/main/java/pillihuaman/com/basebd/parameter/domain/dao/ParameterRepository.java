package pillihuaman.com.basebd.parameter.domain.dao;

import pillihuaman.com.base.commons.MyJsonWebToken;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.parameter.domain.Parameter;

import java.util.List;

public interface ParameterRepository extends BaseMongoRepository<Parameter> {


    Parameter  saveParemeter(Parameter request, MyJsonWebToken tok);
    List<Parameter> getParameterByIdCode(Parameter request);
    List<Parameter> getParameterByName(String request);
}
