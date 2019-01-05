package com.snow.postgresql.module;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private TestService testService;

    @PostMapping("lookUsers")
    @ApiOperation(value = "查看用户列表")
    public ResponseEntity lookUsers(@ApiParam(value = "第几页",required = true)@RequestParam Integer page,
                                    @ApiParam(value = "多少条",required = true)@RequestParam Integer pagesize){
        return ResponseEntity.ok(testService.lookUsers(page,pagesize));
    }
    @PostMapping("addUser")
    @ApiOperation(value = "添加用户")
    public ResponseEntity addUser(@ApiParam(name = "username", value = "用户名", required = true)@RequestParam String username,
                                  @ApiParam(name = "password", value = "密码", required = true)@RequestParam String password,
                                  @ApiParam(name = "roleId", value = "角色ID",required = true)@RequestParam Long roleId){
        return ResponseEntity.ok(testService.addUser(username,password,roleId));
    }

    @PostMapping("lookRoles")
    @ApiOperation(value = "查看角色列表")
    public ResponseEntity lookRoles(@ApiParam(value = "第几页",required = true)@RequestParam Integer page,
                                    @ApiParam(value = "多少条",required = true)@RequestParam Integer pagesize){
        return ResponseEntity.ok(testService.lookRoles(page,pagesize));
    }
    @PostMapping("addRole")
    @ApiOperation(value = "添加角色信息")
    public ResponseEntity addRole(@ApiParam(value = "角色名称",required = true)@RequestParam String roleName){
        return ResponseEntity.ok(testService.addRole(roleName));
    }
    @PostMapping("deleteRole")
    @ApiOperation(value = "删除角色信息")
    public ResponseEntity deleteRole(@ApiParam(value = "角色ID",required = true)@RequestParam Long roleId){
        return ResponseEntity.ok(testService.deleteRole(roleId));
    }

    @PostMapping("userLookRoles")
    @ApiOperation(value = "查看用户角色列表")
    public ResponseEntity userLookRoles(@ApiParam(value = "用户ID",required = true)@RequestParam Long userId){
        return ResponseEntity.ok(testService.userLookRoles(userId));
    }
    @PostMapping("userAddRole")
    @ApiOperation(value = "添加用户角色")
    public ResponseEntity userAddRole(@ApiParam(value = "用户ID",required = true)@RequestParam Long userId,
                                      @ApiParam(value = "角色ID",required = true)@RequestParam String roleId){
        return ResponseEntity.ok(testService.userAddRole(userId,roleId));
    }
    @PostMapping("userDeleteRole")
    @ApiOperation(value = "删除用户角色")
    public ResponseEntity userDeleteRole(@ApiParam(value = "用户ID",required = true)@RequestParam Long userId,
                                         @ApiParam(value = "角色ID",required = true)@RequestParam Long roleId){
        return ResponseEntity.ok(testService.userDeleteRole(userId,roleId));
    }

    @PostMapping("lookAuthoritys")
    @ApiOperation(value = "查看权限列表")
    public ResponseEntity lookAuthoritys(@ApiParam(value = "第几页",required = true)@RequestParam Integer page,
                                         @ApiParam(value = "多少条",required = true)@RequestParam Integer pagesize){
        return ResponseEntity.ok(testService.lookAuthoritys(page,pagesize));
    }

    @PostMapping("roleLookAuthoritys")
    @ApiOperation(value = "查看角色权限列表")
    public ResponseEntity roleLookAuthoritys(@ApiParam(value = "角色ID",required = true)@RequestParam Long roleId){
        return ResponseEntity.ok(testService.roleLookAuthoritys(roleId));
    }
    @PostMapping("roleAddAuthority")
    @ApiOperation(value = "添加角色权限")
    public ResponseEntity roleAddAuthority(@ApiParam(value = "角色ID",required = true)@RequestParam Long roleId,
                                           @ApiParam(value = "权限ID",required = true)@RequestParam String authorityId){
        return ResponseEntity.ok(testService.roleAddAuthority(roleId,authorityId));
    }
    @PostMapping("roleDeleteAuthority")
    @ApiOperation(value = "删除角色权限")
    public ResponseEntity roleDeleteAuthority(@ApiParam(value = "角色ID",required = true)@RequestParam Long roleId,
                                              @ApiParam(value = "权限ID",required = true)@RequestParam String authorityId){
        return ResponseEntity.ok(testService.roleDeleteAuthority(roleId,authorityId));
    }




}
