package ${basePackage}.controller;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.core.RequestCondition;
import ${basePackage}.core.UpdateCondition;
import ${basePackage}.model.${modelNameUpperCamel}DOV1;
import ${basePackage}.service.${modelNameUpperCamel}ServiceV1;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

import java.util.List;

/**
* @author liufei
* @version 1.0.0
* @description ${modelNameUpperCamel} controller for basix CURD, including condition get, count etc
* @date ${date}
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}ControllerV1 {

    @Resource
    private ${modelNameUpperCamel}ServiceV1 ${modelNameLowerCamel}ServiceV1;

    @ApiOperation(value = "Create ${modelNameUpperCamel}", notes = "Create ${modelNameUpperCamel}")
    @PostMapping
    public Result<Integer> create(@RequestBody ${modelNameUpperCamel}DOV1 ${modelNameLowerCamel}) {
        int row = ${modelNameLowerCamel}ServiceV1.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate ${modelNameUpperCamel}", notes = "batchCreate ${modelNameUpperCamel}")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<${modelNameUpperCamel}DOV1> ${modelNameLowerCamel}s) {
        int rows = ${modelNameLowerCamel}ServiceV1.save(${modelNameLowerCamel}s);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById ${modelNameUpperCamel}", notes = "findById ${modelNameUpperCamel}")
    @GetMapping("/{id}")
    public Result<${modelNameUpperCamel}DOV1> findById(@PathVariable Integer id) {
        ${modelNameUpperCamel}DOV1 ${modelNameLowerCamel} = ${modelNameLowerCamel}ServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @ApiOperation(value = "findByIds ${modelNameUpperCamel}", notes = "findByIds ${modelNameUpperCamel}")
    @GetMapping("/findByIds/{ids}")
    public Result<List<${modelNameUpperCamel}DOV1>> findByIds(@PathVariable String ids) {
        List<${modelNameUpperCamel}DOV1> ${modelNameLowerCamel}s = ${modelNameLowerCamel}ServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel}s);
    }

    @ApiOperation(value = "findByField ${modelNameUpperCamel}", notes = "findByField ${modelNameUpperCamel}")
    @GetMapping("/findByField/{field}/{value}")
    public Result<${modelNameUpperCamel}DOV1> findByField(@PathVariable String field, @PathVariable String value) {
        ${modelNameUpperCamel}DOV1 ${modelNameLowerCamel} = ${modelNameLowerCamel}ServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @ApiOperation(value = "findAll ${modelNameUpperCamel}", notes = "findAll ${modelNameUpperCamel}")
    @GetMapping("/findAll")
    public Result<PageInfo<${modelNameUpperCamel}DOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}DOV1> list = ${modelNameLowerCamel}ServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition ${modelNameUpperCamel}", notes = "listByCondition ${modelNameUpperCamel}")
    @PostMapping("/listByCondition")
    public Result<PageInfo<${modelNameUpperCamel}DOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(${modelNameUpperCamel}DOV1.class);
        List<${modelNameUpperCamel}DOV1> list = ${modelNameLowerCamel}ServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update ${modelNameUpperCamel}", notes = "update ${modelNameUpperCamel}")
    @PutMapping
    public Result<Integer> update(@RequestBody ${modelNameUpperCamel}DOV1 ${modelNameLowerCamel}) {
        int row = ${modelNameLowerCamel}ServiceV1.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition ${modelNameUpperCamel}", notes = "updateByCondition ${modelNameUpperCamel}")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<${modelNameUpperCamel}DOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(${modelNameUpperCamel}DOV1.class);
        int rows = ${modelNameLowerCamel}ServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete ${modelNameUpperCamel}", notes = "delete ${modelNameUpperCamel}")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = ${modelNameLowerCamel}ServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds ${modelNameUpperCamel}", notes = "deleteByIds ${modelNameUpperCamel}")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = ${modelNameLowerCamel}ServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition ${modelNameUpperCamel}", notes = "deleteByCondition ${modelNameUpperCamel}")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(${modelNameUpperCamel}DOV1.class);
        int rows = ${modelNameLowerCamel}ServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count ${modelNameUpperCamel}", notes = "count ${modelNameUpperCamel}")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(${modelNameUpperCamel}DOV1.class);
        int count = ${modelNameLowerCamel}ServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}