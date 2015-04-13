package nmct.howest.be.horoscoop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    public static final String EXTRA_BIRTHYEAR = "be.howest.nmct.horoscoop.BIRTHYEAR";
    private static final int REQUEST_BIRTHDAY = 5;
    private static final int REQUEST_HOROSCOOP = 6;

    public void selecteerGeboortejaar(View v)
    {
        Intent intent = new Intent(MainActivity.this, SelectGeboorteJaarActivity.class);
        startActivityForResult(intent, REQUEST_BIRTHDAY);
    }

    public void selecteerHoroscoop(View v)
    {
        Intent intent = new Intent(MainActivity.this, HoroscoopActivity.class);
        startActivityForResult(intent, REQUEST_HOROSCOOP);
    }

    Button btnJaar;
    Button btnHoroscoop;
    EditText txtNaam;
    EditText txtVoornaam;
    TextView txtGeboorteJaar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJaar = (Button) findViewById(R.id.btnGeboortejaar);
        btnHoroscoop = (Button) findViewById(R.id.btnHoroscoop);
        txtNaam = (EditText) findViewById(R.id.txtNaam);
        txtVoornaam = (EditText) findViewById(R.id.txtVoornaam);
        txtGeboorteJaar = (TextView) findViewById(R.id.txtGeboortejaar);

        btnJaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecteerGeboortejaar(v);
            }
        });

        btnHoroscoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecteerHoroscoop(v);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_BIRTHDAY:
                switch (resultCode) {
                    case RESULT_OK:
                        String selectedYear = data.getStringExtra(MainActivity.EXTRA_BIRTHYEAR);
                        txtGeboorteJaar.setText("Geboortejaar: " + selectedYear);
                        break;
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this, "Geen geboortedatum gekozen", Toast.LENGTH_SHORT).show();
                        break;
                }
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
