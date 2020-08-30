package me.zhengjie.modules.security.service;

import me.zhengjie.utils.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserCacheClean {

    /**
     * 清理特定用户缓存信息
     */
    public void cleanUserCache(String userName) {
        if (StringUtils.isNotEmpty(userName)) {
            UserDetailsServiceImpl.userDtoCache.remove(userName);
        }
    }

}
