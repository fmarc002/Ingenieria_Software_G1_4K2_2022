package isw.grupo1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import isw.grupo1.R;

public class DomicilioEntregaActivity extends AppCompatActivity {

    private Button btnSiguiente;
    private Spinner spnCiudades;
    private EditText etCalle;
    private EditText etNro;
    private EditText etReferencia;
    private ImageButton imgBtnMapa;
    private TextInputLayout tilCalleRetiro, tilNroCalleRetiro, tilReferenciaRetiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domicilio_entrega);
        spnCiudades = findViewById(R.id.spnCiudadesEntrega);
        cargarVistas();
        cargarCiudades();

    }

    private void cargarCiudades(){
        List<String> ciudadesList =  new ArrayList<String>();
        ciudadesList.add("Carlos Paz");
        ciudadesList.add("Córdoba");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, ciudadesList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCiudades.setAdapter(adapter);
    }

    private void cargarVistas(){
        spnCiudades = (Spinner) findViewById(R.id.spnCiudadesEntrega);
        btnSiguiente= findViewById(R.id.btnSiguiente);
        etCalle = findViewById(R.id.etCalleRetiro);
        etNro = findViewById(R.id.etNumeroCalleRetiro);
        etReferencia = findViewById(R.id.etReferenciaRetiro);
        tilCalleRetiro = findViewById(R.id.tilCalleRetiro);
        tilNroCalleRetiro = findViewById(R.id.tilNumCalleRetiro);
        tilReferenciaRetiro = findViewById(R.id.tilReferenciaRetiro);
    }
}