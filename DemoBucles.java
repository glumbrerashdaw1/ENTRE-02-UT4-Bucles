import java.util.Random;
/**
 *    @author - Gaizka Lumbreras Huarte
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int potencia = 2;

        while(potencia * 2 <= numero) {
            potencia *= 2;
        }
        return potencia;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int valor = numero;
        int pot = mayorPotencia2(valor);

        System.out.println("\n");
        System.out.printf("%6s",numero + " =", "%6d",pot);

        while(pot < valor) {
            valor -= pot;
            pot = mayorPotencia2(valor);
            System.out.printf("%6d", pot);
        }
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 0 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int aleat = 1;
        int cont = 0;

        System.out.printf("%s", "Nºs aleatorios como suma de potencias de 2");

        while(aleat != 0 && cont < n ) {
            aleat = generador.nextInt(256);
            escribirSumaPotencias(aleat);
            cont++;
        }

        if(aleat == 0) {
            System.out.println("\nBucle terminado porque salió el " + aleat);
        } else {
            System.out.println("\nBucle terminado porque se han generado ya " 
                + cont + " aleatorios");
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%c", caracter);
        }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        for(int contEsca = 0; contEsca < escalones; contEsca++) {
            for(int contAlt = 1; contAlt <= alto; contAlt++) {
                System.out.print("\n");
                for(int contEsp = 1; contEsp <= (ancho * contEsca); contEsp++) {
                    System.out.print(ESPACIO);
                }
                escribirCaracter(ancho, ASTERISCO);
            }
        }
    }
}