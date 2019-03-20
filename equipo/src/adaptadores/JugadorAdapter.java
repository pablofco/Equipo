package adaptadores;

import java.util.ArrayList;

import com.example.equipo.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import modelo.Jugador;

public class JugadorAdapter extends ArrayAdapter<Jugador> {

	private ArrayList<Jugador> equipoAdapter;
	private LayoutInflater inflador;

	public JugadorAdapter(Activity actividad, ArrayList<Jugador> equipo) {
		super(actividad, R.layout.fila,equipo);
		this.equipoAdapter = equipo;
		this.inflador = actividad.getLayoutInflater();

	}

	public View getView(int posicion, View fila, ViewGroup contenedorDeLasFilas) {
		try {
			if (fila == null) {
				fila = inflador.inflate(R.layout.fila, contenedorDeLasFilas,
						false);
			}
			Jugador e = equipoAdapter.get(posicion);
			TextView nombreJugadorFila = (TextView) fila
					.findViewById(R.id.nombreJugadorFila);
			TextView numeroFila = (TextView) fila.findViewById(R.id.numeroFila);

			ImageView iconoFila = (ImageView) fila.findViewById(R.id.iconoFila);
			if (e.getTipoPosicion().equals("base")) {
				iconoFila.setImageResource(R.drawable.base);
			} else if (e.getTipoPosicion().equals("alero")) {
				iconoFila.setImageResource(R.drawable.alero);
			} else if (e.getTipoPosicion().equals("escolta")) {
				iconoFila.setImageResource(R.drawable.escolta);
			} else if (e.getTipoPosicion().equals("ala pivot")) {
				iconoFila.setImageResource(R.drawable.alapivot);
			} else if (e.getTipoPosicion().equals("pivot")) {
				iconoFila.setImageResource(R.drawable.pivot);
			}

			nombreJugadorFila.setText(e.getNombreJugador());
			numeroFila.setText(e.getNumero());
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
		}

		return fila;
	}
}
