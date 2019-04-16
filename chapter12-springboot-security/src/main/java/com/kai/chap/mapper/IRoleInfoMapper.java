package com.kai.chap.mapper;

import com.kai.chap.pojo.po.RoleInfo;
import org.springframework.stereotype.Repository;

/**
 * 角色数据访问接口
 * @author hok
 * @since 2019-4-9 15:49:10
 */
@Repository
public interface IRoleInfoMapper {

    RoleInfo selectRoleById(Long id);

}
