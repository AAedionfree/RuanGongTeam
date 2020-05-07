package org.spring.springboot.domain;

public class Log {
    private int logId;
    private int devId;
    private int devStatus;
    private int devWorkStatus;
    private int tokenId;
    private int tokenStatus;
<<<<<<< HEAD
    private String changeTime;
    private int auth;
    private String senderAccount;
    private String receiverAccount;

=======
    private int userId;
    private String changeTime;
    private int auth;
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
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

<<<<<<< HEAD
=======
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public int getAuth(){
        return this.auth;
    }

    public void setAuth(int auth){
        this.auth = auth;
    }

    public String getSenderAccount() { return senderAccount; }

    public void setSenderAccount(String senderAccount) { this.senderAccount = senderAccount; }

    public String getReceiverAccount() { return receiverAccount; }

    public void setReceiverAccount(String receiverAccount) { this.receiverAccount = receiverAccount; }
}
