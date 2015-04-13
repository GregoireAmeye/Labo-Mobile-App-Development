package be.howest.nmct.demolaunchingactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ExplicitActivity extends Activity {

    public static final String EXTRA_INFO = "be.howest.nmct.android.launching.EXTRA_INFO";
    public static final int RESULT_NAAM=5;
    private TextView txtTitleExplicit;
    private Button btnOK;
    private Button btnCancel;
    private Button btnCopyrights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);


        txtTitleExplicit = (TextView) findViewById(R.id.txtTitleExplicit);
        String value =getIntent().getStringExtra(ExplicitActivity.EXTRA_INFO);
        txtTitleExplicit.setText(value);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCopyrights = (Button) findViewById(R.id.btnCopyright);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btnCopyrights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_LASTNAME, "Grégoire Ameye");
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_AGE,19);
                setResult(RESULT_NAAM, intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicit, menu);
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
