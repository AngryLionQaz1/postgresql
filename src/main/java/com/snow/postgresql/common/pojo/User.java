package com.snow.postgresql.common.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@ApiModel("用户表")
@Table(catalog="public",name = "s_user",uniqueConstraints = {@UniqueConstraint(columnNames = "username")},indexes = {@Index(columnList = "username")})
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "身份证号码")
    private String idCard;
    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "角色列表")
    @ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
    @JoinTable(joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    @JSONField
    private List<Role> roles=new ArrayList<>();

    @Transient
    private String token;

}