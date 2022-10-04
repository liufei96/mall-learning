package com.liufei.mall.tiny.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.liufei.mall.tiny.core.Result;
import com.liufei.mall.tiny.core.ResultGenerator;
import com.liufei.mall.tiny.model.Member;
import com.liufei.mall.tiny.model.Order;
import com.liufei.mall.tiny.model.OrderData;
import com.liufei.mall.tiny.model.Product;
import com.liufei.mall.tiny.strategy.CustomMergeStrategy;
import com.liufei.mall.tiny.utils.LocalJsonUtil;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description EasyExcel导入导出测试Controller
 * @date 2022/10/4
 */
@RestController
@RequestMapping("/easyExcel")
public class EasyExcelController {


    @SneakyThrows(IOException.class)
    @ApiOperation(value = "导出会员列表Excel")
    @GetMapping(value = "/exportMemberList")
    public void exportMemberList(HttpServletResponse response) {
        setExcelRespProp(response, "会员列表");
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        EasyExcel.write(response.getOutputStream())
                .head(Member.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("会员列表")
                .doWrite(memberList);
    }

    @SneakyThrows
    @ApiOperation("从Excel导入会员列表")
    @PostMapping(value = "/importMemberList")
    public Result importMemberList(@RequestPart("file") MultipartFile file) {
        List<Member> memberList = EasyExcel.read(file.getInputStream())
                .head(Member.class)
                .sheet()
                .doReadSync();
        return ResultGenerator.genSuccessResult(memberList);
    }

    @SneakyThrows
    @ApiOperation(value = "导出订单列表Excel")
    @RequestMapping(value = "/exportOrderList", method = RequestMethod.GET)
    public void exportOrderList(HttpServletResponse response) {
        List<Order> orderList = getOrderList();
        List<OrderData> orderDataList = convert(orderList);
        setExcelRespProp(response, "订单列表");
        EasyExcel.write(response.getOutputStream())
                .head(OrderData.class)
                .registerWriteHandler(new CustomMergeStrategy(OrderData.class))
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("订单列表")
                .doWrite(orderDataList);
    }

    /**
     * 设置excel下载响应头属性
     */
    private void setExcelRespProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }

    private List<OrderData> convert(List<Order> orderList) {
        List<OrderData> result = new ArrayList<>();
        for (Order order : orderList) {
            List<Product> productList = order.getProductList();
            for (Product product : productList) {
                OrderData orderData = new OrderData();
                BeanUtil.copyProperties(product, orderData);
                BeanUtil.copyProperties(order, orderData);
                result.add(orderData);
            }
        }
        return result;
    }

    private List<Order> getOrderList() {
        List<Order> orderList = LocalJsonUtil.getListFromJson("json/orders.json", Order.class);
        List<Product> productList = LocalJsonUtil.getListFromJson("json/products.json", Product.class);
        List<Member> memberList = LocalJsonUtil.getListFromJson("json/members.json", Member.class);
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            order.setMember(memberList.get(i));
            order.setProductList(productList);
        }
        return orderList;
    }
}
