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
@ApiModel("权限表")
@Table(catalog="public",name = "s_authority")
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "权限名")
    private String name;
    @ApiModelProperty(value = "权限uri")
    private String uri;
    @ApiModelProperty(value = "详细描述")
    private String details;
    @ManyToMany(cascade=CascadeType.REFRESH,mappedBy="authorities",fetch = FetchType.EAGER)
    @JSONField(serialize = false)
    private List<Role> roles;











}

