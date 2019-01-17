package com.stldummy.testname;

public class Parameters {
    private String apiName = null;
    private String  userName = null;

    public Parameters(String apiName,
                          String userName) {
        this.apiName = apiName;
        this.userName = userName;
    }

    public String getAPIName() {
        return apiName;
    }
    public String getUserName() {
        return userName;
    }
}