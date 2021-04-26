package com.yidu.express_order.controller;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.entity.Goods;
import com.yidu.express_order.daopjc.Orders;
import com.yidu.express_order.entity.PlaceAnOrderData;
import com.yidu.express_order.servicepjc.AddressService;
import com.yidu.express_order.servicepjc.GoodsService;
import com.yidu.express_order.servicepjc.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2021-04-15 11:23:41
 */
@Controller
@RequestMapping("orders")
public class OrdersController {
    /**
     * 订单服务对象
     */
    @Resource
    private OrdersService ordersService;
    /**
     * 地址服务对象
     */
    @Resource
    private AddressService addressService;
    /**
     * 包裹服务对象
     */
    @Resource
    private GoodsService goodsService;


    @ResponseBody
    @RequestMapping("pjcInsertOrders")
    public String pjcInsertOrders(PlaceAnOrderData placeAnOrderData) {
        //调用新增地址的方法
        List<Address> insertAddress = addressService.insert(placeAnOrderData);
        //创建订单是实体类
        Orders orders = new Orders();
        //循环刚刚新增的地址数据集合
        for (int i = 0; i < insertAddress.size(); i++) {
            Address address = insertAddress.get(i);
                //判断是否寄件地址
                if (address.getAddressState() == 1) {
                    //地址表 寄件人Id
                    orders.setAddressIdSender(address.getAddressId());
                } else {
                    //地址表 收件人Id
                    orders.setAddressIdDirection(address.getAddressId());
                }
        }
        //从session中获取下单用户的主键
        orders.setCustomerId(1);
        Random random=new Random();
        int i = random.nextInt(1000);
        int k = (random.nextInt(9)+1)*1000;
        String yyyyMM = new SimpleDateFormat("yyyyMM").format(new Date());
        //订单号
        orders.setOrdernumber(("KD"+yyyyMM+(i+k)));
        //订单支付方式
        orders.setPayWay(1);

        //调用新增订单的方法
        Orders insertOrder = ordersService.insert(orders);
        //创建包裹数据实体类
        Goods goods=new Goods();
         //物品类型
        goods.setGoodstype(placeAnOrderData.getGoodsType());
        //物品重量
        goods.setGoodsweight(placeAnOrderData.getGoodsWeight());
        //预估价格
        Integer predictPrice = placeAnOrderData.getPredictPrice();
        goods.setEstimateprice(predictPrice==null||predictPrice==0?8:predictPrice);
        //包裹数量
        goods.setNumber(1);
        //包裹状态
        goods.setGoodsState(1);
        //引用订单主键id
        goods.setOrderId(orders.getOrderId());
        //调用新增包裹的方法
        goodsService.insert(goods);
        //跳转下单成功的支付页面
        return "ok";
    }

    /**
     *
     * 条件查询订单,并分页
     * @param orderState 订单状态
     * @param addressName 地址收件人名字
     * @param addressPhone 地址收件人联系电话
     * @param beginTime 选则的订单时间段 开始时间
     * @param endTime 选则的订单时间段  结束时间
     * @param offset 页码
     * @return
     */
    @RequestMapping("pjcSelectAllOrder")
    public String pjcSelectAllOrder(HttpServletRequest request, Integer orderState, String addressName, String addressPhone, String beginTime, String endTime, Integer offset){
        HashMap<String,Object> map=new HashMap<>();
        map.put("customerId",1);//当前登录的客户主键id
        map.put("orderState",orderState);
        map.put("addressName",addressName);
        map.put("addressPhone",addressPhone);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        //判断如果当前页面参数等于null就赋值1
        Integer offsets = offset==null?1:offset;
        map.put("offset",(offsets-1)*10);//默认第1页
        map.put("limit",10);//默认10行
        //返回 调用ordersService层条件查询订单,并分页的方法
        List<Orders> ordersList = this.ordersService.queryAllByLimitByWhere(map);
        request.setAttribute("ordersList",ordersList);
        //创建集合 存入寄货地址数据
        List<Address> sendAddressList=new ArrayList<>();
        //创建集合 存入收货地址数据
        List<Address> recAddressList=new ArrayList<>();
        for (Orders orders : ordersList) {
            //调用根据订单表寄货地址id,查询地址对象
            Address sendAddress = this.addressService.queryById(orders.getAddressIdSender());
            sendAddressList.add(sendAddress);
            //调用根据订单表收货地址id,查询地址对象
            Address recAddress = this.addressService.queryById(orders.getAddressIdDirection());
            recAddressList.add(recAddress);
        }
        //将寄货地址数据集合存入请求作用域
        request.setAttribute("sendAddressList",sendAddressList);
        //将收货地址数据集合存入请求作用域
        request.setAttribute("recAddressList",recAddressList);
        //调用根据条件查询的数据总行数的方法
        int count = this.ordersService.selectOrderCount(map);
        //将总行数存入请求作用域
        request.setAttribute("count",count);
        //得到总页数
        int page=count/10;
        //判断最后一页还有没有余数
        if(count%10!=0){
            //总页数加一
            page++;
        }
        //将总页数存入请求作用域
        request.setAttribute("page",page);
        //将当前页面存入请求作用域
        request.setAttribute("offsets",offsets);

        //将搜索的名字存入请求作用域
        request.setAttribute("addressName",addressName==""||addressName==null?"w":addressName);
        //将搜索的手机号存入请求作用域
        request.setAttribute("addressPhone",addressPhone==""||addressPhone==null?"w":addressPhone);
        //将选中的订单状态存入请求作用域
        request.setAttribute("orderState",orderState==null?"10":orderState);
        return "sent";
    }
}