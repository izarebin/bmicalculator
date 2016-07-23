package com.izarebin.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity {
    String str1;
    String str2;
    TextView txttitle;
    double weight;
    double height;
    double bmiresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        txttitle = (TextView) findViewById(R.id.txttitle);
        final EditText edtweight = (EditText) findViewById(R.id.edtweight);
        final EditText edtheight = (EditText) findViewById(R.id.edtheight);
        Button btncalculate = (Button) findViewById(R.id.btncalculate);


        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = edtweight.getText().toString();
                str2 = edtheight.getText().toString();

                if (TextUtils.isEmpty(str1)){
                    edtweight.setError("vazne khod ra vared namaied");
                    return;
                }
                if (TextUtils.isEmpty(str2)){
                    edtheight.setError("ghade khod ra vared namaied");
                    return;
                }
                bmiresult = bmicalculate(weight,height);
                txttitle.setText("BMI is = " + bmiresult);
                bmiresult();
            }
        });

    }
    public double bmicalculate(double weight, double height){
        weight = Double.parseDouble(str1);
        height = Double.parseDouble(str2);
        double result = (weight / (height*height));
        return result;
    }
    public String bmiresult(){

        if (bmiresult < 15){
            Toast.makeText(BmiActivity.this, "shoma laghari mofrat darid", Toast.LENGTH_SHORT).show();
        } else if (bmiresult < 18.5) {
            Toast.makeText(BmiActivity.this, "shoma laghar hastid", Toast.LENGTH_SHORT).show();
        } else if (bmiresult < 25){
            Toast.makeText(BmiActivity.this, "shoma normal hastid", Toast.LENGTH_SHORT).show();
        } else if (bmiresult < 30){
            Toast.makeText(BmiActivity.this, "shoma chagh hastid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BmiActivity.this, "natije na moshakhas", Toast.LENGTH_SHORT).show();
        }

        return null;
    }
}
