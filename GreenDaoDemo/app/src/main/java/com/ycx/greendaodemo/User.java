package com.ycx.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 李小明 on 16/10/26.
 * 邮箱:287907160@qq.com
 */


@Entity
public class User {
    @Id   //主鍵  自增長
    private String id;

    private String userName;


    private int age;

    @Transient     //临时数据,不做持久化
    private String tmpData;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Generated(hash = 584842837)
    public User(String id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }



}
