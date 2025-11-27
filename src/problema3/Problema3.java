package problema3;

public class Problema3 {
	static int aforo_permitido = 100;
	public String recomendar(boolean plenas_facultades, boolean sintomas_enfermedades, double temperatura, double humedad_relativa, boolean precipitaciones_agua, boolean precipitaciones_nieve, int aforo) {
		String res = "";
		if (plenas_facultades && !sintomas_enfermedades) {
			if (temperatura < 0 && humedad_relativa < 15 && (precipitaciones_agua || precipitaciones_nieve)) {
				res = "Lo mejor es quedarse en casa";
			} else if (temperatura < 0 && humedad_relativa < 15 && aforo <= aforo_permitido) {
				res = "Se puede elegir las actividades relacionadas con esquiar";
			} else if (temperatura >= 0 && temperatura <= 15 && !precipitaciones_agua && aforo <= aforo_permitido) {
				res = "Es posible realizar algunas de las actividades relacionadas con senderismo o escalada";
			}
		} else {
			res = "No puede realizar ninguna actividad";
        }
		return res;
	}
}
