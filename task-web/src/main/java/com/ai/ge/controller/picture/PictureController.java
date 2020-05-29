package com.ai.ge.controller.picture;


import com.ai.ge.controller.BaseController;
import com.ai.ge.model.base.BaseEntity;
import com.ai.ge.model.picture.Picture;
import com.ai.ge.service.demo.DemoTableService;
import com.ai.ge.serviceimpl.picture.PictureServiceImpl;
import com.alibaba.fastjson.JSON;
import org.kohsuke.rngom.parse.host.Base;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 图片表 前端控制器
 * </p>
 *
 * @author wangshen
 * @since 2020-05-28
 */
@Controller
@RequestMapping("/picture")
public class PictureController extends BaseController {
    @Resource
    private PictureServiceImpl pictureService;
    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "hello picture!";
    }
    @ResponseBody
    @RequestMapping(value = "/insertPicture")
    public String insertPicture(  String url,  Integer type) {
        int code=pictureService.insert(url,type);
        if (code == 1){
            return JSON.toJSONString(BaseEntity.failure());
        }else {
            return JSON.toJSONString(BaseEntity.success(null));
        }
    }
    @ResponseBody
    @RequestMapping(value = "/getPictureById")
    public String getPictureById( Integer id) {
        return String.valueOf(pictureService.getPictureById(id).getUrl());
    }
    @ResponseBody
    @RequestMapping(value = "/getPictureList")
    public String getPictureList() {
        List <Picture> list=pictureService.getList();
        if (list ==  null){
            return JSON.toJSONString(BaseEntity.failure());
        }else {
            return JSON.toJSONString(BaseEntity.success(list));
        }
    }
    @ResponseBody
    @RequestMapping(value = "/getPictureTypeList")
    public String getPictureTypeList(int type) {
        List <Picture> list=pictureService.getListType(type);
        if (list ==  null){
            return JSON.toJSONString(BaseEntity.failure());
        }else {
            return JSON.toJSONString(BaseEntity.success(list));
        }
    }
}

