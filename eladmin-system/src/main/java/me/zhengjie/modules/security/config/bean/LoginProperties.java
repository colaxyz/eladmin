package me.zhengjie.modules.security.config.bean;

import lombok.Data;

@Data
public class LoginProperties {

    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    public boolean isCacheEnable() {
        return cacheEnable;
    }

}
