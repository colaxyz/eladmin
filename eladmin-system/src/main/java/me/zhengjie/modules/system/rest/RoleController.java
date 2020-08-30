package me.zhengjie.modules.system.rest;

import lombok.RequiredArgsConstructor;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.system.domain.Role;
import me.zhengjie.modules.system.service.RoleService;
import me.zhengjie.modules.system.service.dto.RoleDto;
import me.zhengjie.modules.system.service.dto.RoleQueryCriteria;
import me.zhengjie.modules.system.service.dto.RoleSmallDto;
import me.zhengjie.utils.SecurityUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    private static final String ENTITY_NAME = "role";

    @GetMapping(value = "/{id}")
    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> query(@PathVariable Long id){
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    @PreAuthorize("@el.check('roles:list','user:add','user:edit')")
    public ResponseEntity<Object> query(){
        return new ResponseEntity<>(roleService.queryAll(),HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> query(RoleQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(roleService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("@el.check('roles:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Role resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        roleService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("@el.check('roles:edit')")
    public ResponseEntity<Object> update(@Validated(Role.Update.class) @RequestBody Role resources){
        roleService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/menu")
    @PreAuthorize("@el.check('roles:edit')")
    public ResponseEntity<Object> updateMenu(@RequestBody Role resources){
        RoleDto role = roleService.findById(resources.getId());
        roleService.updateMenu(resources,role);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @PreAuthorize("@el.check('roles:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        // 验证是否被用户关联
        roleService.verification(ids);
        roleService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
