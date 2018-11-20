package com.wechat.shop.dao;

import com.wechat.shop.entity.AccessToken;

public interface AccessTokenDao {

    AccessToken get();

    void insert(AccessToken newtoken);

    void update(AccessToken newtoken);
}
