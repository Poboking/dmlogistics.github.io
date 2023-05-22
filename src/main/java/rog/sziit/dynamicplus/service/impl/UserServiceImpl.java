package rog.sziit.dynamicplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import rog.sziit.dynamicplus.mapper.UserMapper;
import rog.sziit.dynamicplus.models.User;
import rog.sziit.dynamicplus.service.UserService;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/22 9:04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean register() {
        return false;
    }


    @Override
    public boolean login() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean updatePassWord() {
        return false;
    }
}
