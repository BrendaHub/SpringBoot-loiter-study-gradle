package com.shiro.service;

import com.shiro.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mmzsblog.cn
 * @since 2020-07-30
 */
public interface RoleService extends IService<Role> {
	Role getRoleByUserName(String username);
}
