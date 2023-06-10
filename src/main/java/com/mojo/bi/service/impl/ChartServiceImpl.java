package com.mojo.bi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojo.bi.model.entity.Chart;
import com.mojo.bi.service.ChartService;
import com.mojo.bi.mapper.ChartMapper;
import org.springframework.stereotype.Service;

/**
* @author megalink
* @description 针对表【chart(图表信息表)】的数据库操作Service实现
* @createDate 2023-06-09 21:40:04
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

}




