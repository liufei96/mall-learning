package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}MapperV1;
import ${basePackage}.model.${modelNameUpperCamel}DOV1;
import ${basePackage}.service.${modelNameUpperCamel}ServiceV1;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description ${modelNameUpperCamel} service implements for basix CURD, including condition get, count etc
* @date ${date}
*/
@Service
public class ${modelNameUpperCamel}ServiceImplV1 extends AbstractService<${modelNameUpperCamel}DOV1> implements ${modelNameUpperCamel}ServiceV1{

    @Resource
    private ${modelNameUpperCamel}MapperV1 ${modelNameLowerCamel}MapperV1;

}