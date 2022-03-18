package com.kuaidixx.kuaidixx.service.impl;


import com.kuaidixx.kuaidixx.common.Const;
import com.kuaidixx.kuaidixx.common.responseCode;
import com.kuaidixx.kuaidixx.dao.userMapper;
import com.kuaidixx.kuaidixx.pojo.user;
import com.kuaidixx.kuaidixx.service.IUserService;
import com.kuaidixx.kuaidixx.utils.dateUtil;
import com.kuaidixx.kuaidixx.utils.serverResponse;
import com.kuaidixx.kuaidixx.vo.userVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends IUserService{
    @Autowired
    userMapper userMapper;
    @Override
    public serverResponse loginLogic(String username, String password) {
//    1.接收用户名密码

        if(StringUtils.isBlank(username)){
            return serverResponse.createServerResponseByFail(responseCode.USERNAME_NOT_EMPTY.getCode(),responseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if(StringUtils.isBlank(password)){
            return serverResponse.createServerResponseByFail(responseCode.PASSWORD_NOT_EMPTY.getCode(),responseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
//    2.判断用户名是否存在
        int count = userMapper.findByUsername(username);
        if(count==0){
            return serverResponse.createServerResponseByFail(responseCode.USERNAME_NOT_EXIST.getCode(),responseCode.USERNAME_NOT_EXIST.getMsg());
        }

//    3.根据用户名密码查询

        user user =userMapper.findByUsernameAndPassword(username,password);

        if(user==null){
            return serverResponse.createServerResponseByFail(responseCode.PASSWORD_ERROR.getCode(),responseCode.PASSWORD_ERROR.getMsg());
        }
//    4.返回登录结果

        return serverResponse.createServerResponseBySucccess(convert(user));
    }
    private userVo convert(user user){
        userVo uservo=new userVo();
        uservo.setId(user.getId());
        uservo.setUsername(user.getUsername());
        uservo.setEmail(user.getEmail());
        uservo.setPhone(user.getPhone());
        uservo.setCreateTime(dateUtil.Date2String(user.getCreateTime()));
        uservo.setUpdateTime(dateUtil.Date2String(user.getUpdateTime()));
        return uservo;
    }
    public serverResponse registerLogic(user user){
        //1.验证参数非空
        if(user==null){
            return serverResponse.createServerResponseByFail(responseCode.PARAMTER_NOT_EMPTY.getCode(),responseCode.PARAMTER_NOT_EMPTY.getMsg());
        }
        String username=user.getUsername();
        String password=user.getPassword();
        String phone=user.getPhone();
        String email=user.getEmail();
        if(StringUtils.isBlank(username)){
            return serverResponse.createServerResponseByFail(responseCode.USERNAME_NOT_EMPTY.getCode(),responseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if(StringUtils.isBlank(email)){
           return serverResponse.createServerResponseByFail(responseCode.EMAIL_NOT_EMPTY.getCode(),responseCode.EMAIL_NOT_EMPTY.getMsg());
       }
        if(StringUtils.isBlank(phone)){
           return serverResponse.createServerResponseByFail(responseCode.PHONE_NOT_EMPTY.getCode(),responseCode.PHONE_NOT_EMPTY.getMsg());
       }
        if(StringUtils.isBlank(password)){
            return serverResponse.createServerResponseByFail(responseCode.PASSWORD_NOT_EMPTY.getCode(),responseCode.PASSWORD_NOT_EMPTY.getMsg());
        }

//        2.判断用户名邮箱是否存在
        int result = userMapper.findByUsername(username);
        if(result > 0){
            return serverResponse.createServerResponseByFail(responseCode.USERNAME_EXIST.getCode(),responseCode.USERNAME_EXIST.getMsg());
        }
        int count = userMapper.findByPhone(phone);
        if(count > 0){
            return serverResponse.createServerResponseByFail(responseCode.PHONE_EXIST.getCode(),responseCode.PHONE_EXIST.getMsg());
        }
//        3.注册 MD5Utis.getMD5Code()
        user.setPassword(user.getPassword());
        user.setRole(Const.NOMAL_USER);//设置普通用户角色
        int result2=userMapper.insert(user);
        if(result2==0){
            return serverResponse.createServerResponseByFail(responseCode.REGISTER_FAIL.getCode(),responseCode.REGISTER_FAIL.getMsg());
        }
        return serverResponse.createServerResponseBySucccess();
    }
}
