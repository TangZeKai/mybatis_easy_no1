package com.book.mybatis;

import com.book.mybatis.entity.SysRole;
import com.book.mybatis.entity.SysUser;
import com.book.mybatis.entity.SysUserRole;
import com.book.mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * sys_user 测试相关
 * 2017年12月12日22:01:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserTest {
    @Autowired
    private UserMapper userMapper;

    private static Long TEST_ID=1L;

    @Test
    public void testSelectByIdMap(){
       SysUser sysUser= userMapper.selectByIdMap(TEST_ID);
        Assert.assertNotNull(sysUser);
        System.out.println(sysUser.getId()+sysUser.getUserName());
        Assert.assertEquals("admin",sysUser.getUserName());
    }


    @Test
    public void testSelectByIdType(){
        SysUser sysUser= userMapper.selectByIdType(TEST_ID);
        Assert.assertNotNull(sysUser);
        Assert.assertEquals("admin",sysUser.getUserName());
        System.out.println(sysUser.getId()+sysUser.getUserName());
    }

    @Test
    public void testSelectAll(){
        List<SysUser> sysUsers=userMapper.selectAll();
        Assert.assertNotNull(sysUsers);
        Assert.assertTrue(sysUsers.size()>0);
        Iterator iterator=sysUsers.iterator();
        int i=0;
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
            i++;
        }
        System.out.println(i);
    }


    @Test
    public void testSelectAllCamel(){
        List<SysUser> sysUsers=userMapper.selectAllCamel();
        Assert.assertNotNull(sysUsers);
        Assert.assertTrue(sysUsers.size()>0);
        Iterator iterator=sysUsers.iterator();
        int i=0;
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
            i++;

        }
        System.out.println(i);

    }

    @Test
    public void testSelectRoleByUserId(){
        List<SysRole> sysRoles=userMapper.selectRolesByUserId(TEST_ID);
        Assert.assertNotNull(sysRoles);
        Assert.assertTrue(sysRoles.size()>0);
        Iterator iterator=sysRoles.iterator();
        int i=0;
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
            i++;
        }
        System.out.println(i);

    }

}


