package nmct.howest.be.demolifecyle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Gregoire on 26/02/2015.
 */
public class LifeCycleFragment extends Fragment{

    //<editor-fold desc="Created">
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("LifeCycleFragment", "LifeCycleFragment > OnAttach                    <---------------------");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycleFragment", "LifeCycleFragment > onCreate                    <---------------------");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_life_cycle, container,false);

        Log.d("LifeCycleFragment", "LifeCycleFragment > onCreateView                    <---------------------");

        Button btnAfsluiten = (Button) v.findViewById(R.id.btnAfsluiten);
        btnAfsluiten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                           }
        });

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("LifeCycleFragment", "LifeCycleFragment > onActivityCreated                    <---------------------");
    }
    //</editor-fold>

    //Started
    @Override
    public void onStart() {
        super.onStart();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onStart                    <---------------------");
    }

    //Resumed
    @Override
    public void onResume() {
        super.onResume();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onResume                    <---------------------");
    }

    //Paused
    @Override
    public void onPause() {
        super.onPause();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onPause                    <---------------------");
    }

    //Stopped

    @Override
    public void onStop() {
        super.onStop();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onStop                    <---------------------");
    }

    //<editor-fold desc="Destroyed">

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onDestroyView                    <---------------------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onDestroy                    <---------------------");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("LifeCycleFragment", "LifeCycleFragment > onDetach                    <---------------------");
    }

    //</editor-fold>


}
