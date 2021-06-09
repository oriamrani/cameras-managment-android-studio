package com.example.tutorial;

public class CameraModel {

    private String cameraName;
    private String ipAddress;
    private int port;
    private String userName;
    private String password;
    private int id;

    public CameraModel(String cameraName, String ipAddress, int port, String userName, String password, int id) {
        this.cameraName = cameraName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CameraModel{" +
                "cameraName='" + cameraName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
