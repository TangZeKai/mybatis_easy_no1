package com.book.mybatis;

import com.book.mybatis.entity.SysRole;
import com.book.mybatis.entity.SysUser;
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

    private static Long TEST_ID = 127847L;

    @Test
    public void testSelectByIdMap() {
        SysUser sysUser = userMapper.selectByIdMap(TEST_ID);
        Assert.assertNotNull(sysUser);
        System.out.println(sysUser.getId() + sysUser.getUserName());
        Assert.assertEquals("admin", sysUser.getUserName());
    }


    @Test
    public void testSelectByIdType() {
        SysUser sysUser = userMapper.selectByIdType(TEST_ID);
        Assert.assertNotNull(sysUser);
        Assert.assertEquals("admin", sysUser.getUserName());
        System.out.println(sysUser.getId() + sysUser.getUserName());
    }

    @Test
    public void testSelectAll() {
        List<SysUser> sysUsers = userMapper.selectAll();
        Assert.assertNotNull(sysUsers);
        Assert.assertTrue(sysUsers.size() > 0);
        Iterator iterator = sysUsers.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            i++;
        }
        System.out.println(i);
    }


    @Test
    public void testSelectAllCamel() {
        List<SysUser> sysUsers = userMapper.selectAllCamel();
        Assert.assertNotNull(sysUsers);
        Assert.assertTrue(sysUsers.size() > 0);
        Iterator iterator = sysUsers.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            i++;

        }
        System.out.println(i);

    }

    @Test
    public void testSelectRoleByUserId() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserId(TEST_ID);
        Assert.assertNotNull(sysRoles);
        Assert.assertTrue(sysRoles.size() > 0);
        Iterator iterator = sysRoles.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            i++;
        }
        System.out.println(i);

    }

    @Test
    public void testSelectRoleByUserIdHavingUser() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserIdHavingUser(TEST_ID);
        Assert.assertNotNull(sysRoles);
        Assert.assertTrue(sysRoles.size() > 0);
        Iterator iterator = sysRoles.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void testInsertUser() {
        SysUser sysUser = new SysUser(
                "yonhu",
                "mima",
                "031@as.csd",
                "yonghuxingxi",
                new byte[1],
                new Date()
        );
        int ok = userMapper.insert(sysUser);
//       Assert.assertNotNull(sysUser.getId());//没有配置回写主键，也没用赋值 所以这个错误
        Assert.assertEquals(1, ok);//返回1代表成功
    }


    @Test
    public void testInsertUserGetKey() {
        SysUser sysUser = new SysUser(
                "yonhu",
                "mima",
                "031@as.csd",
                "yonghuxingxi",
                new byte[1],
                new Date()
        );
        int ok = userMapper.insertGetKey(sysUser);
        System.out.println(ok);
        Assert.assertNotNull(sysUser.getId());//配置回写主键，也没用赋值 所以这个ok
        Assert.assertEquals(1, ok);//返回1代表成功
        System.out.println(sysUser.getId());
    }

    @Test
    public void testUpdateById() {
        SysUser sysUser = new SysUser(
                127847L,
                "999sehgoiu",
                "sdfghdg",
                "031sfsdgsdg@as.csd",
                "yonghsdgdfguxingxi",
                new byte[1],
                new Date()
        );
        int ok = userMapper.updateById(sysUser);
        Assert.assertEquals(1, ok);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(TEST_ID);
        Assert.assertNull(userMapper.selectByIdMap(TEST_ID));
    }

    @Test
    public void testDeleteByUser() {
        SysUser sysUser = new SysUser(
                127846L);
        userMapper.deleteByUser(sysUser);
        Assert.assertNull(userMapper.selectByIdMap(TEST_ID));
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole.toString());
        }
    }
}


