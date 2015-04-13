package nmct.howest.be.horoscoop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Gregoire on 26/03/2015.
 */
public class HoroscoopAdapter extends ArrayAdapter<Data.Horoscoop> {
    public HoroscoopAdapter(Context c) {
        super(c, R.layout.row_horoscoop, R.id.txtHor, Data.Horoscoop.values());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = super.getView(position, convertView, parent);

        Data.Horoscoop hor = Data.Horoscoop.values()[position];

        TextView txtHor = (TextView) row.findViewById(R.id.txtHor);
        txtHor.setText(hor.getNaamHoroscoop());

        return row;

    }
}
