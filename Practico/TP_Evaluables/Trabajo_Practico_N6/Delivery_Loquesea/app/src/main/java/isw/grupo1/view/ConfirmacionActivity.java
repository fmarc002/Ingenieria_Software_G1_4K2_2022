package isw.grupo1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import isw.grupo1.MainActivity;
import isw.grupo1.R;

public class ConfirmacionActivity extends AppCompatActivity {

    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        btnInicio = findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(view -> mostrarInicio());
    }

    private void mostrarInicio() {
        //Intent intentInicio = new Intent(Intent.ACTION_MAIN);
        //intentInicio.addCategory(Intent.CATEGORY_HOME);
        //intentInicio.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(intentInicio);
        //finish();
        navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
    }
}