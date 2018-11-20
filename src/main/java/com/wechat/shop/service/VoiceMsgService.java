package com.wechat.shop.service;

import com.wechat.shop.dao.VoiceMsgDao;
import com.wechat.shop.entity.VoiceEntity;
import com.wechat.shop.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoiceMsgService {

    @Autowired
    private VoiceMsgDao voiceMsgDao;

    public void save(VoiceEntity voice){
        voice.setId(CommonUtils.uuid());
        voice.setDelFlag(CommonUtils.DEL_FLAG_NORMAL);
        voiceMsgDao.insert(voice);
    }
}
