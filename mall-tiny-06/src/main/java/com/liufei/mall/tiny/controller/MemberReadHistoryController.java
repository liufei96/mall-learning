package com.liufei.mall.tiny.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.liufei.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 会员商品浏览记录管理Controller
 * @date 2022/9/13
 */
@RestController
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Resource
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @PostMapping(value = "/create")
    public Result create(@RequestBody MemberReadHistory memberReadHistory) {
        MemberReadHistory memberReadHistory1 = memberReadHistoryService.create(memberReadHistory);
        return ResultGenerator.genSuccessResult(memberReadHistory1);
    }

    @ApiOperation("删除浏览记录")
    @DeleteMapping(value = "/delete")
    public Result delete(@RequestParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        return count > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除浏览记录失败");
    }

    @ApiOperation("展示浏览记录")
    @GetMapping(value = "/list")
    public Result<List<MemberReadHistory>> list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return ResultGenerator.genSuccessResult(memberReadHistoryList);
    }
}
