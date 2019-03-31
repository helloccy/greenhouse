package com.greenhouse.service;

import com.greenhouse.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.greenhouse.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 用户表（包括普通管理员与普通职工） 服务类
 * </p>
 *
 * @author hjt
 * @since 2019-03-31
 */
public interface IUserService extends IService<User> {

}
