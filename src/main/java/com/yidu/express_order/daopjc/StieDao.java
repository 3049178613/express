package com.yidu.express_order.daopjc;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.entity.Stie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Stie)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-27 15:06:03
 */
@Repository
@Mapper
public interface StieDao {

    /**
     * 通过ID查询单条数据
     *
     * @param stieId 主键
     * @return 实例对象
     */
    Stie queryById(Integer stieId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Stie> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param stie 实例对象
     * @return 对象列表
     */
    List<Stie> queryAll(Stie stie);

    /**
     * 新增数据
     *
     * @param stie 实例对象
     * @return 影响行数
     */
    int insert(Stie stie);

    /**
     * 修改数据
     *
     * @param stie 实例对象
     * @return 影响行数
     */
    int update(Stie stie);

    /**
     * 通过主键删除数据
     *
     * @param stieId 主键
     * @return 影响行数
     */
    int deleteById(Integer stieId);

    /**
     * 根据地址查询详细地址
     * @param address 地址
     * @return 返回网点集合
     */
    List<Stie> selectStreetByAddress(Address address);

    /**
     * 根据地址查询区级地址
     * @param address 地址
     * @return 返回网点集合
     */
    List<Stie> selectDistrictByAddress(Address address);
}