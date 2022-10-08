package com.phj233.dao;

import com.phj233.dao.impl.AdminInfoDaoImpl;
import com.phj233.pojo.AdminInfo;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * @author 未確認の庭師,phj233
 */
class AdminTest {

    //全查
    @Test
    void queryAdminInfoAll() {
        List<AdminInfo> list = new AdminInfoDaoImpl().queryAdminInfo(
                "select * from admininfo");
        list.forEach(System.out::println);
    }
    //条件查询
    @Test
    void queryAdminInfo() {
        List<AdminInfo> list = new AdminInfoDaoImpl().queryAdminInfo(
                "select * from admininfo where Aname like ?", "%j%");
        list.forEach(System.out::println);
    }

    @Test
    void addAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().addAdminInfo(new AdminInfo(){
            {
                setaId(12345);
                setaName("testAdmin");
                setaPwd("test");
                setaLevel("testLevel");
            }
        }));
    }

    @Test
    void updateAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().updateAdminInfo(new AdminInfo(){
            {
                setaId(12345);
                setaName("testAdmin2");
                setaPwd("test");
                setaLevel("testLevel");
            }
        }));
    }

    @Test
    void deleteAdminInfo() {
        System.out.println(new AdminInfoDaoImpl().deleteAdminInfo(12345));
    }
}