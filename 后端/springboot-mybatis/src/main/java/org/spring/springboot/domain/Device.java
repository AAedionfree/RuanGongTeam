package org.spring.springboot.domain;

public class Device {
    String devId;
    String devType;
    float devPrise;
    String devDate;
    String devProv;
    String devPeriod;
    String chargeId;
    String managerId;
    int devWordStatus;
    int devStatus;
    int devAuth;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
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

    public String getDevProv() {
        return devProv;
    }

    public void setDevProv(String devProv) {
        this.devProv = devProv;
    }

    public String getDevPeriod() {
        return devPeriod;
    }

    public void setDevPeriod(String devPeriod) {
        this.devPeriod = devPeriod;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int getDevWordStatus() {
        return devWordStatus;
    }

    public void setDevWordStatus(int devWordStatus) {
        this.devWordStatus = devWordStatus;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Device) {
            Device dev = (Device) obj;
            return dev.getDevId().equals(this.devId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(devId);
    }
}
