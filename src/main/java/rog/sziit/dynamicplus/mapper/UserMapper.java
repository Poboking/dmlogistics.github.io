package rog.sziit.dynamicplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import rog.sziit.dynamicplus.annotation.SwitchDataSource;
import rog.sziit.dynamicplus.models.User;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:56
 */
@Mapper
@SwitchDataSource()
public interface UserMapper extends BaseMapper<User> {
}
