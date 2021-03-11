package com.project.perioddiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LogindoctorTabFragment extends Fragment {
       EditText logdoctoremail;
       EditText logdoctorpassword;
       TextView forgetpassworddoctor;
       Button logindoctor;
       float v=0;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.logindoctor_tab_fragment,container,  false);

        logdoctoremail = root.findViewById(R.id.logemaildoctor);
        logdoctorpassword = root.findViewById((R.id.logpassworddoctor));
        forgetpassworddoctor = root.findViewById(R.id.forgetpassworddoctor);
        logindoctor = root.findViewById(R.id.logindoctor);

        logdoctoremail.setTranslationX(800);
        logdoctorpassword.setTranslationX(800);
        forgetpassworddoctor.setTranslationX(800);
        logindoctor.setTranslationX(800);

        logdoctoremail.setAlpha(v);
        logdoctorpassword.setAlpha(v);
        forgetpassworddoctor.setAlpha(v);
        logindoctor.setAlpha(v);


        logdoctoremail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        logdoctorpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpassworddoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        logindoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();



        return root;
    }
}
