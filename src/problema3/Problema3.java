package problema3;

public class Problema3 {
    private static final int aforoPermitido = 100;

    //Genera la recomendacion de actividad segun salud, condiciones meteorológicas y aforo.
    public String recomendar(boolean plenasFacultades, boolean sintomasEnfermedades, double temperatura, double humedadRelativa, boolean precipitacionesAgua, boolean precipitacionesNieve, boolean nublado, int aforoActual) {

        // Estado de salud: si no esta bien, no puede realizar nada
        if (!plenasFacultades || sintomasEnfermedades) {
            return "No puede realizar ninguna actividad";
        }

        // Bajo cero, humedad <15% y con precipitaciones de agua o nieve -> casa
        if (temperatura < 0 && humedadRelativa < 15 && (precipitacionesAgua || precipitacionesNieve)) {
            return "Lo mejor es quedarse en casa";
        }

        // Bajo cero, humedad <15% y sin precipitaciones -> esquiar si no se supera el aforo
        if (temperatura < 0 && humedadRelativa < 15 && !precipitacionesAgua && !precipitacionesNieve) {
            if (aforoActual <= aforoPermitido) {
                return "Se puede elegir las actividades relacionadas con esquiar";
            }
            return "No se puede esquiar por superar el aforo permitido";
        }

        // 0 a 15 grados y sin lluvia -> senderismo/escalada si no supera aforo
        if (temperatura >= 0 && temperatura < 15 && !precipitacionesAgua) {
            if (aforoActual <= aforoPermitido) {
                return "Es posible realizar algunas de las actividades relacionadas con senderismo o escalada";
            }
            return "No se puede realizar senderismo o escalada por aforo superado";
        }

        // 15 a 25 grados, sin lluvia, sin nubes y humedad <=60% -> catalogo primavera/verano/otoño
        if (temperatura >= 15 && temperatura < 25 && !precipitacionesAgua && !nublado && humedadRelativa <= 60) {
            return "Se puede realizar cualquier actividad del catalogo de primavera, verano u otono";
        }

        // Mas de 30 grados y sin lluvia -> playa o piscina si no supera aforo
        if (temperatura > 30 && !precipitacionesAgua) {
            if (aforoActual <= aforoPermitido) {
                return "La recomendacion es irse a la playa o a la piscina";
            }
            return "No se puede acceder a la piscina por superar el aforo permitido";
        }

        // 25 a 35 grados y sin lluvia -> actividades culturales/gastronomicas si no supera aforo
        if (temperatura >= 25 && temperatura <= 35 && !precipitacionesAgua) {
            if (aforoActual <= aforoPermitido) {
                return "La recomendacion es realizar las actividades culturales o gastronomicas";
            }
            return "No se puede realizar actividades culturales o gastronomicas por aforo superado";
        }

        // Resto de condiciones no recogidas de forma explicita
        return "Puede realizar cualquiera de las actividades ofrecidas";
    }
}
