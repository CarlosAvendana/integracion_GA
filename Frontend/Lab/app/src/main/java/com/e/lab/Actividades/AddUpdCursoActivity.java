package com.e.lab.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.e.lab.AccesoDatos.AsyncResponse;
import com.e.lab.AccesoDatos.NetManager;
import com.e.lab.LogicaNeg.Curso;
import com.e.lab.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class AddUpdCursoActivity extends AppCompatActivity {

    private FloatingActionButton fBtn;
    private boolean editable = true;

    private EditText codFld; //1
    private EditText nomFld; //2
    private EditText creditosFld; //3
    private EditText horasFld; //4
    private EditText carrera_codigo;//5
    private EditText anio;//6
    private EditText ciclo;//7


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upd_curso);
        editable = true;

        // button check
        fBtn = findViewById(R.id.addUpdCursoBtn);

        //cleaning stuff
        codFld = findViewById(R.id.codigoAddUpdCur);
        nomFld = findViewById(R.id.nombreAddUpdCur);
        creditosFld = findViewById(R.id.creditosAddUpdCur);
        horasFld = findViewById(R.id.horasAddUpdCur);
        carrera_codigo = findViewById(R.id.carrera_codigoAddUpdCur);
        anio = findViewById(R.id.anioAddUpdCur);
        ciclo = findViewById(R.id.cicloAddUpdCur);

        codFld.setText("");
        nomFld.setText("");
        creditosFld.setText("");
        horasFld.setText("");
        carrera_codigo.setText("");
        anio.setText("");
        ciclo.setText("");

        //receiving data from admCursoActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Curso aux = (Curso) getIntent().getSerializableExtra("curso");
                codFld.setText(aux.getCodigo());
                codFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                creditosFld.setText(Integer.toString(aux.getCreditos()));
                horasFld.setText(Integer.toString(aux.getHoras()));

                carrera_codigo.setText(aux.getCarrera_codigo());
                carrera_codigo.setEnabled(false);
                anio.setText(aux.getAnio());
                ciclo.setText(aux.getCiclo());

                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editCurso();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addCurso();
                    }
                });
            }
        }
    }

    public void addCurso() {
        if (validateForm()) {
            //do something
            Curso cur = new Curso(codFld.getText().toString(),
                    carrera_codigo.getText().toString(),
                    anio.getText().toString(),
                    ciclo.getText().toString(),
                    nomFld.getText().toString(),
                    Integer.parseInt(creditosFld.getText().toString()),
                    Integer.parseInt(horasFld.getText().toString()));


            String cod = codFld.getText().toString();
            String carrera_codigo_ = carrera_codigo.getText().toString();
            String anio_ = anio.getText().toString();
            String ciclo_ = ciclo.getText().toString();
            String nombre = nomFld.getText().toString();
            int creditos = Integer.parseInt(creditosFld.getText().toString());
            int horas_ = Integer.parseInt(horasFld.getText().toString());

            JSONObject curso_ = new JSONObject();
            try {
                curso_.put("codigo", cod);
                curso_.put("carrera_codigo", carrera_codigo_);
                curso_.put("anio", anio_);
                curso_.put("ciclo", ciclo_);
                curso_.put("nombre", nombre);
                curso_.put("creditos", creditos);
                curso_.put("horas_semanales", horas_);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            NetManager net = new NetManager("http://192.168.100.10:8084/GestionAcademica/Server_Movil_Curso", new AsyncResponse() {
                @Override
                public void processFinish(String output) {

                }
            });
            net.execute(NetManager.PUT, curso_.toString());


            Intent intent = new Intent(getBaseContext(), AdmCursoActivity.class);
            //sending curso data
            intent.putExtra("addCurso", cur);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public void editCurso() {
        if (validateForm()) {
            Curso cur = new Curso(codFld.getText().toString(),
                    carrera_codigo.getText().toString(),
                    anio.getText().toString(),
                    ciclo.getText().toString(),
                    nomFld.getText().toString(),
                    Integer.parseInt(creditosFld.getText().toString()),
                    Integer.parseInt(horasFld.getText().toString()));


            String cod = codFld.getText().toString();
            String carrera_codigo_ = carrera_codigo.getText().toString();
            String anio_ = anio.getText().toString();
            String ciclo_ = ciclo.getText().toString();
            String nombre = nomFld.getText().toString();
            int creditos = Integer.parseInt(creditosFld.getText().toString());
            int horas_ = Integer.parseInt(horasFld.getText().toString());

            JSONObject curso_ = new JSONObject();
            try {
                curso_.put("codigo", cod);
                curso_.put("carrera_codigo", carrera_codigo_);
                curso_.put("anio", anio_);
                curso_.put("ciclo", ciclo_);
                curso_.put("nombre", nombre);
                curso_.put("creditos", creditos);
                curso_.put("horas_semanales", horas_);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            NetManager net = new NetManager("http://192.168.100.10:8084/GestionAcademica/Server_Movil_Curso", new AsyncResponse() {
                @Override
                public void processFinish(String output) {

                }
            });
            net.execute(NetManager.POST, curso_.toString());


            Intent intent = new Intent(getBaseContext(), AdmCursoActivity.class);
            //sending curso data
            intent.putExtra("editCurso", cur);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.nomFld.getText())) {
            nomFld.setError("Nombre requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.codFld.getText())) {
            codFld.setError("Codigo requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.creditosFld.getText())) {
            creditosFld.setError("Creditos requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.horasFld.getText())) {
            horasFld.setError("Horas requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Algunos errores", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
