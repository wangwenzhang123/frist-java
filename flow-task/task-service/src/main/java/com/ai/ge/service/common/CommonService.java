package com.ai.ge.service.common;

import com.ai.ge.mapper.common.CommonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author jiangzd3
 * @version 1.0
 * @note
 * @since 2020/5/28 9:37 上午
 */
@Service
public class CommonService {
    @Resource
    private CommonMapper commonMapper;

    public LocalDateTime getSysTime() {
        return commonMapper.getSysTime();
    }
}
