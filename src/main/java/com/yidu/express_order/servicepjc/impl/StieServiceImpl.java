package com.yidu.express_order.servicepjc.impl;

import com.yidu.express_order.daopjc.OrdersDao;
import com.yidu.express_order.entity.Address;
import com.yidu.express_order.entity.Orders;
import com.yidu.express_order.entity.Stie;
import com.yidu.express_order.daopjc.StieDao;
import com.yidu.express_order.servicepjc.StieService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stie)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 15:06:04
 */
@Service("stieService")
public class StieServiceImpl implements StieService {
    @Resource
    private StieDao stieDao;
    @Resource
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stieId 主键
     * @return 实例对象
     */
    @Override
    public Stie queryById(Integer stieId) {
        return this.stieDao.queryById(stieId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Stie> queryAllByLimit(int offset, int limit) {
        return this.stieDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param stie 实例对象
     * @return 实例对象
     */
    @Override
    public Stie insert(Stie stie) {
        this.stieDao.insert(stie);
        return stie;
    }

    /**
     * 修改数据
     *
     * @param stie 实例对象
     * @return 实例对象
     */
    @Override
    public Stie update(Stie stie) {
        this.stieDao.update(stie);
        return this.queryById(stie.getStieId());
    }

    /**
     * 通过主键删除数据
     *
     * @param stieId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stieId) {
        return this.stieDao.deleteById(stieId) > 0;
    }

    @Override
    public Integer selectStreetByAddress(String sendAddress, String senAddr) {
        //创建地址对象
        Address address=new Address();
        //分割客户寄件地址
        String[] split = sendAddress.split("/");
        //封装到地址对象  省 市 区
        address.setProvince(split[0]);
        address.setCity(split[1]);
        address.setDistrict(split[2]);
        //调用dao层根据寄货地址查询的详细地址方法
        List<Stie> street = this.stieDao.selectStreetByAddress(address);
        //申明变量存放网点id
        Integer stieId = 0;
        //循环该方法
        for (Stie sty : street) {
            //判断详细地址是否存在
            if (sty.getStieAddress().equals(senAddr)){
                //赋值网点id
                stieId=sty.getStieId();
            }
        }
        //网点是否等于0(等于代表不存在,不等于代表已经赋值已存在)
        if (stieId == 0){
            //调用dao层根据寄货地址查询的区级地址方法
            List<Stie> district = this.stieDao.selectDistrictByAddress(address);
            //循环该方法
            for (Stie stie : district) {
                //判断区级地址是否相等
                if (stie.getStieAddress().equals(address.getDistrict())) {
                    //返回网点id
                    return stie.getStieId();
                }
            }
        }else{
            //返回网点id
            return stieId;
        }
        return null;
    }


}