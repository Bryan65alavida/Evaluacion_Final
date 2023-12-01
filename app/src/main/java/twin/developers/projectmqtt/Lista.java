package twin.developers.projectmqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lista extends AppCompatActivity {

    Button agregar, tarea, btnFireBD;
    EditText tarea_nueva;
    TextView lista_tareas;
    String lista;
    String tn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        agregar = findViewById(R.id.btnAdd);
        tarea_nueva  = findViewById(R.id.etTarea);
        lista_tareas = findViewById(R.id.txtLista);
        tarea = findViewById(R.id.btnTarea);
        btnFireBD = findViewById(R.id.btnFireBD);
        btnFireBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lista.this, DataBase.class));
            }
        });




        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista=lista_tareas.getText().toString();
                tn=tarea_nueva.getText().toString();
                lista= lista + "\n" + tn;
                lista_tareas.setText(lista);
            }
        });

        tarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(Lista.this, MainActivity.class));
            }
        });
    }
}