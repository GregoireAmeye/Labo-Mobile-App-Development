package be.howest.nmct.demolaunchingactivities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button btnStartExplicitActivity;
    private Button btnToonDialoogVenster;
    public static final int REQUEST_CODE_EXPLICIT = 1;

    //men moet een default value geven aan de string
    public static String EXTRA_INFO_BACK_LASTNAME = "";
    public static String EXTRA_INFO_BACK_AGE;
    public static String EXTRA_INFO_BACK_SCORE;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartExplicitActivity = (Button) findViewById(R.id.btnStartExplicitActivity);
        btnStartExplicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });
        btnToonDialoogVenster = (Button) findViewById(R.id.btnStartAlertDialog);
        btnToonDialoogVenster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText txtScore = (EditText) findViewById(R.id.txtScore);

                LayoutInflater inflater = getLayoutInflater();

                AlertDialog.Builder build = new AlertDialog.Builder(context);
                build.setMessage("Geef jouw score door").setTitle("NMCT");
                build.setView(inflater.inflate(R.layout.dialog, null));

                build.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EXTRA_INFO_BACK_SCORE = txtScore.getText().toString();
                    }
                });
                build.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = build.create();
                dialog.show();
            }
        });
    }

    public void startSecondActivity() {
        Intent intent = new Intent(MainActivity.this, ExplicitActivity.class);
        intent.putExtra(ExplicitActivity.EXTRA_INFO, "2NMCT1");
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_EXPLICIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_EXPLICIT:
                switch (resultCode)
                {
                    case RESULT_CANCELED:
                        Toast.makeText(this, "User Selects Cancel",Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_OK:
                        Toast.makeText(this, "User Selects OK",Toast.LENGTH_SHORT).show();
                        break;
                    case ExplicitActivity.RESULT_NAAM:
                        String naam = data.getStringExtra(MainActivity.EXTRA_INFO_BACK_LASTNAME);
                        int age = data.getIntExtra(MainActivity.EXTRA_INFO_BACK_AGE, 0);
                        Toast.makeText(this, naam+", "+age+" - All rights reserved",Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
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
}
