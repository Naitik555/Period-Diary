package com.project.perioddiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginpatientTabFragment extends Fragment {

    EditText logpatientemail;
    EditText logpatientpassword;
    TextView forgetpasswordpatient;
    Button loginpatient;
    float v=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.loginpatient_tab_fragment,container,  false);

        logpatientemail = root.findViewById(R.id.logpatientemail);
        logpatientpassword = root.findViewById((R.id.logpatientpassword));
        forgetpasswordpatient = root.findViewById(R.id.forgetpasswordpatient);
        loginpatient = root.findViewById(R.id.loginpatient);

        logpatientemail.setTranslationX(800);
        logpatientpassword.setTranslationX(800);
        forgetpasswordpatient.setTranslationX(800);
        loginpatient.setTranslationX(800);

        logpatientemail.setAlpha(v);
        logpatientpassword.setAlpha(v);
        forgetpasswordpatient.setAlpha(v);
        loginpatient.setAlpha(v);


        logpatientemail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        logpatientpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpasswordpatient.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        loginpatient.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}
