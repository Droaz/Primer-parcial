package com.example.parcial_diaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText empleado, salario, horas, vlr_horas, pension, salud, salario_total;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empleado=findViewById(R.id.val_empleado);
        salario=findViewById(R.id.val_salario);
        horas=findViewById(R.id.val_horas_x);
        vlr_horas=findViewById(R.id.val_vlr_extra);
        pension=findViewById(R.id.val_pension);
        salud=findViewById(R.id.val_salud);
        salario_total=findViewById(R.id.val_salario_total);

        calcular=findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double d_salario =Double.parseDouble(salario.getText().toString());
                double d_horas =Double.parseDouble(horas.getText().toString());
                double d_valor =Double.parseDouble(vlr_horas.getText().toString());

                if(TextUtils.isEmpty(salario.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Ingrese Salario", Toast.LENGTH_LONG).show();
                }else{

                    double salario_bruto=d_salario+(d_horas*d_valor);
                    double desc_pension=(salario_bruto*0.04);
                    pension.setText(String.valueOf(desc_pension));
                    double desc_salud=(salario_bruto*0.04);
                    salud.setText(String.valueOf(desc_salud));
                    double d_salario_total=(salario_bruto-(desc_pension+desc_salud));
                    salario_total.setText(String.valueOf(d_salario_total));


                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        int smvl=980657;
        if(id==R.id.Salario_Minimo){
            salario.setText(String.valueOf(smvl));
        }

        if(id==R.id.Limpiar_Datos){
            empleado.setText("");
            salario.setText("");
            horas.setText("");
            vlr_horas.setText("");
            pension.setText("");
            salud.setText("");
            salario_total.setText("");
        }

        return super.onOptionsItemSelected(item);

    }

}