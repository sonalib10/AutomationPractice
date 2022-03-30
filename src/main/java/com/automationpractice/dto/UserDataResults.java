package com.automationpractice.dto;
import java.util.List;
public class UserDataResults {

    private List<UserData> results;
    private Info info;

    public List<UserData> getResults() {
        return results;
    }

    public void setResults(List<UserData> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
