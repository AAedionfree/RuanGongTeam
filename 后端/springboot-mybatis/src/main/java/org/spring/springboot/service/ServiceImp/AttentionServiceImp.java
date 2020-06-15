package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.controller.AttentionController;
import org.spring.springboot.dao.attentions.AttentionAddDao;
import org.spring.springboot.dao.attentions.AttentionsByDevId;
import org.spring.springboot.dao.attentions.AttentionsByUserAccountDao;
import org.spring.springboot.domain.AttentionItem;
import org.spring.springboot.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImp implements AttentionService {
    @Autowired
    AttentionAddDao attentionAddDao;
    @Autowired
    AttentionsByDevId attentionsByDevId;
    @Autowired
    AttentionsByUserAccountDao attentionsByUserAccountDao;

    @Override
    public List<AttentionItem> addAttentionRecord(String userAccount, Integer devId) {
        attentionAddDao.addAttention(userAccount, devId);
        return null;
    }

    @Override
    public List<AttentionItem> cancelAttentionRecord(String userAccount, Integer devId) {
        attentionsByDevId.deleteAttentionsByDevId(userAccount, devId);
        return null;
    }

    @Override
    public List<AttentionItem> FindAttentionRecord(String userAccount) {
        return attentionsByUserAccountDao.findAttentionByUserAccount(userAccount);
    }
}
