package com.ai.ge.controller.picture;


import com.ai.ge.controller.BaseController;
import com.ai.ge.model.base.BaseEntity;
import com.ai.ge.model.picture.Picture;
import com.ai.ge.service.demo.DemoTableService;
import com.ai.ge.serviceimpl.picture.PictureServiceImpl;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import org.kohsuke.rngom.parse.host.Base;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
            return JSON.toJSONString(BaseEntity.success(null));
        }else {
            return JSON.toJSONString(BaseEntity.failure());
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
    @RequestMapping(value = "/getBannerList")
    public String getBannerList() {
        List <Picture> list=new ArrayList<>();
        list.add(new Picture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590985623286&di=be06323444b064b32e28f6440199530e&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F91529822720e0cf313d90a430146f21fbe09aa58.jpg",1));
        list.add(new Picture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590985683840&di=2bcd3ee7e956eaa908a9e0d8a2cda9f1&imgtype=0&src=http%3A%2F%2Fp3.ssl.cdn.btime.com%2Ft01ad8f098dda538b10.jpg%3Fsize%3D1047x592",2));
        list.add(new Picture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590985716718&di=f0700a1368db0af299c81f730a8b6c76&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201403%2F21%2F20140321005841_F8enR.jpeg",3));
        if (list ==  null){
            return JSON.toJSONString(BaseEntity.failure());
        }else {
            return JSON.toJSONString(BaseEntity.success(list));
        }
    }
    @ResponseBody
    @RequestMapping(value = "/getPictureTypeList")
    public String getPictureTypeList(int type) {
        PageHelper.startPage(1,10);
        List <Picture> list=pictureService.getListType(type);
        if (list ==  null){
            return JSON.toJSONString(BaseEntity.failure());
        }else {
            return JSON.toJSONString(BaseEntity.success(list));
        }
    }
}

