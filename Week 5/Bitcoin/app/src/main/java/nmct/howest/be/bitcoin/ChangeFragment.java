package nmct.howest.be.bitcoin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Gregoire on 12/03/2015.
 */
public class ChangeFragment extends Fragment{
    public ChangeFragment() {

    }

    EditText txtBedragEuro;
    EditText txtBedragBitcoins;
    TextView tvKoers;
    Button btnNaarBitcoins;
    Button btnNaarEuro;
    Button btnWijzigKoers;

    public static final float currentRateBitcoinInEuro=1000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_change, container, false);

        txtBedragEuro = (EditText) v.findViewById(R.id.txtBedragEuro);
        txtBedragBitcoins = (EditText) v.findViewById(R.id.txtBedragBitcoin);
        tvKoers = (TextView) v.findViewById(R.id.tvKoers);
        btnNaarBitcoins = (Button) v.findViewById(R.id.btnNaarBitcoin);
        btnNaarEuro = (Button) v.findViewById(R.id.btnNaarEuro);
        btnWijzigKoers = (Button) v.findViewById(R.id.btnWijzigKoers);


        btnWijzigKoers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, BitcoinRateFragment.class);
                //startActivity(intent);
            }
        });

        toonWisselkoers();
        return v;
    }

    public void toonWisselkoers(){
        tvKoers.setText("1 bitcoin = " + currentRateBitcoinInEuro + "€");

    }
}
