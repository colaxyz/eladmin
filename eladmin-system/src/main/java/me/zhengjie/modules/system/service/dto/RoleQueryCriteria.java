package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

@Data
public class RoleQueryCriteria {

    @Query(blurry = "name")
    private String blurry;

}
