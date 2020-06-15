package org.spring.springboot.service;

import org.spring.springboot.domain.AttentionItem;

import java.util.List;

public interface AttentionService extends Service{
    List<AttentionItem> addAttentionRecord(String userAccount, Integer devId) throws Exception;

    List<AttentionItem> cancelAttentionRecord(String userAccount, Integer devId) throws Exception;

    List<AttentionItem> FindAttentionRecord(String userAccount) throws Exception;
}
