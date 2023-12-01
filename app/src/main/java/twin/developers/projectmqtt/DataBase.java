package twin.developers.projectmqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.base.MoreObjects;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DataBase extends AppCompatActivity {

    Button enviar;

EditText mensajes;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        enviar = findViewById(R.id.btnMandar);
        mensajes = findViewById(R.id.txtMandar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("mensajes").
                        setValue(mensajes.getText().toString());
                mensajes.setText("");
                Toast.makeText(DataBase.this,"El mensaje fue enviado", Toast.LENGTH_SHORT).show();

            }
        });



    }
}