package com.yidu.express_order.servicepjc;

import com.yidu.express_order.daopjc.Orders;

import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2021-04-15 11:23:41
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Orders queryById(Integer orderId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderId);


    /**
     *
     * 条件查询订单,并分页
     * map:
     *  orderState 订单状态
     *  addressName 地址收件人名字
     *  addressPhone 地址收件人联系电话
     *  beginTime 选则的订单时间段 开始时间
     *   endTime 选则的订单时间段  结束时间
     *  offset 页码
     *  limit 页面大小
     *
     */
    List<Orders> queryAllByLimitByWhere(HashMap<String,Object> map);

    /**
     * 查询带条件的总数据行数
     * @param map
     * @return
     */
    int selectOrderCount(HashMap<String,Object> map);


}