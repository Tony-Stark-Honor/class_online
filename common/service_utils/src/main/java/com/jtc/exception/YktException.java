package com.jtc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 小天
 * @Date: 2023/8/23 - 08 - 23 - 19:47
 * @Decsription: com.jtc.exception
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YktException extends RuntimeException {
    private Integer code;
    private String msg;

    public YktException(String msg){
        super(msg);
        this.msg = msg;
        this.code = 20003;
    }
}
