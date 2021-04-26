package com.yidu.express_order.daopjc;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-15 11:23:41
 */
@Mapper
@Repository
public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Orders queryById(Integer orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderId);

    /**
     * 找寻刚刚新增的订单数据
     * @param size 数量
     * @return
     */
    Orders justNewAddOrderId(Integer size);

    /**
     * 条件查询订单,并分页
     * @param map
     * @return
     */
    List<Orders> queryAllByLimitByWhere(HashMap<String,Object> map);

    /**
     * 查询带条件的总数据行数
     * @param map
     * @return
     */
    int selectOrderCount(HashMap<String,Object> map);
}