package dmi.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_correo, et_contra;
    Button btn_registrar;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();

        et_nombre= findViewById(R.id.et_nombre);
        et_contra= findViewById(R.id.et_contra);
        et_correo=  findViewById(R.id.et_correo);
        btn_registrar= findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario= new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contra.getText().toString());

                firebaseDatabase.getReference().child("usuario").setValue(usuario);
            }
        });

    }
}
