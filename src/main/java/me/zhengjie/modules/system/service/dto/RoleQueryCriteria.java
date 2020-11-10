package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

@Data
public class RoleQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

}
