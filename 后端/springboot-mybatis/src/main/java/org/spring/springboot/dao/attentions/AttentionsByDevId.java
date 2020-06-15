package org.spring.springboot.dao.attentions;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface AttentionsByDevId {
    @Delete("DELETE FROM attentions where dev_id = #{devId}")
    void deleteAttentionsByDevId(@Param("devId") String devId);
}
