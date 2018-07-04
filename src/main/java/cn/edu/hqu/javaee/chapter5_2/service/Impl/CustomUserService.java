package cn.edu.hqu.javaee.chapter5_2.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.chapter5_2.entity.User;
import cn.edu.hqu.javaee.chapter5_2.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else if("locked".equals(user.getStatus())) { //被锁定，无法登录
            throw new LockedException("用户被锁定");
        }
        return user;
    }
}