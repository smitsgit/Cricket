
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Diagnostics {

    private Cache cache;
    private List<Url> url = new ArrayList<Url>();
    private String publiclyCallable;
    private String userTime;
    private String serviceTime;
    private String buildVersion;


    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }


    public List<Url> getUrl() {
        return url;
    }


    public void setUrl(List<Url> url) {
        this.url = url;
    }


    public String getPubliclyCallable() {
        return publiclyCallable;
    }


    public void setPubliclyCallable(String publiclyCallable) {
        this.publiclyCallable = publiclyCallable;
    }


    public String getUserTime() {
        return userTime;
    }


    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }


    public String getServiceTime() {
        return serviceTime;
    }


    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }


    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }


}
