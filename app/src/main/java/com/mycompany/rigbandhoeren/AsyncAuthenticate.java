package com.mycompany.rigbandhoeren;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.mycompany.rigbandhoeren.rigAPI.*;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Lennox on 12/06/2015.
 */
public class AsyncAuthenticate extends AsyncTask<String, Integer, String> {

    private RigDBAccess rig;
    private Activity app;
    private  Exception exception;


    public AsyncAuthenticate(Activity app, RigDBAccess rig) {
        this.app = app;
        this.rig = rig;
    }

    @Override
    protected String doInBackground(String... params) {
        String user = params[0];
        String password = params[1];
        String apikey = null;

        try {
            apikey = rig.authenticate(user, password);
        } catch (RiGException e) {
            if(e instanceof BadAuthenticationException){

                rig.getIntent().putExtra("Error", " BadAuthenticationException");
                return null;

            }
            else  if(e instanceof NoPasswordException){

                rig.getIntent().putExtra("Error", "NoPasswordException");


                return null;

            }
            else  if(e instanceof BrokenAPIKeyException){

                rig.getIntent().putExtra("Error", "BrokenAPIKeyException");
                return null;

            }

            else {

                if(e instanceof NoUserException){

                    rig.getIntent().putExtra("Error", " NoUserException");
                    return null;

                }

            }


        }
        return apikey;
    }

    @Override
    protected void onPostExecute(String apikey) {
        super.onPostExecute(apikey);

        SharedPreferences sharedPref = app.getSharedPreferences(
                app.getString(R.string.global_prefs),
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("APIKEY", apikey);
        editor.commit();

    }
}