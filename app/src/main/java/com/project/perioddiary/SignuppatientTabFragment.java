package com.project.perioddiary;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import com.project.perioddiary.DashBoard.PatientDash;
import com.project.perioddiary.calendar.CalendarActivity;

public class SignuppatientTabFragment extends Fragment {
    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


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

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getContext(),MainActivity.class));
        }


        patientbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("patient");

                final String pemail = patientemail.getText().toString().trim();
                String ppassword = patientpassword.getText().toString().trim();
                final String pfullname = patientfullname.getText().toString();
                final String pmobilenumber    = patientmobilnumber.getText().toString();

                patientuserclass patienthelperClass = new patientuserclass(pemail, pfullname, ppassword , pmobilenumber);
                reference.child(pmobilenumber).setValue(patienthelperClass);



                if(TextUtils.isEmpty(pemail)){
                    patientemail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(pfullname)){
                    patientfullname.setError("Full Name is Required.");
                    return;
                }

//                if(TextUtils.isEmpty(dcity)){
//                    doctorcity.setError("City is Required.");
//                    return;
//                }
                if(TextUtils.isEmpty(ppassword)){
                    patientpassword.setError("Password is Required.");
                    return;
                }

                if(ppassword.length() < 6){
                    patientpassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(TextUtils.isEmpty(pmobilenumber)){
                    patientmobilnumber.setError("Mobilnumber is Required.");
                    return;
                }

                if(pmobilenumber.length() == 9){
                    patientmobilnumber.setError("Mobilnumber Must be = 10 intigers");
                    return;
                }



                fAuth.createUserWithEmailAndPassword(pemail,ppassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getContext(),"User Created",Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(getContext(), PatientDash.class));


                        }else {
                            Toast.makeText(getContext(),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });





            }
        });




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
