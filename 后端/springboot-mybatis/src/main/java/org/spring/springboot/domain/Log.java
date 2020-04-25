package org.spring.springboot.domain;

public class Log {
    private String logId;
    private String devId;
    private int devStatus;
    private int devWorkStatus;
    private int tokenId;
    private int tokenStatus;
    private String userId;
    private String changeTime;
    private int auth;
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public int getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(int devStatus) {
        this.devStatus = devStatus;
    }

    public int getDevWorkStatus() {
        return devWorkStatus;
    }

    public void setDevWorkStatus(int workStatus) {
        this.devWorkStatus = workStatus;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(int tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public void setAuth(int auth){
        this.auth = auth;
    }
    public int getAuth(){
        return this.auth;
    }
}
