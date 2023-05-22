package rog.sziit.dynamicplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import rog.sziit.dynamicplus.models.User;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:58
 */
public interface UserService extends IService<User> {
    public boolean register();

    public boolean login();
    public boolean updatePassWord();
}
