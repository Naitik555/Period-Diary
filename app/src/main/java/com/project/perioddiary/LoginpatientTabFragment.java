package com.project.perioddiary;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginpatientTabFragment extends Fragment {

    EditText logpatientemail;
    EditText logpatientpassword;
    TextView forgetpasswordpatient;
    Button loginpatient;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    float v=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.loginpatient_tab_fragment,container,  false);

        logpatientemail = root.findViewById(R.id.logpatientemail);
        logpatientpassword = root.findViewById((R.id.logpatientpassword));
        forgetpasswordpatient = root.findViewById(R.id.forgetpasswordpatient);
        loginpatient = root.findViewById(R.id.loginpatient);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        loginpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pemail =logpatientemail.getText().toString().trim();
                String ppassword = logpatientpassword .getText().toString().trim();




                if(TextUtils.isEmpty(pemail)){
                    logpatientemail.setError("Email is Required.");
                    return;
                }



                if(TextUtils.isEmpty(ppassword)){
                    logpatientpassword.setError("Password is Required.");
                    return;
                }

                if(ppassword.length() < 6){
                    logpatientpassword.setError("Password Must be >= 6 Characters");
                    return;
                }


                fAuth.signInWithEmailAndPassword(pemail,ppassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(getContext(),"login successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(),MainActivity.class));

                        }
                        else {
                            Toast.makeText(getContext(),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });






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
