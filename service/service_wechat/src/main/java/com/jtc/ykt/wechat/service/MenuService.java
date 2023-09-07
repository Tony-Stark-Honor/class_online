package com.jtc.ykt.wechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jtc.ykt.model.wechat.Menu;
import com.jtc.ykt.vo.wechat.MenuVo;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 服务类
 * </p>
 *
 * @author 天赐
 * @since 2023-09-04
 */
public interface MenuService extends IService<Menu> {

    List<MenuVo> findMenuInfo();

    List<Menu> findMenuOneInfo();

    void syncMenu();

    void removeMenu();
}
