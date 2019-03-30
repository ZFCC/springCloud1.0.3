package com.sn.springCloud103;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: RibbonConfig
 * Author:  18075555
 * Date: 2019/2/19 16:16.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
/*
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        // 负载均衡规则
//        return new MyRule();
        return  new RandomRule();
//        return new AvailabilityFilteringRule();
    }
}*/
