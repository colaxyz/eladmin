package me.zhengjie.utils;

import org.springframework.data.domain.Page;
import java.util.*;

/**
 * 分页工具
 */
public class PageUtil extends cn.hutool.core.util.PageUtil {

    /**
     * Page 数据处理，预防redis反序列化报错
     */
    public static Map<String,Object> toPage(Page page) {
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",page.getContent());
        map.put("totalElements",page.getTotalElements());
        return map;
    }

    /**
     * 自定义分页
     */
    public static Map<String,Object> toPage(Object object) {
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",object);
        return map;
    }

}
