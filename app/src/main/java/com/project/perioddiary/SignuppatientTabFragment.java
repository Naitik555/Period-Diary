package com.project.perioddiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignuppatientTabFragment extends Fragment {

    EditText patientfullname;
    EditText patientemail;
    EditText patientmobilnumber;
    EditText patientpassword;
    Button patientbutton;
    float v = 0;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.signuppatient_tab_fragment,container,  false);

        patientfullname = root.findViewById(R.id.patientfullname);
        patientemail = root.findViewById((R.id.patientemail));
        patientmobilnumber = root.findViewById(R.id.patientmobilnumber);
        patientpassword = root.findViewById(R.id.patientpassword);
        patientbutton = root.findViewById(R.id.patientbutton);


        patientfullname.setTranslationX(800);
        patientemail.setTranslationX(800);
        patientmobilnumber.setTranslationX(800);
        patientpassword.setTranslationX(800);
        patientbutton.setTranslationX(800);

        patientfullname.setAlpha(v);
        patientemail.setAlpha(v);
        patientmobilnumber.setAlpha(v);
        patientpassword.setAlpha(v);
        patientbutton.setAlpha(v);


        patientfullname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        patientemail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        patientmobilnumber.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        patientpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        patientbutton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }

}
