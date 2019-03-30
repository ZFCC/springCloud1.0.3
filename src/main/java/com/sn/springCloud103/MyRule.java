package com.sn.springCloud103;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: MyRule
 * Author:  18075555
 * Date: 2019/2/19 16:42.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
public class MyRule implements IRule {

    private ILoadBalancer lb;

    //自定义策略 命中8080的概率是20%  命中8081的概率是80%
    @Override
    public Server choose(Object o) {

        Random random = new Random();
        Integer num = random.nextInt(10);//在0-9这10个随机数里取值
        System.out.print("这是自定义的规则:num="+num);
        //获取传输负载均衡器里所有的服务
        List<Server> servers = lb.getAllServers();
        if(num>7){//返回8080端口服务
            return chooseServerByPort(servers,8080);
        }
        //返回8081端口服务
        return chooseServerByPort(servers,8081);

    }
    private Server chooseServerByPort(List<Server> servers,Integer port){
        for (Server server : servers) {
            if(server.getPort() == port){
                return server;
            }
        }
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
