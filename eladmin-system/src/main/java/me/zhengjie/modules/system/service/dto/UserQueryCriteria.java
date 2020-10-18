package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

import java.io.Serializable;

@Data
public class UserQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

}
