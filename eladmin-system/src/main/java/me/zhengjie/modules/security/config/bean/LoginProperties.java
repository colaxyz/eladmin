package me.zhengjie.modules.security.config.bean;

import lombok.Data;

@Data
public class LoginProperties {

    /**
     * 账号单用户 登录
     */
    private boolean singleLogin = false;

    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    public boolean isSingleLogin() {
        return singleLogin;
    }

    public boolean isCacheEnable() {
        return cacheEnable;
    }

}
