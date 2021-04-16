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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.perioddiary.DashBoard.DoctorDash;

public class LogindoctorTabFragment extends Fragment {
       EditText logemaildoctor;
       EditText logpassworddoctor;
       TextView forgetpassworddoctor;
       Button logindoctor;
       FirebaseAuth fAuth;
       FirebaseFirestore fStore;
       float v=0;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.logindoctor_tab_fragment,container,  false);

        logemaildoctor = root.findViewById(R.id.logemaildoctor);
        logpassworddoctor = root.findViewById((R.id.logpassworddoctor));
        forgetpassworddoctor = root.findViewById(R.id.forgetpassworddoctor);
        logindoctor = root.findViewById(R.id.logindoctor);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        logindoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String demail =logemaildoctor.getText().toString().trim();
                String dpassword = logpassworddoctor.getText().toString().trim();




                if(TextUtils.isEmpty(demail)){
                    logemaildoctor.setError("Email is Required.");
                    return;
                }



                if(TextUtils.isEmpty(dpassword)){
                    logpassworddoctor.setError("Password is Required.");
                    return;
                }

                if(dpassword.length() < 6){
                    logpassworddoctor.setError("Password Must be >= 6 Characters");
                    return;
                }


               fAuth.signInWithEmailAndPassword(demail,dpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {

                       if(task.isSuccessful()){
                           Toast.makeText(getContext(),"login successfully",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getContext(), DoctorDash.class));

                       }
                       else {
                           Toast.makeText(getContext(),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                       }
                   }
               });

            }
        });


        logemaildoctor.setTranslationX(800);
        logpassworddoctor.setTranslationX(800);
        forgetpassworddoctor.setTranslationX(800);
        logindoctor.setTranslationX(800);

        logemaildoctor.setAlpha(v);
        logpassworddoctor.setAlpha(v);
        forgetpassworddoctor.setAlpha(v);
        logindoctor.setAlpha(v);


        logemaildoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        logpassworddoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpassworddoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        logindoctor.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();



        return root;
    }
}
