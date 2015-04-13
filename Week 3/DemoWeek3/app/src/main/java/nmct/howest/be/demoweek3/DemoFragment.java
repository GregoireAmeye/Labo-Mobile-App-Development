package nmct.howest.be.demoweek3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gregoire on 26/02/2015.
 */
public class DemoFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("DemoFragment", "DemoFragment > OnAttach                    <---------------------");
    }

    //deze methode is verantwoordelijk voor het inladen van de layout-file
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo, container, false);

        Log.d("DemoFragment", "DemoFragment > OnCreateView                    <---------------------");

        return v;
    }


}
