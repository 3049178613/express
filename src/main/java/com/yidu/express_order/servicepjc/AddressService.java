package com.yidu.express_order.servicepjc;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.entity.PlaceAnOrderData;

import java.util.List;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2021-04-15 11:02:49
 */
public interface AddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    Address queryById(Integer addressId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param placeAnOrderData 下单数据对象
     * @return 实例对象
     */
    List<Address> insert(PlaceAnOrderData placeAnOrderData);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressId);

    /**
     * 根据名字模糊查询地址表数据
     * @param addressName 名字
     * @return
     */
    List<Address> selectAddressByLikeName(String addressName);

}