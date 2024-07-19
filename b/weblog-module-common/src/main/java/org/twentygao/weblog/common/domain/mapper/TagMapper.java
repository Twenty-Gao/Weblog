package org.twentygao.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.jdbc.Null;
import org.twentygao.weblog.common.domain.dos.CategoryDO;
import org.twentygao.weblog.common.domain.dos.TagDO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public interface TagMapper extends BaseMapper<TagDO> {

    default Page<TagDO> selectPageList(Long current, Long size, String name, LocalDate startDate,LocalDate endDate) {
        Page<TagDO> page = new Page<>(current,size);
        // 构建查询条件
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .like(Objects.nonNull(name),TagDO::getName,name)
                .ge(Objects.nonNull(startDate),TagDO::getCreateTime,startDate)
                .le(Objects.nonNull(endDate),TagDO::getCreateTime,endDate)
                .orderByDesc(TagDO::getCreateTime);


        // 执行查询
        return selectPage(page,wrapper);
    }


    default List<TagDO> selectByKey(String key){
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(TagDO::getName,key).orderByDesc(TagDO::getCreateTime);

        return selectList(wrapper);
    }
    default List<TagDO> selectByIds(List<Long> tagIds) {
        return selectList(Wrappers.<TagDO>lambdaQuery()
                .in(TagDO::getId, tagIds));
    }
}
