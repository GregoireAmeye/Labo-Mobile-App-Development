package nmct.howest.be.demolifecyle;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;


public class LifeCycleActivity extends Activity {



    //Created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("LifeCycleActivity", "LifeCycleActivity > onCreate                    <---------------------");
        setContentView(R.layout.activity_life_cycle);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new LifeCycleFragment())
                    .commit();
        }
    }

    //Started
    @Override
    public void onStart() {
        super.onStart();
        Log.d("LifeCycleActivity", "LifeCycleActivity > onStart                    <---------------------");
    }

    //Resumed
    @Override
    public void onResume() {
        super.onResume();
        Log.d("LifeCycleActivity", "LifeCycleActivity > onResume                    <---------------------");
    }

    //Paused
    @Override
    public void onPause() {
        super.onPause();
        Log.d("LifeCycleActivity", "LifeCycleActivity > onPause                    <---------------------");
    }

    //Stopped
    @Override
    public void onStop() {
        super.onStop();
        Log.d("LifeCycleActivity", "LifeCycleActivity > onStop                    <---------------------");
    }

    //Destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleActivity", "LifeCycleActivity > onDestroy                    <---------------------");
    }



    //other overrides
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life_cycle, menu);
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



}
