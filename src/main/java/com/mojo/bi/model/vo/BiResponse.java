package com.mojo.bi.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zyl
 * @description: Bi返回结果
 */
@Data
public class BiResponse implements Serializable {

    private String genChart;

    private String genResult;
}
