
package com.cricket.material.cricket.News;

import java.util.HashMap;
import java.util.Map;


public class Query {

    private long count;
    private String created;
    private String lang;
    private Diagnostics diagnostics;
    private Results results;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    public long getCount() {
        return count;
    }



    public void setCount(long count) {
        this.count = count;
    }



    public String getCreated() {
        return created;
    }



    public void setCreated(String created) {
        this.created = created;
    }



    public String getLang() {
        return lang;
    }



    public void setLang(String lang) {
        this.lang = lang;
    }



    public Diagnostics getDiagnostics() {
        return diagnostics;
    }



    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }



    public Results getResults() {
        return results;
    }



    public void setResults(Results results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
