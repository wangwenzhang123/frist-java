package com.ai.ge.model.demo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jiangzd3
 * @version 1.0
 * @note
 * @since 2020/5/28 10:20 上午
 */
@Data
@Accessors( chain=true )
public class DemoTable {
    private Integer id;
    private String url;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
