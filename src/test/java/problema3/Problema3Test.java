package problema3;
import org.junit.Test;
import static org.junit.Assert.*;

public class Problema3Test {

    private final Problema3 problema = new Problema3();

    /* =======================
       IF 1: Estado de salud
       ======================= */

    @Test
    public void testNoPuedeRealizarActividadPorSalud() {
        String res = problema.recomendar(false, true, 20, 50, false, false, false, 10);
        assertEquals("No puede realizar ninguna actividad", res);
    }

    @Test
    public void testNoPuedeRealizarActividadPorSintomas() {
        String res = problema.recomendar(true, true, 20, 50, false, false, false, 10);
        assertEquals("No puede realizar ninguna actividad", res);
    }

    /* =====================
       IF 2: Clima extremo
       ===================== */

    @Test
    public void testQuedarseEnCasaPorLluviaYFrio() {
        String res = problema.recomendar(true, false, -5, 10, true, false, false, 20);
        assertEquals("Lo mejor es quedarse en casa", res);
    }

    @Test
    public void testQuedarseEnCasaPorNieveYFrio() {
        String res = problema.recomendar(true, false, -2, 10, false, true, false, 20);
        assertEquals("Lo mejor es quedarse en casa", res);
    }

    /* ================
       IF 3: Esquiar 
       ================ */

    @Test
    public void testEsquiarConAforoPermitido() {
        String res = problema.recomendar(true, false, -3, 10, false, false, false, 80);
        assertEquals("Se puede elegir las actividades relacionadas con esquiar", res);
    }

    @Test
    public void testEsquiarConAforoLimite() {
        String res = problema.recomendar(true, false, -3, 10, false, false, false, 100);
        assertEquals("Se puede elegir las actividades relacionadas con esquiar", res);
    }

    @Test
    public void testNoEsquiarPorAforoSuperado() {
        String res = problema.recomendar(true, false, -3, 10, false, false, false, 150);
        assertEquals("No se puede esquiar por superar el aforo permitido", res);
    }

    /* ==============================
       IF 4: Senderismo / Escalada
       ============================== */

    @Test
    public void testSenderismoConAforoPermitido() {
        String res = problema.recomendar(true, false, 10, 40, false, false, false, 50);
        assertEquals(
                "Es posible realizar algunas de las actividades relacionadas con senderismo o escalada",
                res
        );
    }

    @Test
    public void testSenderismoConAforoSuperado() {
        String res = problema.recomendar(true, false, 10, 40, false, false, false, 150);
        assertEquals(
                "No se puede realizar senderismo o escalada por aforo superado",
                res
        );
    }

    /* ===========================================
       IF 5: Catálogo primavera / verano / otoño
       =========================================== */

    @Test
    public void testCatalogoPrimaveraVeranoOtono() {
        String res = problema.recomendar(true, false, 20, 50, false, false, false, 30);
        assertEquals(
                "Se puede realizar cualquier actividad del catalogo de primavera, verano u otono",
                res
        );
    }

    /* ===============
       NO IF 5: No cumple condiciones de humedad alta o nublado 
       =============== */
    @Test
    public void testNoCatalogoPorHumedadAlta() {
        String res = problema.recomendar(true, false, 20, 80, false, false, false, 30);
        assertEquals("Puede realizar cualquiera de las actividades ofrecidas", res);
    }

    @Test
    public void testNoCatalogoPorNublado() {
        String res = problema.recomendar(true, false, 20, 50, false, false, true, 30);
        assertEquals("Puede realizar cualquiera de las actividades ofrecidas", res);
    }

    /* =======================
       IF 6: Playa / Piscina
       ======================= */

    @Test
    public void testPlayaOPiscinaConAforoPermitido() {
        String res = problema.recomendar(true, false, 36, 40, false, false, false, 90);
        assertEquals("La recomendacion es irse a la playa o a la piscina", res);
    }

    @Test
    public void testPlayaOPiscinaConAforoSuperado() {
        String res = problema.recomendar(true, false, 36, 40, false, false, false, 150);
        assertEquals("No se puede acceder a la piscina por superar el aforo permitido", res);
    }

    /* ==============================================
       IF 7: Actividades culturales / gastronómicas
       ============================================== */

    @Test
    public void testActividadesCulturalesConAforoPermitido() {
        String res = problema.recomendar(true, false, 28, 50, false, false, false, 80);
        assertEquals(
                "La recomendacion es realizar las actividades culturales o gastronomicas",
                res
        );
    }

    @Test
    public void testActividadesCulturalesConAforoSuperado() {
        String res = problema.recomendar(true, false, 28, 50, false, false, false, 200);
        assertEquals(
                "No se puede realizar actividades culturales o gastronomicas por aforo superado",
                res
        );
    }

    /* ================== 
       Caso por defecto:
       Ninguna condición específica se cumple
       ================== */

    @Test
    public void testCasoPorDefecto() {
        String res = problema.recomendar(true, false, 18, 80, true, false, true, 10);
        assertEquals("Puede realizar cualquiera de las actividades ofrecidas", res);
    }
}