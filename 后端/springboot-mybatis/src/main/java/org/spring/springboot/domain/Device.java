package org.spring.springboot.domain;

public class Device {
    int devId;
    String devName;
    String devType;
    float devPrise;
    String devDate;
    String devPeriod;
    int chargeId;
    int managerId;
<<<<<<< HEAD
    int devWorkStatus;
    int devStatus;
    int devAuth;
    String userAccount;
=======
    int devWordStatus;
    int devStatus;
    int devAuth;
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public float getDevPrise() {
        return devPrise;
    }

    public void setDevPrise(float devPrise) {
        this.devPrise = devPrise;
    }

    public String getDevDate() {
        return devDate;
    }

    public void setDevDate(String devDate) {
        this.devDate = devDate;
    }

    public String getDevPeriod() {
        return devPeriod;
    }

    public void setDevPeriod(String devPeriod) {
        this.devPeriod = devPeriod;
    }

    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDevWorkStatus() {
        return devWorkStatus;
    }

    public void setDevWorkStatus(int devWorkStatus) {
        this.devWorkStatus = devWorkStatus;
    }

    public int getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(int devStatus) {
        this.devStatus = devStatus;
    }

    public int getDevAuth() {
        return devAuth;
    }

    public void setDevAuth(int devAuth) {
        this.devAuth = devAuth;
    }

<<<<<<< HEAD
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

=======
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Device) {
            Device dev = (Device) obj;
            return dev.getDevId() == this.devId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return devId;
    }
}
