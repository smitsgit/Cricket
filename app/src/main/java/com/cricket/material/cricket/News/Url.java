
package com.cricket.material.cricket.News;

import java.util.HashMap;
import java.util.Map;


public class Url {

    private String executionStartTime;
    private String executionStopTime;
    private String executionTime;
    private String content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    public String getExecutionStartTime() {
        return executionStartTime;
    }



    public void setExecutionStartTime(String executionStartTime) {
        this.executionStartTime = executionStartTime;
    }



    public String getExecutionStopTime() {
        return executionStopTime;
    }



    public void setExecutionStopTime(String executionStopTime) {
        this.executionStopTime = executionStopTime;
    }



    public String getExecutionTime() {
        return executionTime;
    }



    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }



    public String getContent() {
        return content;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
