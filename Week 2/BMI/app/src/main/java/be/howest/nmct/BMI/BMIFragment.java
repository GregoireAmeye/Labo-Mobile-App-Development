package be.howest.nmct.BMI;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static be.howest.nmct.BMI.BMI.Category;

public class BMIFragment extends Fragment {


    private EditText txtHeight;
    private EditText txtMass;
    private Button btnUpdate;
    private TextView txtIndex;
    private TextView txtCategory;
    private ImageView imgSilhouette;

    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);
        txtHeight = (EditText) v.findViewById(R.id.txtYourHeight);
        txtMass = (EditText) v.findViewById(R.id.txtYourMass);
        btnUpdate = (Button) v.findViewById(R.id.btnUpdate);
        txtIndex = (TextView) v.findViewById(R.id.txtIndex);
        txtCategory = (TextView) v.findViewById(R.id.txtCategorie);
        imgSilhouette = (ImageView) v.findViewById(R.id.imgSilhouette);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonBMI(v);
            }
        });

        return v;
    }

    private void toonBMI(View v) {
        float iHeight;
        int iMass;
        BMI bmi = new BMI();
        try {
            iHeight = Integer.parseInt(txtHeight.getText().toString());
            iMass = Integer.parseInt(txtMass.getText().toString());
        }
        catch(Exception ex)
        {
            iHeight = 170;
            iMass =70;

        }

        if(iHeight >=20 && iMass >=2)
        {
            bmi = new BMI(iHeight / 100, iMass);
        };

        Category c = Category.getCategory(bmi.getBMIIndex());

        txtCategory.setText(c.toString());
        txtIndex.setText("" + bmi.getBMIIndex());
        imgSilhouette.setImageResource(getResourceId(BMI.Category.getCategory(bmi.getBMIIndex())));
    }

    private int getResourceId(Category c) {
        switch (c) {
            case Groot_ondergewicht:
                return R.drawable.silhouette_1;
            case Ernstig_ondergewicht:
                return R.drawable.silhouette_2;
            case Ondergewicht:
                return R.drawable.silhouette_3;
            case Normaal:
                return R.drawable.silhouette_4;
            case Overgewicht:
                return R.drawable.silhouette_5;
            case Matig_overgewicht:
                return R.drawable.silhouette_6;
            case Ernstig_overgewicht:
                return R.drawable.silhouette_7;
            case Zeer_groot_overgewicht:
                return R.drawable.silhouette_8;
        }
        return R.drawable.silhouette_1;
    }
}



