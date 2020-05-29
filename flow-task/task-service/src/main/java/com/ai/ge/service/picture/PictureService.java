package com.ai.ge.service.picture;


import com.ai.ge.model.picture.Picture;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 图片表 服务类
 * </p>
 *
 * @author wangshen
 * @since 2020-05-28
 */
public interface PictureService extends IService<Picture> {
    Integer insert( String demo,int type);
    Picture getPictureById(int id);
    List<Picture> getList();
    List<Picture> getListType(int type);
}
