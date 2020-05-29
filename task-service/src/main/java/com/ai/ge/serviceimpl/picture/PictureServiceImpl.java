package com.ai.ge.serviceimpl.picture;

;
import com.ai.ge.mapper.demo.DemoTableMapper;
import com.ai.ge.mapper.picture.PictureMapper;
import com.ai.ge.model.picture.Picture;
import com.ai.ge.service.picture.PictureService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author wangshen
 * @since 2020-05-28
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
    @Resource
    private PictureMapper pictureMapper;

    @Override
    public Integer insert( String demo, int type) {
        Picture picture=new Picture();
        picture.setUrl(demo);
        picture.setType(type);
        return pictureMapper.insert(picture);
    }

    @Override
    public Picture getPictureById(int id) {
        return pictureMapper.selectById(id);
    }

    @Override
    public List<Picture> getList() {
        return pictureMapper.selectList(new Wrapper<Picture>() {
            @Override
            public Picture getEntity() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        });
    }

    @Override
    public List<Picture> getListType(int type) {
        Map<String,Object> map=new HashMap<>();
        map.put("type",type);
        return pictureMapper.selectByMap(map);
    }
}
