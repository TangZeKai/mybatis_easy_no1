package com.book.mybatis.mapper;

import com.book.mybatis.entity.SysRole;
import com.book.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 通过id查找用户 reslutmap
     * @param id
     * @return
     */
    SysUser selectByIdMap(Long id);

    /**
     * 通过id查找用户 resluttype
     * @param id
     * @return
     */
    SysUser selectByIdType(Long id);


    /**
     * 查询所有用户，返回用户list
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 查询所有用户，返回用户list
     * @return
     */
    List<SysUser> selectAllCamel();

    /**
     *根据用户id查找他的所有角色
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);



    /**
     * 插入用户 返回1代表成功
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 插入用户 返回自增主键
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);
}
