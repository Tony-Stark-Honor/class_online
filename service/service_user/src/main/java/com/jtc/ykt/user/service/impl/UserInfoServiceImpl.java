package com.jtc.ykt.user.service.impl;


import com.jtc.ykt.model.user.UserInfo;
import com.jtc.ykt.user.mapper.UserInfoMapper;
import com.jtc.ykt.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 天赐
 * @since 2023-09-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
