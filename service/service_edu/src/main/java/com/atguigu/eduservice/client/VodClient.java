package com.atguigu.eduservice.client;

import com.atguigu.commonutils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("service-vod")
public interface VodClient {

    //VodController中的方法，需要补全完全路径, 注解中要指定参数名称
    @DeleteMapping("/eduvod/video/removeVideo/{id}")
    public Result removeAliVideo(@PathVariable("id") String id);

}
