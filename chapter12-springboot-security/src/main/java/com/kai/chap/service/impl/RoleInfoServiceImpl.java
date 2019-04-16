package com.kai.chap.service.impl;

import com.kai.chap.mapper.IRoleInfoMapper;
import com.kai.chap.pojo.po.RoleInfo;
import com.kai.chap.service.IRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色业务实现类
 * @author hok
 * @since 2019-4-9 15:46:51
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements IRoleInfoService {

    @Autowired
    private IRoleInfoMapper roleInfoMapper;

    @Override
    public RoleInfo selectRoleById(Long id) {
        return roleInfoMapper.selectRoleById(id);
    }
}
