package com.ai.ge.mapper.common;

import java.time.LocalDateTime;

public interface CommonMapper {

    /**
     * 获取系统时间
     * @return
     */
    LocalDateTime getSysTime();
}
