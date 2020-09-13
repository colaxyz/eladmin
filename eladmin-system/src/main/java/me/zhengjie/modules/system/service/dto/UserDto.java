package me.zhengjie.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserDto extends BaseDTO implements Serializable {

    private Long id;

    private Set<RoleSmallDto> roles;

    private DeptSmallDto dept;

    private Long deptId;

    private String username;

    private String nickName;

    private String email;

    private String phone;

    private String gender;

    private String avatarName;

    private String avatarPath;

    @JsonIgnore
    private String password;

    private Boolean enabled;

}
