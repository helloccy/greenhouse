package com.greenhouse.service.impl;

import com.greenhouse.entity.User;
import com.greenhouse.mapper.UserMapper;
import com.greenhouse.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表（包括普通管理员与普通职工） 服务实现类
 * </p>
 *
 * @author hjt
 * @since 2019-03-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
