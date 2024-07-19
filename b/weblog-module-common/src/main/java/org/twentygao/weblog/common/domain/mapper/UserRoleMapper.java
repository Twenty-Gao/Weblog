package org.twentygao.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.twentygao.weblog.common.domain.dos.UserRoleDo;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRoleDo> {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    default List<UserRoleDo> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDo::getUsername, username);

        return selectList(wrapper);
    }
}
