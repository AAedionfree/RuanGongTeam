package org.spring.springboot.domain;

public class Log {
    private int logId;
    private int devId;
    private int devStatus;
    private int devWorkStatus;
    private int tokenId;
    private int tokenStatus;
    private int userId;
    private String changeTime;
    private int auth;
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
