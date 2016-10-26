package com.ycx.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wyk.greendaodemo.greendao.gen.DaoMaster;
import com.wyk.greendaodemo.greendao.gen.DaoSession;
import com.wyk.greendaodemo.greendao.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();


        //插入数据
        User user1 = new User();
        user1.setUserName("TOM");
        user1.setAge(20);
        user1.setId("000000000002");

        userDao.insert(user1);

        User user = new User();
        user.setUserName("lxm");
        user.setAge(10);
        user.setId("000000000001");

        userDao.insert(user);

        //修改數據
        User findUser = userDao.queryBuilder().where(UserDao.Properties.UserName.eq("lxm")).build().unique();
        if(findUser != null) {
            findUser.setUserName("newLxm");
            userDao.update(findUser);
           Log.i("lxm","修改成功");
        } else {
           Log.i("lxm","用戶不存在");

        }
        //查询数据
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Id.notEq(000000000001))
                .orderAsc(UserDao.Properties.Id)
                .limit(5)
                .build().list();
        Log.i("lxm", "size = " + userList.size() + "......." + userList.get(0).getUserName());
        
        //刪除數據

        User deleteUser = userDao.queryBuilder().where(UserDao.Properties.UserName.eq("TOM")).build().unique();
        if(deleteUser != null){
            userDao.deleteByKey(deleteUser.getId());
        }
        Log.i("lxm", "size = " + userList.size() + "......." + userList.get(0).getUserName());

    }
}
