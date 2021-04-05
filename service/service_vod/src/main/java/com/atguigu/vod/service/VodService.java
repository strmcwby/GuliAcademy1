package com.atguigu.vod.service;

import com.atguigu.commonutils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    public String uploadVideo(MultipartFile file);
}
