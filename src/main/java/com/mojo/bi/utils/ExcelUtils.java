package com.mojo.bi.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.mojo.bi.common.ErrorCode;
import com.mojo.bi.exception.ThrowUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zyl
 * @description: Excel工具类
 */
@Slf4j
public class ExcelUtils {

    public static void main(String[] args)  {
        ExcelUtils.excel2Csv(null);
    }

    private static String excel2Csv(MultipartFile multipartFile) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:data.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Map<Integer, String>> list = EasyExcel.read(file)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .headRowNumber(0)
                .doReadSync();
        ThrowUtils.throwIf(CollUtil.isEmpty(list), ErrorCode.NOT_FOUND_ERROR, "Excel为空");
        //读取表头
        LinkedHashMap<Integer, String> headerMap = (LinkedHashMap<Integer, String>) list.get(0);
        List<String> headerList = headerMap.values().stream().filter(ObjUtil::isNotEmpty).collect(Collectors.toList());
        log.info(StringUtils.join(headerMap.values(), ","));
        //读取数据
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap<Integer, String>) list.get(i);
            log.info(StringUtils.join(dataMap.values(), ","));
        }
        return null;
    }
}
