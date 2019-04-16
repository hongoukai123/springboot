package com.kai.chap.service;

import com.kai.chap.pojo.po.RoleInfo;

/**
 * 角色业务接口
 * @author hok
 * @since 2019-4-9 15:49:42
 */
public interface IRoleInfoService {

    RoleInfo selectRoleById(Long id);

}
