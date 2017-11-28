package com.example.user.lab32inputcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.age_group,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoke);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(getApplicationContext(), "Position=" + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    public void reset(View view)
    {
        spinnerAge.setSelection(0);
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("");
    }

    public void calculatePremium(View view)
    {
        int pos;
        pos = spinnerAge.getSelectedItemPosition();

        int idGender;
        idGender = radioGroupGender.getCheckedRadioButtonId();

        //TODO: Calculate insurance premium
        int totalPremium = 0;
        switch (pos)
        {
            case 1: totalPremium += 50; break;
            case 2: totalPremium += 55; break;
            case 3: totalPremium += 60; break;
            case 4: totalPremium += 70; break;
            case 5: totalPremium += 120; break;
            case 6: totalPremium += 160; break;
            case 7: totalPremium += 200; break;
            case 8: totalPremium += 250; break;
        }

        if (idGender == R.id.radioButtonMale)
        {
            if (pos == 3)
            {
                totalPremium += 50;
            }
            else if (pos == 4)
            {
                totalPremium += 100;
            }
            else if (pos == 5)
            {
                totalPremium += 100;
            }
            else if (pos == 6)
            {
                totalPremium += 50;
            }
        }

        if(checkBoxSmoker.isChecked())
        {
            if (pos == 4)
            {
                totalPremium += 100;
            }
            else if (pos == 5)
            {
                totalPremium += 150;
            }
            else if (pos == 6)
            {
                totalPremium += 150;
            }
            else if (pos == 7)
            {
                totalPremium += 250;
            }
            else if (pos == 8)
            {
                totalPremium += 250;
            }
        }
        textViewPremium.setText(getString(R.string.premium) + totalPremium);

    }
}
