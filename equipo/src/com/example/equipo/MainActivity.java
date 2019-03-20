package com.example.equipo;

import java.util.ArrayList;

import modelo.Jugador;
import adaptadores.JugadorAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText campoNombre;
	private EditText campoNumero;
	private Button botonRegistro;
	private RadioGroup tipoEquipo;

	private ListView listViewEquipo;
	private JugadorAdapter adaptador;

	ArrayList<Jugador> equipo = new ArrayList<Jugador>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		campoNombre = (EditText) findViewById(R.id.campoNombre);
		campoNumero = (EditText) findViewById(R.id.campoNumero);
		botonRegistro = (Button) findViewById(R.id.botonRegistrar);

		tipoEquipo = (RadioGroup) findViewById(R.id.tipoPosicion);
		listViewEquipo = (ListView) findViewById(R.id.listViewEquipo);
		adaptador = new JugadorAdapter(this, equipo);

		listViewEquipo.setAdapter(adaptador);

		botonRegistro.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		try {
			String nombreJugador = campoNombre.getText().toString();
			String numero = campoNumero.getText().toString();

			Context context = getApplicationContext();
			String text = "quiero registrar:" + nombreJugador + " " + numero;
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

			Jugador nuevo = new Jugador();
			nuevo.setNombreJugador(nombreJugador);
			nuevo.setNumero(numero);
			switch (tipoEquipo.getCheckedRadioButtonId()) {
			case R.id.base:
				nuevo.setTipoPosicion("base");
				break;
			case R.id.alero:
				nuevo.setTipoPosicion("alero");
				break;
			case R.id.escolta:
				nuevo.setTipoPosicion("escolta");
			case R.id.alaPivot:
				nuevo.setTipoPosicion("ala-Pivot");
			case R.id.pivot:
				nuevo.setTipoPosicion("pivot");

			default:
				break;
			}
			adaptador.add(nuevo);
			equipo.add(nuevo);

		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
		}

	}

}
