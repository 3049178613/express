package com.yidu.express_order.servicepjc.impl;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.daopjc.AddressDao;
import com.yidu.express_order.entity.PlaceAnOrderData;
import com.yidu.express_order.servicepjc.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2021-04-15 11:02:49
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer addressId) {
        return this.addressDao.queryById(addressId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Address> queryAllByLimit(int offset, int limit) {
        return this.addressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param placeAnOrderData 下单数据对象
     * @return 实例对象
     */
    @Override
    public List<Address> insert(PlaceAnOrderData placeAnOrderData) {
        //查询几条新增数据
        int size=0;
        Address addressById=null;
        Address addressByIds=null;
        //调用赋值地址的方法
        Address address = this.addAddress(placeAnOrderData, "send");
        //检查地址对象数据是否已经存在的方法
        Integer addressId = this.showAddressExists(address);
        //判断地址主键等于null
        if(addressId==null){
            //调用dao层新增收件地址的方法
            this.addressDao.insert(address);
            size=+1;
        }else{
            //调用dao层根据id主键查询address数据
             addressById = this.addressDao.queryById(addressId);
            //将地址状态修改
            addressById.setAddressState(1);
        }
        //调用赋值地址的方法
        Address addresss = this.addAddress(placeAnOrderData, "rec");
        //检查地址对象数据是否已经存在的方法
        Integer addressIds = this.showAddressExists(addresss);
        //判断地址主键等于null
        if (addressIds==null){
            //调用dao层新增收件地址的方法
            this.addressDao.insert(addresss);
            size=+1;
        }else {
            //调用dao层根据id主键查询address数据
             addressByIds = this.addressDao.queryById(addressIds);
             //将地址状态修改
            addressByIds.setAddressState(2);
        }
        //返回调用查询刚刚新增的数据Id
        List<Address> addressList = this.addressDao.justNewAddAddressId(size, 1);
        //判断根据id查询的对象不为空
        if(addressById!=null){
            addressList.add(addressById);
            //调用修改时间的方法
            this.updateAddressTime(addressById.getAddressId());
        }
        //判断根据id查询的对象不为空
        if(addressByIds!=null){
            addressList.add(addressByIds);
            //调用修改时间的方法
            this.updateAddressTime(addressByIds.getAddressId());
        }
        return addressList; //session取客户id
    }

    /**
     * 将使用的地址时间改成最新使用的时间
     * @param addressId
     */
    public void updateAddressTime(Integer addressId){
        Address addre=new Address();
        addre.setAddressId(addressId);
        addre.setAddressTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //调用dao层修改方法
        this.addressDao.update(addre);
    }
    /**
     * 分割地址并封装到对象
     * @param place
     * @param sendOrRec
     * @return
     */
    public Address checkAddress(PlaceAnOrderData place,String sendOrRec){
        //创建地址对象
        Address address=new Address();
        //申明数组
        String [] addressArray=null;
        //判断是寄货地址还是收货地址
        if(sendOrRec.equals("send")){
            //将在寄货地址字符分割成功数组
            addressArray=place.getSendAddress().split("/");
        }else{
            //将在收货地址字符分割成功数组
            addressArray=place.getRecAddress().split("/");
        }
        //循环地址字符分割的数组,并将数组数据封装到地址对象中
        for (int i = 0; i < addressArray.length; i++) {
            switch (i){
                case 0:
                    address.setProvince(addressArray[i]);
                    break;
                case 1:
                    address.setCity(addressArray[i]);
                    break;
                case 2:
                    address.setDistrict(addressArray[i]);
                    break;
            }
        }
        //返回地址对象
        return address;
    }

    /**
     * 赋值地址
     * @param placeAnOrderData
     * @param sendOrRec
     * @return
     */
    public Address addAddress(PlaceAnOrderData placeAnOrderData,String sendOrRec){
        //创建地址对象
        Address address=new Address();
        address.setCustomerId(1);//从session中获取当前下单用户的id
        //判断是寄货地址信息还是收货地址信息
        if(sendOrRec.equals("send")) {
            address.setAddressState(1);//寄件地址类型
            address.setAddressName(placeAnOrderData.getSendName());//发货人名
            address.setAddressPhone(placeAnOrderData.getSendMobile());//发货人联系电话
            address.setStreet(placeAnOrderData.getSendAddr());//详细地址
        }else {
            address.setAddressState(2);//寄件地址类型
            address.setAddressName(placeAnOrderData.getRecName());//收货人名
            address.setAddressPhone(placeAnOrderData.getRecMobile());//收货人联系电话
            address.setStreet(placeAnOrderData.getRecAddr());//详细地址
        }
        //调用分割地址并封装到对象的方法
        Address addressAll = this.checkAddress(placeAnOrderData, sendOrRec);
        address.setDistrict(addressAll.getDistrict());//区
        address.setCity(addressAll.getCity());//市
        address.setProvince(addressAll.getProvince());//省
        address.setState(1);//状态
        return address;
    }

    /**
     * 检查地址对象数据是否已经存在，存在返回主键，不存在返回null
     * @param addr
     * @return
     */
    public Integer showAddressExists(Address addr){
        Integer addressId=null;
        List<Address> addresses = this.addressDao.queryAll(null);
        for (Address address : addresses) {
            if (address.getCustomerId()==addr.getCustomerId()) {
                if (address.getAddressName().equals(addr.getAddressName())
                        && address.getAddressPhone().equals(addr.getAddressPhone())
                        && address.getProvince().equals(addr.getProvince())
                        && address.getCity().equals(addr.getCity())
                        && address.getDistrict().equals(addr.getDistrict())
                        && address.getStreet().equals(addr.getStreet()) ){
                    addressId = address.getAddressId();
                }
            }
        }
        return addressId;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.queryById(address.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressId) {
        return this.addressDao.deleteById(addressId) > 0;
    }

    /**
     * 根据名字模糊查询地址表数据
     * @param addressName 名字
     * @return
     */
    @Override
    public List<Address> selectAddressByLikeName(String addressName) {
        return this.addressDao.selectAddressByLikeName(addressName,1);
    }
}