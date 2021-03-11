package com.project.perioddiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignupdoctorTabFragment extends Fragment {

    EditText doctorfullname;
    EditText doctoremail;
    EditText doctormobilnumber;
    EditText doctorpassword;
    EditText doctorcity;
    Button doctorbutton;
    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.signupdoctor_tab_fragment,container,  false);

        doctorfullname = root.findViewById(R.id.doctorfullname);
        doctoremail = root.findViewById((R.id.doctoremail));
        doctormobilnumber = root.findViewById(R.id.doctormobilnumber);
        doctorpassword = root.findViewById(R.id.doctorpassword);
        doctorcity = root.findViewById(R.id.doctorcity);
        doctorbutton = root.findViewById(R.id.doctorbutton);


        doctorfullname.setTranslationX(800);
        doctoremail.setTranslationX(800);
        doctormobilnumber.setTranslationX(800);
        doctorpassword.setTranslationX(800);
        doctorcity.setTranslationX(800);
        doctorbutton.setTranslationX(800);

        doctorfullname.setAlpha(v);
        doctoremail.setAlpha(v);
        doctormobilnumber.setAlpha(v);
        doctorpassword.setAlpha(v);
        doctorcity.setAlpha(v);
        doctorbutton.setAlpha(v);


        doctorfullname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        doctoremail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        doctormobilnumber.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        doctorpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        doctorcity.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        doctorbutton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }

}
