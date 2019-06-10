package com.warcraftyork.pictureclassify.bean;
//import javax.validation.constraints.NotNull;

public class DBInfo {
    private String host;
    private String db;

//    @NotNull(message = "No user!")
    private String user;

//    @NotNull(message = "No host!")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

//    @NotNull(message = "No db!")
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

//    @NotNull(message = "No user!")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
