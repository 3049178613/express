package com.yidu.express_order.controller;

import com.yidu.express_order.entity.Stie;
import com.yidu.express_order.servicepjc.StieService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Stie)表控制层
 *
 * @author makejava
 * @since 2021-04-27 15:06:05
 */
@RestController
@RequestMapping("stie")
public class StieController {
    /**
     * 服务对象
     */
    @Resource
    private StieService stieService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stie selectOne(Integer id) {
        return this.stieService.queryById(id);
    }

}