package com.snow.postgresql.common.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@Entity
@Data
@ApiModel("角色表")
@Table(catalog="public",name = "s_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ManyToMany(targetEntity = User.class,mappedBy = "roles")
    @JSONField(serialize = false)
    private List<User> users;

    @ManyToMany(cascade=CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(inverseJoinColumns=@JoinColumn(name="authority_id"),joinColumns=@JoinColumn(name="role_id"))
    @JSONField
    private List<Authority> authorities;






}
