package com.cricket.material.cricket.cricketsummary;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by smitald on 6/9/2015.
 */
public class CricketService {

    /*"https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.series.past&format=json&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0&callback="*/;

    private static final String API_URL = "https://query.yahooapis.com";
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

    /*
     * Define a service for getting forecast information using Retrofit by Square
     */
    public interface CricketYahooRawJsonService {
        @GET("/v1/public/yql")
        void GetCricketSummary(
                @Query("q") String includes,
                @Query("format") String format,
                @Query("env") String env,
                Callback<Response> callback
        );
    }

    /*
     * Create an async call to the forecast service
     */
    public void loadSummaryData(Callback<CricketSummary> callback, String includes) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new DynamicJsonConverter())
                .build();

        CricketYahooService service = restAdapter.create(CricketYahooService.class);
        service.GetCricketSummary(includes,format,env,callback);
    }


    static class DynamicJsonConverter implements Converter {

        public int findClosingParen(char[] text, int openPos) {
            int closePos = openPos;
            int counter = 1;
            while (counter > 0) {
                char c = text[++closePos];
                if (c == '{') {
                    counter++;
                }
                else if (c == '}') {
                    counter--;
                }
            }
            return closePos;
        }

        /** @return index of pattern in s or -1, if not found */
        public  String findAndReplace(Pattern pattern, String s) {
            int index = -1;
            int closingindex = -1;
            char c = 'A';
            StringBuilder newstring = new StringBuilder(s);
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()) {
                index = matcher.end();
                closingindex = findClosingParen(s.toCharArray(), index);
                newstring.insert(index - 1,"[");
                newstring.insert(closingindex + 2,"]");
            }
            return newstring.toString();
         }

        //String newstr = "{\"query\":{\"count\":5,\"created\":\"2015-08-27T19:40:23Z\",\"lang\":\"en-US\",\"results\":{\"Series\":[{\"SeriesId\":\"12231\",\"SeriesName\":\"Australia in Ireland ODI Series, 1 ODI Cricket Series, 2015\",\"StartDate\":\"2015-08-27T15:15:00+05:30\",\"EndDate\":\"2015-08-27T23:15:00+05:30\",\"Participant\":{\"mlevel\":\"international\",\"mtype\":\"odi\",\"Team\":[{\"teamid\":\"1\",\"Name\":\"Australia\"},{\"teamid\":\"13\",\"Name\":\"Ireland\"}]},\"Schedule\":{\"Match\":[{\"group\":\"\",\"matchid\":\"191258\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"One-off ODI\",\"Venue\":{\"venueid\":\"32\",\"content\":\"Civil Service Cricket Club, Stormont, Belfast\"},\"StartDate\":\"2015-08-27T15:15:00+05:30\",\"EndDate\":\"2015-08-27T23:15:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"Ireland\",\"role\":\"\",\"teamid\":\"13\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"23\",\"how\":\"runs\",\"isdl\":\"yes\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"13\",\"matchwon\":\"no\"},{\"id\":\"1\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-27T15:15:00+05:30\"}}]}},{\"SeriesId\":\"12229\",\"SeriesName\":\"New Zealand in South Africa ODI Series, 3 ODI Cricket Series, 2015\",\"StartDate\":\"2015-08-19T16:00:00+05:30\",\"EndDate\":\"2015-08-27T00:00:00+05:30\",\"Participant\":{\"mlevel\":\"international\",\"mtype\":\"odi\",\"Team\":[{\"teamid\":\"5\",\"Name\":\"New Zealand\"},{\"teamid\":\"7\",\"Name\":\"South Africa\"}]},\"Schedule\":{\"Match\":[{\"group\":\"\",\"matchid\":\"191253\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"1st ODI\",\"Venue\":{\"venueid\":\"153\",\"content\":\"SuperSport Park, Centurion\"},\"StartDate\":\"2015-08-19T16:00:00+05:30\",\"EndDate\":\"2015-08-20T00:00:00+05:30\",\"MatchTimeSpan\":\"Day-Night\",\"Team\":[{\"Team\":\"South Africa\",\"role\":\"\",\"teamid\":\"7\"},{\"Team\":\"New Zealand\",\"role\":\"\",\"teamid\":\"5\"}],\"Result\":{\"by\":\"20\",\"how\":\"runs\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"7\",\"matchwon\":\"yes\"},{\"id\":\"5\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-19T16:00:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191254\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"2nd ODI\",\"Venue\":{\"venueid\":\"116\",\"content\":\"Senwes Park, Potchefstroom\"},\"StartDate\":\"2015-08-23T13:30:00+05:30\",\"EndDate\":\"2015-08-23T21:30:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"South Africa\",\"role\":\"\",\"teamid\":\"7\"},{\"Team\":\"New Zealand\",\"role\":\"\",\"teamid\":\"5\"}],\"Result\":{\"by\":\"8\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"7\",\"matchwon\":\"no\"},{\"id\":\"5\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-23T13:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191255\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"3rd ODI\",\"Venue\":{\"venueid\":\"84\",\"content\":\"Kingsmead, Durban\"},\"StartDate\":\"2015-08-26T16:00:00+05:30\",\"EndDate\":\"2015-08-27T00:00:00+05:30\",\"MatchTimeSpan\":\"Day-Night\",\"Team\":[{\"Team\":\"South Africa\",\"role\":\"\",\"teamid\":\"7\"},{\"Team\":\"New Zealand\",\"role\":\"\",\"teamid\":\"5\"}],\"Result\":{\"by\":\"62\",\"how\":\"runs\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"7\",\"matchwon\":\"yes\"},{\"id\":\"5\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-26T16:00:00+05:30\"}}]}},{\"SeriesId\":\"12193\",\"SeriesName\":\"The Ashes, 2015\",\"StartDate\":\"2015-07-08T15:30:00+05:30\",\"EndDate\":\"2015-08-24T22:30:00+05:30\",\"Participant\":{\"mlevel\":\"international\",\"mtype\":\"test\",\"Team\":[{\"teamid\":\"1\",\"Name\":\"Australia\"},{\"teamid\":\"3\",\"Name\":\"England\"}]},\"Schedule\":{\"Match\":[{\"group\":\"\",\"matchid\":\"190789\",\"mtype\":\"test\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"1st Test\",\"Venue\":{\"venueid\":\"149\",\"content\":\"Sophia Gardens, Cardiff\"},\"StartDate\":\"2015-07-08T15:30:00+05:30\",\"EndDate\":\"2015-07-12T22:30:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England\",\"role\":\"\",\"teamid\":\"3\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"169\",\"how\":\"runs\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"3\",\"matchwon\":\"yes\"},{\"id\":\"1\",\"matchwon\":\"no\"}],\"Date\":\"2015-07-08T15:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"190790\",\"mtype\":\"test\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"2nd Test\",\"Venue\":{\"venueid\":\"89\",\"content\":\"Lord's, London\"},\"StartDate\":\"2015-07-16T15:30:00+05:30\",\"EndDate\":\"2015-07-20T22:30:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England\",\"role\":\"\",\"teamid\":\"3\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"405\",\"how\":\"runs\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"3\",\"matchwon\":\"no\"},{\"id\":\"1\",\"matchwon\":\"yes\"}],\"Date\":\"2015-07-16T15:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"190791\",\"mtype\":\"test\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"3rd Test\",\"Venue\":{\"venueid\":\"50\",\"content\":\"Edgbaston, Birmingham\"},\"StartDate\":\"2015-07-29T15:30:00+05:30\",\"EndDate\":\"2015-08-02T22:30:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England\",\"role\":\"\",\"teamid\":\"3\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"8\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"3\",\"matchwon\":\"yes\"},{\"id\":\"1\",\"matchwon\":\"no\"}],\"Date\":\"2015-07-29T15:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"190792\",\"mtype\":\"test\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"4th Test\",\"Venue\":{\"venueid\":\"161\",\"content\":\"Trent Bridge, Nottingham\"},\"StartDate\":\"2015-08-06T15:30:00+05:30\",\"EndDate\":\"2015-08-10T22:30:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England\",\"role\":\"\",\"teamid\":\"3\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"78\",\"how\":\"innings\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"3\",\"matchwon\":\"yes\"},{\"id\":\"1\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-06T15:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"190793\",\"mtype\":\"test\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"5th Test\",\"Venue\":{\"venueid\":\"81\",\"content\":\"The Oval, London\"},\"StartDate\":\"2015-08-20T15:30:00+05:30\",\"EndDate\":\"2015-08-23T21:10:49+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England\",\"role\":\"\",\"teamid\":\"3\"},{\"Team\":\"Australia\",\"role\":\"\",\"teamid\":\"1\"}],\"Result\":{\"by\":\"46\",\"how\":\"innings\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"3\",\"matchwon\":\"no\"},{\"id\":\"1\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-20T15:30:00+05:30\"}}]}},{\"SeriesId\":\"12256\",\"SeriesName\":\"Australia Under-19 vs England Under-19 Youth ODI Series, 5 Youth ODI Cricket Series in England, 2015\",\"StartDate\":\"2015-08-11T15:00:00+05:30\",\"EndDate\":\"2015-08-22T23:00:00+05:30\",\"Participant\":{\"mlevel\":\"international\",\"mtype\":\"odi\",\"Team\":[{\"teamid\":\"1154\",\"Name\":\"Australia Under-19\"},{\"teamid\":\"1159\",\"Name\":\"England Under-19\"}]},\"Schedule\":{\"Match\":[{\"group\":\"\",\"matchid\":\"191441\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"1st Youth ODI\",\"Venue\":{\"venueid\":\"1852\",\"content\":\"Roseworth Terrace, Gosforth, England\"},\"StartDate\":\"2015-08-11T15:00:00+05:30\",\"EndDate\":\"2015-08-11T23:00:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England Under-19\",\"role\":\"\",\"teamid\":\"1159\"},{\"Team\":\"Australia Under-19\",\"role\":\"\",\"teamid\":\"1154\"}],\"Result\":{\"by\":\"8\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"1159\",\"matchwon\":\"no\"},{\"id\":\"1154\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-11T15:00:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191444\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"abandoned\",\"MatchNo\":\"2nd Youth ODI\",\"Venue\":{\"venueid\":\"396\",\"content\":\"Queen's Park, Chesterfield\"},\"StartDate\":\"2015-08-14T15:00:00+05:30\",\"EndDate\":\"2015-08-14T23:00:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England Under-19\",\"role\":\"\",\"teamid\":\"1159\"},{\"Team\":\"Australia Under-19\",\"role\":\"\",\"teamid\":\"1154\"}],\"Result\":{\"by\":\"\",\"how\":\"abandoned\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"1159\",\"matchwon\":\"no\"},{\"id\":\"1154\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-14T15:00:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191447\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"3rd Youth ODI\",\"Venue\":{\"venueid\":\"35\",\"content\":\"County Ground, Derby\"},\"StartDate\":\"2015-08-17T18:30:00+05:30\",\"EndDate\":\"2015-08-18T02:30:00+05:30\",\"MatchTimeSpan\":\"Day-Night\",\"Team\":[{\"Team\":\"England Under-19\",\"role\":\"\",\"teamid\":\"1159\"},{\"Team\":\"Australia Under-19\",\"role\":\"\",\"teamid\":\"1154\"}],\"Result\":{\"by\":\"3\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"1159\",\"matchwon\":\"yes\"},{\"id\":\"1154\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-17T18:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191450\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"4th Youth ODI\",\"Venue\":{\"venueid\":\"60\",\"content\":\"Grace Road, Leicester\"},\"StartDate\":\"2015-08-20T15:00:00+05:30\",\"EndDate\":\"2015-08-20T23:00:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England Under-19\",\"role\":\"\",\"teamid\":\"1159\"},{\"Team\":\"Australia Under-19\",\"role\":\"\",\"teamid\":\"1154\"}],\"Result\":{\"by\":\"7\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"1159\",\"matchwon\":\"no\"},{\"id\":\"1154\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-20T15:00:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191452\",\"mtype\":\"odi\",\"stage\":\"heat\",\"status\":\"pre\",\"MatchNo\":\"5th Youth ODI\",\"Venue\":{\"venueid\":\"37\",\"content\":\"County Ground, New Road, Worcester\"},\"StartDate\":\"2015-08-22T15:00:00+05:30\",\"EndDate\":\"2015-08-22T23:00:00+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"England Under-19\",\"role\":\"\",\"teamid\":\"1159\"},{\"Team\":\"Australia Under-19\",\"role\":\"\",\"teamid\":\"1154\"}]}]}},{\"SeriesId\":\"12230\",\"SeriesName\":\"New Zealand in South Africa T20 Series, 2 T20 Cricket Series, 2015\",\"StartDate\":\"2015-08-14T21:30:00+05:30\",\"EndDate\":\"2015-08-16T21:30:00+05:30\",\"Participant\":{\"mlevel\":\"international\",\"mtype\":\"t20\",\"Team\":[{\"teamid\":\"5\",\"Name\":\"New Zealand\"},{\"teamid\":\"7\",\"Name\":\"South Africa\"}]},\"Schedule\":{\"Match\":[{\"group\":\"\",\"matchid\":\"191256\",\"mtype\":\"t20\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"1st T20I\",\"Venue\":{\"venueid\":\"84\",\"content\":\"Kingsmead, Durban\"},\"StartDate\":\"2015-08-14T21:30:00+05:30\",\"EndDate\":\"2015-08-15T01:30:00+05:30\",\"MatchTimeSpan\":\"Day-Night\",\"Team\":[{\"Team\":\"South Africa\",\"role\":\"\",\"teamid\":\"7\"},{\"Team\":\"New Zealand\",\"role\":\"\",\"teamid\":\"5\"}],\"Result\":{\"by\":\"6\",\"how\":\"wickets\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"7\",\"matchwon\":\"yes\"},{\"id\":\"5\",\"matchwon\":\"no\"}],\"Date\":\"2015-08-14T21:30:00+05:30\"}},{\"group\":\"\",\"matchid\":\"191257\",\"mtype\":\"t20\",\"stage\":\"heat\",\"status\":\"post\",\"MatchNo\":\"2nd T20I\",\"Venue\":{\"venueid\":\"153\",\"content\":\"SuperSport Park, Centurion\"},\"StartDate\":\"2015-08-16T17:30:00+05:30\",\"EndDate\":\"2015-08-16T21:18:08+05:30\",\"MatchTimeSpan\":\"Day\",\"Team\":[{\"Team\":\"South Africa\",\"role\":\"\",\"teamid\":\"7\"},{\"Team\":\"New Zealand\",\"role\":\"\",\"teamid\":\"5\"}],\"Result\":{\"by\":\"32\",\"how\":\"runs\",\"isdl\":\"no\",\"isff\":\"no\",\"isso\":\"no\",\"Team\":[{\"id\":\"7\",\"matchwon\":\"no\"},{\"id\":\"5\",\"matchwon\":\"yes\"}],\"Date\":\"2015-08-16T17:30:00+05:30\"}}]}}]}}}";
        @Override public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
            try {
                InputStream in = typedInput.in(); // convert the typedInput to String
                String string = fromStream(in);
                in.close(); // we are responsible to close the InputStream after use
                String newstr = string;
                newstr = findAndReplace(Pattern.compile("\"Series\":\\{"), string);
                newstr = findAndReplace(Pattern.compile("\"Match\":\\{"), newstr);
                if (String.class.equals(type)) {
                    return newstr;
                } else {
                    return new Gson().fromJson(newstr, type); // convert to the supplied type, typically Object, JsonObject or Map<String, Object>
                }
            } catch (Exception e) { // a lot may happen here, whatever happens
                throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
            }
        }

        @Override public TypedOutput toBody(Object object) { // not required
            return null;
        }

        private static String fromStream(InputStream in) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append("\r\n");
            }
            return out.toString();
        }
    }

}
