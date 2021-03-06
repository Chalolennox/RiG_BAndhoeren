
package com.mycompany.rigbandhoeren;


        import android.content.Intent;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import com.mycompany.rigbandhoeren.rigAPI.*;
        ;import java.util.concurrent.ExecutionException;

        import static android.support.v4.app.ActivityCompat.startActivity;


public class MainActivity extends ActionBarActivity implements Login_fragment.LoginFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void get_login_data(String Username, String Passwort) {
            String error;
            Intent pop_window=new Intent(MainActivity.this,PopUpWindow.class);
            RigDBAccess rig= new RigDBAccess(pop_window);

        try {

                error=new AsyncAuthenticate(this, rig).execute(Username, Passwort)
                        .get();

        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean login(){
        return false;
    }
}
