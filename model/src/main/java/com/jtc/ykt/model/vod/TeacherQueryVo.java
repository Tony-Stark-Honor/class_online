package com.jtc.ykt.model.vod;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 小天
 * @Date: 2023/8/23 - 08 - 23 - 19:40
 * @Decsription: com.jtc.ykt.model.vod
 * @version: 1.0
 */
@Data
public class TeacherQueryVo {

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "入驻时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "入驻时间")
    private String joinDateEnd;


}
