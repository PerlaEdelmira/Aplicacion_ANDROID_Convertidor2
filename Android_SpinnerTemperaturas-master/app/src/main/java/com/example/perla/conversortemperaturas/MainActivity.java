package com.example.abraham.conversortemperaturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner sConvert,spinnerConvertirA;
    EditText cajaConversion,cajaResultado;
    double temp,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sConvert = findViewById(R.id.spinnerConvertir);
        spinnerConvertirA = findViewById(R.id.spinnerConvertirA);
        cajaConversion = findViewById(R.id.caja1);
        cajaResultado = findViewById(R.id.caja2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Convertir,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.ConvertirA,android.R.layout.simple_spinner_item);

        spinnerConvertirA.setAdapter(adapter1);
        spinnerConvertirA.setOnItemSelectedListener(this);

        sConvert.setAdapter(adapter);
        sConvert.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (sConvert.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit")){
            switch (spinnerConvertirA.getSelectedItem().toString()){
                case "Fahrenheit":
                    cajaResultado.setText(cajaConversion.getText());
                    break;
                case "Celsius":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (temp-32)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Kelvin":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (temp+459.67)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Rankine":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = temp+459.67;
                    cajaResultado.setText(String.valueOf(res));
                    break;
            }

        }//fahrenheit
        else if (sConvert.getSelectedItem().toString().equalsIgnoreCase("Celsius")){
            switch (spinnerConvertirA.getSelectedItem().toString()){
                case "Fahrenheit":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (1.8*temp)+32;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Celsius":
                    cajaResultado.setText(cajaConversion.getText());
                    break;
                case "Kelvin":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = temp+273.15;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Rankine":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (1.8*temp)+32;
                    res = res + 459.67;
                    cajaResultado.setText(String.valueOf(res));
                    break;
            }
        }//celsius
        else if (sConvert.getSelectedItem().toString().equalsIgnoreCase("Kelvin")){
            switch (spinnerConvertirA.getSelectedItem().toString()){
                case "Fahrenheit":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (temp+459.67)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Celsius":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (temp*1.8)+32;
                    res = (res+459.67)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Kelvin":
                    cajaResultado.setText(cajaConversion.getText());
                    break;
                case "Rankine":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = (temp*1.8)-459.67;
                    res = res +459.67;
                    cajaResultado.setText(String.valueOf(res));
                    break;
            }
        }//kelvin
        else if (sConvert.getSelectedItem().toString().equalsIgnoreCase("Rankine")){
            switch (spinnerConvertirA.getSelectedItem().toString()){
                case "Fahrenheit":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = temp - 459.67;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Celsius":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = temp-459.67;
                    res = (res-32)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Kelvin":
                    temp=Double.parseDouble(String.valueOf(cajaConversion.getText()));
                    res = temp - 459.67;
                    res = (res + 459.67)/1.8;
                    cajaResultado.setText(String.valueOf(res));
                    break;
                case "Rankine":
                    cajaResultado.setText(cajaConversion.getText());
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
