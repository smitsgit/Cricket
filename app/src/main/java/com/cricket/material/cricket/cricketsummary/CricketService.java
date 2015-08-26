package com.cricket.material.cricket.cricketsummary;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by smitald on 6/9/2015.
 */
public class CricketService {

    /*"https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.series.past&format=json&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0&callback="*/;

    private static final String API_URL = "https://query.yahooapis.com";
    private static final String includes = "select * from cricket.series.ongoing";
    private static final String format ="json";
    private static final String env ="store://0TxIGQMQbObzvU4Apia0V0";

    /*
     * Define a service for getting forecast information using Retrofit by Square
     */
    public interface CricketYahooService {
        @GET("/v1/public/yql")
         void GetCricketSummary(
                @Query("q") String includes,
                @Query("format") String format,
                @Query("env") String env,
                Callback<CricketSummary> callback
        );
    }

    /*private static RequestInterceptor getinterceptor(){
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addEncodedQueryParam("api_key", Etsy.API_KEY);
            }
        };
    }*/

    /*
     * Create an async call to the forecast service
     */
    public void loadSummaryData(Callback<CricketSummary> callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        CricketYahooService service = restAdapter.create(CricketYahooService.class);
        service.GetCricketSummary(includes,format,env,callback);
    }

}
