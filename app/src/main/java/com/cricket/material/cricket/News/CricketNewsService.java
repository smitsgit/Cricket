package com.cricket.material.cricket.News;

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
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.http.GET;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by smitald on 8/28/2015.
 */
public class CricketNewsService {
    private static final String API_URL = "https://query.yahooapis.com";
    private static final String format ="json";
    private static final String env ="store://0TxIGQMQbObzvU4Apia0V0";


    /*
     * Define a service for getting forecast information using Retrofit by Square
     */
    public interface CricketYahooNewsService {
        @GET("/v1/public/yql")
        void GetCricketNews(
                @retrofit.http.Query("q") String includes,
                @retrofit.http.Query("format") String format,
                @retrofit.http.Query("env") String env,
                Callback<CricketNews> callback
        );
    }


    /*
     * Create an async call to the forecast service
     */
    public void loadCricNewsData(Callback<CricketNews> callback, String includes) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new DynamicJsonConverter())
                .build();

        CricketYahooNewsService service = restAdapter.create(CricketYahooNewsService.class);
        service.GetCricketNews(includes, format, env, callback);
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


        @Override public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
            try {
                InputStream in = typedInput.in(); // convert the typedInput to String
                String string = fromStream(in);
                in.close(); // we are responsible to close the InputStream after use
                String newstr = string;
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
