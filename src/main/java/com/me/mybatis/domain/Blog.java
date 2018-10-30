package com.me.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author OuyangJie
 * @Date 2018/10/29 13:56
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int id;

    private String name;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
