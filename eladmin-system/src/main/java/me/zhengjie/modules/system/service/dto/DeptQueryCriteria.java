package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

@Data
public class DeptQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query
    private Long pid;

    @Query(type = Query.Type.IS_NULL, propName = "pid")
    private Boolean pidIsNull;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}