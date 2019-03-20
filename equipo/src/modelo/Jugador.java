package modelo;

public class Jugador {
	
	private String nombreJugador;
	private String numero;
	private String tipoPosicion;
	
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoPosicion() {
		return tipoPosicion;
	}
	public void setTipoPosicion(String tipoPosicion) {
		this.tipoPosicion = tipoPosicion;
	}
	@Override
	public String toString() {
		return " [nombreJugador=" + nombreJugador + ", numero="
				+ numero + ", tipoPosicion=" + tipoPosicion ;
	}
	

}
