package com.atguigu.msmservice.service;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.sun.tools.javac.comp.Todo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public boolean send(Map<String, Object> param, String phone) {
        if(StringUtils.isEmpty(phone)) return false;

        DefaultProfile profile =
                DefaultProfile.getProfile("default", "LTAI4G4RutThgfr8wk8JVj24", "4LSmvHpD9yK8WmQReMTDzagnKQxHDf");
        IAcsClient client = new DefaultAcsClient(profile);

        //fixed params
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        //params need to be sent
        //*TODO
        request.putQueryParameter("PhoneNumbers",phone); //phone number
        request.putQueryParameter("SignName","我的谷粒在线教育网站");
        request.putQueryParameter("TemplateCode","SMS_180051135");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try {
            //send
            CommonResponse response = client.getCommonResponse(request);
            boolean success = response.getHttpResponse().isSuccess();
            return success;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
