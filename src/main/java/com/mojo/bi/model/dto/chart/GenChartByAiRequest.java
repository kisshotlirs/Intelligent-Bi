package com.mojo.bi.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zyl
 * @description: 智能分析请求
 */
@Data
public class GenChartByAiRequest implements Serializable {

    private String name;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;
}
