package be.howest.nmct.stopafstand;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class StopAfstandFragment extends Fragment {

    Button buttonBereken;
    //EditText editTextSnelheid;
    //EditText editTextReactietijd;
    SeekBar sbSnelheid;
    SeekBar sbReactieTijd;
    TextView textSnelheid;
    TextView textReactieTijd;
    RadioButton rdbDroog;
    RadioButton rdbNat;
    TextView textViewStopAfstandRes;



    public StopAfstandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_stopafstand, container, false);

        buttonBereken = (Button) v.findViewById(R.id.btnBereken);
        //editTextSnelheid = (EditText) v.findViewById(R.id.txtSnelheid);
        //editTextReactietijd = (EditText) v.findViewById(R.id.txtReactieTijd);
        sbSnelheid = (SeekBar) v.findViewById(R.id.sbSnelheid);
        sbReactieTijd = (SeekBar) v.findViewById(R.id.sbReactieTijd);
        textSnelheid = (TextView) v.findViewById(R.id.textSnelheid);
        textReactieTijd = (TextView) v.findViewById(R.id.textReactietijd);
        rdbDroog = (RadioButton) v.findViewById(R.id.rdbDroog);
        rdbNat = (RadioButton) v.findViewById(R.id.rdbNat);
        textViewStopAfstandRes = (TextView) v.findViewById(R.id.textViewStopAfstandRes);

        //SetOnClickListener gaat een luisteraar koppelen aan de button
        buttonBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BerekenStopAfstand();

            }

        });


        sbSnelheid.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                wijzigWaarden(seekBar, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbReactieTijd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                wijzigWaarden(seekBar, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return v;
    }


    private void wijzigWaarden(SeekBar sb,float progress)
    {
        if(sb == sbReactieTijd)
        {
            float rt = progress/10;
            textReactieTijd.setText(String.valueOf(rt)+"s");
        }
        else
        {
            textSnelheid.setText(String.valueOf(Math.round(progress))+" km/u");
        }
    }

    private void BerekenStopAfstand() {
        StopAfstandInfo.WegType typeWeg;
        int iSnelheid= sbSnelheid.getProgress();//Integer.parseInt(editTextSnelheid.getText().toString());
        float iReactieTijd = sbReactieTijd.getProgress();//Integer.parseInt(editTextReactietijd.getText().toString());
        if(rdbDroog.isChecked())
        {
            typeWeg=  StopAfstandInfo.WegType.WEGDEK_DROOG;
        }
        else
        {
            typeWeg= StopAfstandInfo.WegType.WEGDEK_NAT;
        }


        StopAfstandInfo sai = new StopAfstandInfo(typeWeg,iSnelheid,iReactieTijd/10);

        textViewStopAfstandRes.setText(String.valueOf(Math.round(sai.getStopafstand()))+" meter");


    }
}
