package com.jtc.ykt.feign;

import com.jtc.ykt.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 15:20
 * @Decsription: feign
 * @version: 1.0
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

    @GetMapping("/admin/user/userInfo/inner/getById/{id}")
    UserInfo getById(@PathVariable Long id);

}
