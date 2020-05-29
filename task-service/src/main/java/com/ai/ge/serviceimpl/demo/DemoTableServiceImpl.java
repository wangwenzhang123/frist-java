package com.ai.ge.serviceimpl.demo;

import com.ai.ge.mapper.demo.DemoTableMapper;
import com.ai.ge.model.demo.DemoTable;
import com.ai.ge.service.demo.DemoTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiangzd3
 * @version 1.0
 * @note
 * @since 2020/5/28 10:22 上午
 */
@Service
public class DemoTableServiceImpl implements DemoTableService {

    @Resource
    private DemoTableMapper demoTableMapper;

    @Override
    public Integer insert(int i, String demo,int type) {
        DemoTable demoTable = new DemoTable();
        demoTable.setId(i);
        demoTable.setUrl(demo);
        demoTable.setType(type);
        return demoTableMapper.insert(demoTable);
    }

    @Override
    public Integer deleteById(Integer id) {
        return demoTableMapper.deleteById(id);
    }

    @Override
    public DemoTable qryOneById(Integer id) {
        return demoTableMapper.selectById(id);
    }

    @Override
    public List<DemoTable> qryListByName(String name) {
        QueryWrapper query = new QueryWrapper<DemoTable>();
        query.like("name",name);
        return demoTableMapper.selectList(query);
    }
}
