package com.project.perioddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Question extends AppCompatActivity {

    Button doctorlist;
    Button answer;

    TextView reporttext;

    TextView questioncolor;
    TextView questionstress;
    TextView questionbmi;
    TextView questionflow;

    EditText height;
    EditText weight;

    RadioGroup colorgroup;
    RadioButton coloroption;

    RadioGroup stressgroup;
    RadioButton stressoption;

    RadioGroup flowgroup;
    RadioButton flowoption;

    String report = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        doctorlist = findViewById(R.id.doctorlist);
        answer = findViewById(R.id.answer);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        reporttext = findViewById(R.id.report);
        reporttext.setVisibility(View.GONE);

        colorgroup = (RadioGroup)findViewById(R.id.colorgroup);
        stressgroup = (RadioGroup)findViewById(R.id.stressgroup);
        flowgroup = (RadioGroup)findViewById(R.id.flowlevel);

        questionbmi = findViewById(R.id.questionbmi);
        questioncolor = findViewById(R.id.questioncolor);
        questionstress = findViewById(R.id.questionstress);
        questionflow = findViewById(R.id.questionflow);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String heightext = height.getText().toString();
                String weeight = weight.getText().toString();

                float heightint = Float.parseFloat(heightext);
                float weightint = Float.parseFloat(weeight);

                float bmi = weightint/((heightint)*(heightint));

                String bmiString = String.valueOf(bmi);

                coloroption = (RadioButton)findViewById(colorgroup.getCheckedRadioButtonId());

                String ccolor = "COLOR - " + coloroption.getText().toString() + " ";

                String bbmi =  "\n" + "BMI - " + bmiString;

                int optiontwo = stressgroup.getCheckedRadioButtonId();
                stressoption = (RadioButton)findViewById(optiontwo);

                String sstreeleve ="\n" +  "STRESS LEVEL -  " + stressoption.getText().toString() + " ";

                int optionthree = flowgroup.getCheckedRadioButtonId();
                flowoption = (RadioButton)findViewById(optionthree);

                String fffloww = "\n" + "FLOW LEVEL -  " + flowoption.getText().toString() + " ";

                report =  ccolor + bbmi + sstreeleve + fffloww;

                reporttext.setVisibility(View.VISIBLE);
                questionbmi.setVisibility(View.GONE);
                questioncolor.setVisibility(View.GONE);
                questionflow.setVisibility(View.GONE);
                questionstress.setVisibility(View.GONE);

                height.setVisibility(View.GONE);
                weight.setVisibility(View.GONE);

                colorgroup.setVisibility(View.GONE);
                stressgroup.setVisibility(View.GONE);
                flowgroup.setVisibility(View.GONE);

                if(((coloroption.getText().toString() == "COLOR 2") ||
                        (coloroption.getText().toString() == "COLOR 3" ))
                        &&  (bmi < 22.0) && (stressoption.getText().toString() == "HIGH")
                        && ((flowoption.getText().toString() == "IRREGULAR")
                        || (flowoption.getText().toString() == "BAD")))
                {
                    report = report + "\n Your options say you need rest and You may consult doctors if you want using doctor`s list";
                }
                else
                {
                    report = report + "\n Your options say you are in normal condition but still if you want you can consult doctors using doctor`s` list";
                }
                reporttext.setText(report);

            }
        });

        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DoctorRecycler.class);
                startActivity(intent);
            }
        });
    }
}