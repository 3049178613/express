package com.yidu.express_order.servicepjc.impl;

import com.yidu.express_order.entity.Orders;
import com.yidu.express_order.daopjc.OrdersDao;
import com.yidu.express_order.servicepjc.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2021-04-15 11:23:41
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer orderId) {
        return this.ordersDao.queryById(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit) {
        return this.ordersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        int insert = this.ordersDao.insert(orders);


        //调用查询刚刚新增订单的数据
        return ordersDao.justNewAddOrderId(1);
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderId) {
        return this.ordersDao.deleteById(orderId) > 0;
    }

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
    @Override
    public List<Orders> queryAllByLimitByWhere(HashMap<String,Object> map) {
        return this.ordersDao.queryAllByLimitByWhere(map);
    }

    @Override
    public int selectOrderCount(HashMap<String, Object> map) {
        return this.ordersDao.selectOrderCount(map);
    }
}