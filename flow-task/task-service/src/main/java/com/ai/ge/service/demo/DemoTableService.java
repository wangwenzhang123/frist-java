package com.ai.ge.service.demo;

import com.ai.ge.model.demo.DemoTable;

import java.time.temporal.TemporalAccessor;
import java.util.List;

/**
 * @author jiangzd3
 * @version 1.0
 * @note
 * @since 2020/5/28 10:22 上午
 */

public interface DemoTableService {
    Integer insert(int i, String demo,int type);

    Integer deleteById(Integer id);

    DemoTable qryOneById(Integer id);

    List<DemoTable> qryListByName(String name);
}
