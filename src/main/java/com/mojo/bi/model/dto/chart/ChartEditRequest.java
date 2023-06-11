package com.mojo.bi.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * 编辑请求
 
 */
@Data
public class ChartEditRequest implements Serializable {

    private Long id;

    private String name;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;

    private static final long serialVersionUID = 1L;
}