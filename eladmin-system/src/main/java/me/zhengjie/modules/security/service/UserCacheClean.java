package me.zhengjie.modules.security.service;

import me.zhengjie.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author: liaojinlong
 * @date: 2020/6/11 18:01
 * @apiNote: 用于清理 用户登录信息缓存
 */
@Component
public class UserCacheClean {

    /**
     * 清理特定用户缓存信息<br>
     * 用户信息变更时
     *
     * @param userName /
     */
    public void cleanUserCache(String userName) {
        if (StringUtils.isNotEmpty(userName)) {
            UserDetailsServiceImpl.userDtoCache.remove(userName);
        }
    }

}
