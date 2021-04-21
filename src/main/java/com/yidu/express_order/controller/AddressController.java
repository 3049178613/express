package com.yidu.express_order.controller;

import com.yidu.express_order.entity.Address;
import com.yidu.express_order.servicepjc.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：
 * @author：彭杰成
 * @date：2021/4/16 0016上午 9:57
 * @version：1.0
 */
@Controller
@RequestMapping("address")
public class AddressController {
    /**
     * 地址服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 查询地址簿
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("pjcSelectDirectoryInquiries")
    public List<Address> pjcSelectDirectoryInquiries(String name){
        return this.addressService.selectAddressByLikeName(name);
    }
}
