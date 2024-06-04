/*
 * EJERCICIO 1:
 * 
 * Un marcapasos debe funcionar consumiendo la menor cantidad de energía posible 
 * y ser lo más barato posible, por lo que incluye una mínima cantidad de memoria.
 * 
 * Con sus sensores obtiene continuamente las siguientes medidas, con los 
 * rangos que se indican:
 * 
 *     - Presión Sanguínea (0-250)
 *     - Frecuencia cardíaca (0-226)
 *     - Nivel de azúcar en sangre. (0 - 1000).
 * 
 * Además, para autodiagnóstico mantiene un registro de:
 * 
 *     - Máxima fuerza a la que fue expuesto (0-3.000.000.000).
 *     - Mínimo tiempo entre latidos (0-100 con decimales).
 *     - Batería restante. (% de batería restante con decimales con la mayor precisión posible).
 *     - Código del Fabricante (Números y letras, máximo 8 caracteres).
 * 
 * Trabajo a realizar:
 * 
 * a) Crear una clase "Marcapasos" que contenga variables para almacenar esta 
 * información. Utilice los tipos de datos primitivos de java teniendo en cuenta que se 
 * quiere consumir la menor cantidad de memoria posible.
 * 
 * b) Calcular cuánta memoria consume un objeto de su clase (considerando solamente el 
 * espacio ocupado por las variables indicadas).
 * 
 * c) Responder las preguntas presentadas en pantalla.
 */

package ut1;

 public class Marcapasos {
    private short presionSanguinea;     // 2 bytes.
    private byte frecuenciaCardiaca;    // 1 byte.
    private int nivelAzucarSangre;      // 4 bytes.
    private int maxFuerzaExposicion;    // 4 bytes.
    private float minTiempoLatidos;     // 4 bytes. (No uso un double para no desperdiciar espacio)
    private float bateriaRestante;      // 4 bytes. (Idem al anterior)
    private String codigoFabricante;    // Variable.

    // 1 byte + 2 byte + 4 bytes + 4 bytes + 4 bytes + 4 bytes + (8 bytes + 2 bytes * longitud del código del fabricante)

    public Marcapasos(short presionSanguinea, byte frecuenciaCardiaca, int nivelAzucarSangre,
    int maxFuerzaExposicion, float minTiempoLatidos, float bateriaRestante,
    String codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucarSangre = nivelAzucarSangre;
        this.maxFuerzaExposicion = maxFuerzaExposicion;
        this.minTiempoLatidos = minTiempoLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }
}
