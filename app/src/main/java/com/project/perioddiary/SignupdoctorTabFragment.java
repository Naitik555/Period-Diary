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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.perioddiary.DashBoard.DoctorDash;

import org.w3c.dom.Text;

public class SignupdoctorTabFragment extends Fragment {
    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    EditText doctorfullname;
    EditText doctoremail;
    EditText doctormobilnumber;
    EditText doctorpassword;
    EditText doctorcity;
    Button doctorbutton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

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



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getContext(),MainActivity.class));
        }


        doctorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("doctor");

                final String demail = doctoremail.getText().toString().trim();
                String dpassword = doctorpassword.getText().toString().trim();
                final String dfullname = doctorfullname.getText().toString();
                final String dmobilenumber    = doctormobilnumber.getText().toString();
                final String dcity = doctorcity.getText().toString();

                doctoruserclass doctorhelperClass = new doctoruserclass(demail , dpassword, dfullname , dmobilenumber , dcity);
                reference.child(dmobilenumber).setValue(doctorhelperClass);



                if(TextUtils.isEmpty(demail)){
                    doctoremail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(dfullname)){
                    doctorfullname.setError("Full Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(dcity)){
                    doctorcity.setError("City is Required.");
                    return;
                }

                if(TextUtils.isEmpty(dpassword)){
                    doctorpassword.setError("Password is Required.");
                    return;
                }

                if(dpassword.length() < 6){
                    doctorpassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(TextUtils.isEmpty(dmobilenumber)){
                    doctormobilnumber.setError("Mobilnumber is Required.");
                    return;
                }

                if(dmobilenumber.length() == 9){
                    doctormobilnumber.setError("Mobilnumber Must be = 10 intigers");
                    return;
                }



                fAuth.createUserWithEmailAndPassword(demail,dpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getContext(),"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), DoctorDash.class));



                        }else {
                            Toast.makeText(getContext(),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });





            }
        });


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
