package com.liufei.mall.tiny.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liufei
 * @version 1.0.0
 * @description oss上传文件的回调结果
 * @date 2022/9/14
 */
@Data
public class OssCallbackResult {

    @ApiModelProperty("文件名称")
    private String filename;

    @ApiModelProperty("文件大小")
    private String size;

    @ApiModelProperty("文件的mimeType")
    private String mimeType;

    @ApiModelProperty("图片文件的宽")
    private String width;

    @ApiModelProperty("图片文件的高")
    private String height;

}
