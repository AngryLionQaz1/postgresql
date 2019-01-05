package com.snow.postgresql.module;

import com.snow.postgresql.common.bean.Result;
import com.snow.postgresql.common.bean.Tips;
import com.snow.postgresql.common.pojo.Authority;
import com.snow.postgresql.common.pojo.Role;
import com.snow.postgresql.common.pojo.User;
import com.snow.postgresql.common.repository.AuthorityRepository;
import com.snow.postgresql.common.repository.RoleRepository;
import com.snow.postgresql.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {


    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    public Result lookUsers(Integer page, Integer pagesize) {
        if(page > 0)page--;
        Page<User> users = userRepository.findAll(PageRequest.of(page,pagesize));
        return Result.success(users);
    }
    public Result addUser(String username, String password, Long roleId) {
        Optional<User> o=userRepository.findByUsername(username);
        if (o.isPresent())return Result.fail(Tips.USER_HAD.msg);
        Optional<Role> or=roleRepository.findById(roleId);
        if (!or.isPresent())return Result.fail(Tips.ROLE_NOT.msg);
        return Result.success(userRepository.save(User.builder().username(username).password(password).roles(Arrays.asList(or.get())).build()));
    }
    public Result lookAuthoritys(Integer page, Integer pagesize) {
        if(page > 0)page--;
        Page<Authority> authorities = authorityRepository.findAll(PageRequest.of(page,pagesize));
        return Result.success(authorities);
    }

    public Result roleLookAuthoritys(Long roleId) {
        Optional<Role> r=roleRepository.findById(roleId);
        if (!r.isPresent())return Result.fail(Tips.ID_NOT.msg);
        Role role=r.get();
        List<Authority> authoritys=role.getAuthorities();
        return Result.success(authoritys);
    }
    public Result lookRoles(Integer page, Integer pagesize) {
        if(page > 0)page--;
        Page<Role> roles = roleRepository.findAll(PageRequest.of(page,pagesize));
        return Result.success(roles);
    }
    public Result userLookRoles(Long userId) {
        Optional<User> u=userRepository.findById(userId);
        if (!u.isPresent())return Result.fail(Tips.ID_NOT.msg);
        User user=u.get();
        List<Role> roles=user.getRoles();
        HashSet h = new HashSet(roles);
        roles.clear();
        roles.addAll(h);
        return Result.success(roles);
    }
    public Result userAddRole(Long userId, String roleId) {
        Optional<User> r=userRepository.findById(userId);
        if (!r.isPresent())return Result.fail(Tips.ID_NOT.msg);
        User user=r.get();
        List<Role> roles=user.getRoles();
        HashSet h = new HashSet(roles);
        roles.clear();
        roles.addAll(h);
        String[] str = roleId.split(",");
        for(String s:str){
            Optional<Role> o=roleRepository.findById(Long.valueOf(s));
            if (!o.isPresent())return Result.fail(Tips.ID_NOT.msg);
            roles.add(o.get());
        }
        user.setRoles(roles);
        return Result.success(userRepository.save(user));
    }
    public Result addRole(String roleName){
        Role role = Role.builder().name(roleName).build();
        return Result.success(roleRepository.save(role));
    }
    public Result deleteRole(Long roleId){
        Optional<Role> optional = roleRepository.findById(roleId);
        if(!optional.isPresent())return Result.fail(Tips.ID_NOT.msg);
        Role role = optional.get();
        List<Authority> authorities = role.getAuthorities();
        authorities.clear();
        role.setAuthorities(authorities);
        List<User> users = role.getUsers();
        for(User user:users){
            List<Role> roles = user.getRoles();
            roles.clear();
            user.setRoles(roles);
            userRepository.save(user);
        }
        roleRepository.save(role);
        roleRepository.deleteById(roleId);
        return Result.success();
    }
    public Result userDeleteRole(Long userId, Long roleId){
        Optional<User> r=userRepository.findById(userId);
        if (!r.isPresent())return Result.fail(Tips.ID_NOT.msg);
        User user=r.get();
        List<Role> roles=user.getRoles();
        HashSet h = new HashSet(roles);
        roles.clear();
        roles.addAll(h);
        Iterator<Role> iter = roles.iterator();
        while (iter.hasNext()){
            Role role = iter.next();
            if(role.getId() == roleId){
                iter.remove();
            }
        }
        user.setRoles(roles);
        return Result.success(userRepository.save(user));
    }

    public Result roleAddAuthority(Long roleId, String authorityId) {
        Optional<Role> o = roleRepository.findById(roleId);
        if (!o.isPresent())return Result.fail(Tips.ID_NOT.msg);
        Role role=o.get();
        List<Authority> authoritys = role.getAuthorities();
        String[] str = authorityId.split(",");
        for (String s:str){
            Optional<Authority> r = authorityRepository.findById(Long.valueOf(s));
            if (!o.isPresent())return Result.fail(Tips.ID_NOT.msg);
            authoritys.add(r.get());
        }
        role.setAuthorities(authoritys);
        return Result.success(roleRepository.save(role));
    }
    public Result roleDeleteAuthority(Long roleId, String authorityId){
        Optional<Role> r=roleRepository.findById(roleId);
        if (!r.isPresent())return Result.fail(Tips.ID_NOT.msg);
        Role role=r.get();
        String[] str = authorityId.split(",");
        for(String s:str){
            List<Authority> authoritys=role.getAuthorities();
            Iterator<Authority> iter = authoritys.iterator();
            while (iter.hasNext()){
                Authority authority = iter.next();
                if(authority.getId() == Long.valueOf(s)){
                    iter.remove();
                }
            }
            role.setAuthorities(authoritys);
        }
        return Result.success(roleRepository.save(role));
    }


}
