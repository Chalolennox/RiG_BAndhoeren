package com.mycompany.rigbandhoeren.rigAPI;
import android.content.Intent;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lennox on 05/06/2015.
 */
public class RigDBAccess {
    private static String API_KEY = null;
    private static final String APIURL
            = "http://bewerbung.rockimgruenen.de/api/";
    private Intent intent;

    public RigDBAccess(Intent intent) {
        this.intent=intent;
    }
    public Intent getIntent(){
        return intent;
    }

    public RigDBAccess(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String authenticate(String user, String password) throws
            RiGException {
        String pageURL = APIURL + "authenticate.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user", user));
        params.add(new BasicNameValuePair("password", password));
        String result = httpPost(pageURL, params);
        if ("NO_USER".equals(result)) {
            throw new NoUserException();
        } else if ("NO_PASSWORD".equals(result)) {
            throw new NoPasswordException();
        } else if ("BAD_AUTHENTICATION".equals(result)) {
            throw new BadAuthenticationException();
        } else if ("BROKEN_APIKEY".equals(result)) {
            throw new BrokenAPIKeyException();
        }



        API_KEY = result;

        return result;
    }
    private static String httpPost(String url,
                                   List<NameValuePair> urlParameters)
            throws httpPostException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        if (urlParameters == null) {
            urlParameters = new ArrayList<NameValuePair>();
        }

        String USER_AGENT = "Mozilla/5.0";
        post.setHeader("User-Agent", USER_AGENT);

        urlParameters.add(new BasicNameValuePair("apikey", API_KEY));
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (IOException e) {
            throw new httpPostException(e);
        }

        HttpResponse response;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            throw new httpPostException(e);
        }

        BufferedReader rd;
        try {
            rd = new BufferedReader(new InputStreamReader
                    (response.getEntity().getContent()));
        } catch (IOException e) {
            throw new httpPostException(e);
        }

        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw new httpPostException(e);
        }

        return result.toString();
    }


}
