package com.book.mybatis.mapper;

import com.book.mybatis.entity.SysRole;
import com.book.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 通过id查找用户 reslutmap
     *
     * @param id
     * @return
     */
    SysUser selectByIdMap(Long id);


    /**
     * 通过id查找用户 resluttype
     *
     * @param id
     * @return
     */
    SysUser selectByIdType(Long id);


    /**
     * 查询所有用户，返回用户list
     *
     * @return
     */
    List<SysUser> selectAll();


    /**
     * 查询所有用户，返回用户list
     *
     * @return
     */
    List<SysUser> selectAllCamel();

    /**
     * 根据用户id查找他的所有角色
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);


    /**
     * 根据用户id查找他的所有角色 并包含这个用户的用户表中的用户名和email
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserIdHavingUser(Long userId);


    /**
     * 插入用户 返回1代表成功1ge
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);


    /**
     * 插入用户 返回自增主键 返回1代表成功1
     *
     * @param sysUser
     * @return
     */
    int insertGetKey(SysUser sysUser);

    /**
     * 更新user
     *
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    int deleteById(Long id);

    //主键是唯一表示
    int deleteByUser(SysUser sysUser);

    /**
     * 根据用户id 和 是否可用找出该用户的角色列表
     *
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);

}
