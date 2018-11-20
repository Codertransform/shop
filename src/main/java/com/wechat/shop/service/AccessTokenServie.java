package com.wechat.shop.service;

import com.wechat.shop.dao.AccessTokenDao;
import com.wechat.shop.entity.AccessToken;
import com.wechat.shop.utils.CommonUtils;
import com.wechat.shop.utils.WeiXinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class AccessTokenServie {

    @Autowired
    private AccessTokenDao tokenDao;

    public AccessToken checkAccessToken() throws IOException {
        AccessToken token = tokenDao.get();
        if (token != null) {
            if (new Date().getTime() > token.getExpiresAfter()){
                AccessToken newtoken = WeiXinUtils.getAccessToken();
                newtoken.setId(token.getId());
                newtoken.setExpiresAfter(new Date().getTime() + (newtoken.getExpiresIn()*1000));
                tokenDao.update(newtoken);
            }
        }else {
            AccessToken firtoken = WeiXinUtils.getAccessToken();
            firtoken.setId(CommonUtils.uuid());
            firtoken.setExpiresAfter(new Date().getTime() + (firtoken.getExpiresIn()*1000));
            tokenDao.insert(firtoken);
        }
        return token;
    }
}
