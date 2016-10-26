package com.ycx.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by 李小明 on 16/10/26.
 * 邮箱:287907160@qq.com
 */

@Entity
public class Person {

    @Id
    private Long id;

    @Transient   //临时数据,不做持久化存储
    private String sex;

    private int height;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1028483720)
    public Person(Long id, int height) {
        this.id = id;
        this.height = height;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }
}
