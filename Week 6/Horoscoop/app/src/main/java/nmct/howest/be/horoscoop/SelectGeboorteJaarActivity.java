package nmct.howest.be.horoscoop;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Gregoire on 26/03/2015.
 */
public class SelectGeboorteJaarActivity extends ListActivity {




    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String sGeboortejaar = GEBOORTEJAREN.get(position);

        Intent intent = new Intent();
        intent.putExtra(MainActivity.EXTRA_BIRTHYEAR, sGeboortejaar);
        setResult(RESULT_OK, intent);
        finish();
    }

    private ListAdapter myListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GEBOORTEJAREN);
        setListAdapter(myListAdapter);
    }

    private final static List<String> GEBOORTEJAREN;
    static{
        GEBOORTEJAREN = new ArrayList<>((Calendar.getInstance().get(Calendar.YEAR))-1900);
        for(int jaar = Calendar.getInstance().get(Calendar.YEAR); jaar >= 1900;jaar--){
            GEBOORTEJAREN.add(""+jaar);
        }
    }
}
