package com.snow.postgresql.common.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(catalog="public", name="user")
public class UserPo implements Serializable {  //序列化在Jpa需要
    // @Id是用来标识主键的，而@GeneratedValue则是用来指定主键策略的
    @Id
    @GeneratedValue
    private String name;

    // @Column(name = "count", nullable = false)
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
