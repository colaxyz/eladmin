package me.zhengjie.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import me.zhengjie.modules.system.domain.Dept;
import me.zhengjie.modules.system.domain.Role;
import me.zhengjie.modules.system.domain.User;
import me.zhengjie.modules.system.service.dto.DeptSmallDto;
import me.zhengjie.modules.system.service.dto.RoleSmallDto;
import me.zhengjie.modules.system.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-10T21:51:15+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setCreateBy( dto.getCreateBy() );
        user.setCreateTime( dto.getCreateTime() );
        user.setId( dto.getId() );
        user.setRoles( roleSmallDtoSetToRoleSet( dto.getRoles() ) );
        user.setDept( deptSmallDtoToDept( dto.getDept() ) );
        user.setUsername( dto.getUsername() );
        user.setNickName( dto.getNickName() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setGender( dto.getGender() );
        user.setAvatarName( dto.getAvatarName() );
        user.setAvatarPath( dto.getAvatarPath() );
        user.setPassword( dto.getPassword() );
        user.setEnabled( dto.getEnabled() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setCreateBy( entity.getCreateBy() );
        userDto.setCreateTime( entity.getCreateTime() );
        userDto.setId( entity.getId() );
        userDto.setRoles( roleSetToRoleSmallDtoSet( entity.getRoles() ) );
        userDto.setDept( deptToDeptSmallDto( entity.getDept() ) );
        userDto.setUsername( entity.getUsername() );
        userDto.setNickName( entity.getNickName() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPhone( entity.getPhone() );
        userDto.setGender( entity.getGender() );
        userDto.setAvatarName( entity.getAvatarName() );
        userDto.setAvatarPath( entity.getAvatarPath() );
        userDto.setPassword( entity.getPassword() );
        userDto.setEnabled( entity.getEnabled() );

        return userDto;
    }

    @Override
    public List<User> toEntity(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    protected Role roleSmallDtoToRole(RoleSmallDto roleSmallDto) {
        if ( roleSmallDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleSmallDto.getId() );
        role.setRoleKey( roleSmallDto.getRoleKey() );

        return role;
    }

    protected Set<Role> roleSmallDtoSetToRoleSet(Set<RoleSmallDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleSmallDto roleSmallDto : set ) {
            set1.add( roleSmallDtoToRole( roleSmallDto ) );
        }

        return set1;
    }

    protected Dept deptSmallDtoToDept(DeptSmallDto deptSmallDto) {
        if ( deptSmallDto == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( deptSmallDto.getId() );
        dept.setName( deptSmallDto.getName() );

        return dept;
    }

    protected RoleSmallDto roleToRoleSmallDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleSmallDto roleSmallDto = new RoleSmallDto();

        roleSmallDto.setId( role.getId() );
        roleSmallDto.setRoleKey( role.getRoleKey() );

        return roleSmallDto;
    }

    protected Set<RoleSmallDto> roleSetToRoleSmallDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleSmallDto> set1 = new HashSet<RoleSmallDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleSmallDto( role ) );
        }

        return set1;
    }

    protected DeptSmallDto deptToDeptSmallDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptSmallDto deptSmallDto = new DeptSmallDto();

        deptSmallDto.setId( dept.getId() );
        deptSmallDto.setName( dept.getName() );

        return deptSmallDto;
    }
}
