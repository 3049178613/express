package com.yidu.express_order.servicepjc;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.entity.Stie;
import java.util.List;

/**
 * (Stie)表服务接口
 *
 * @author makejava
 * @since 2021-04-27 15:06:04
 */
public interface StieService {

    /**
     * 通过ID查询单条数据
     *
     * @param stieId 主键
     * @return 实例对象
     */
    Stie queryById(Integer stieId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Stie> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param stie 实例对象
     * @return 实例对象
     */
    Stie insert(Stie stie);

    /**
     * 修改数据
     *
     * @param stie 实例对象
     * @return 实例对象
     */
    Stie update(Stie stie);

    /**
     * 通过主键删除数据
     *
     * @param stieId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer stieId);

    /**
     * 根据地址查询详细地址,并判断用户的寄件地址是否存在
     * @param sendAddress 寄货地址
     * @param senAddr 寄货详细地址
     * @return 返回网点Id
     */
    Integer selectStreetByAddress(String sendAddress,String senAddr);

}