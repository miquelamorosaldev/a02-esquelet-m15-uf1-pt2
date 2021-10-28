package adnmanagers;

/**
 *
 * @author DAWBIO2-M15-UF1-2021/2022
 */
public class ADN_Manager {

    private int basesA = 0;
    private int basesT = 0;
    private int basesC = 0;
    private int basesG = 0;
    private int basesU_ARN = 0;
    
    public ADN_Manager() {
        resetADN();
    }
    
    /**
     * Resetea la última cadena de ADN o ARN guardada.
     */
    private void resetADN() {
        basesA = 0;
        basesT = 0;
        basesG = 0;
        basesC = 0;
        basesU_ARN = 0;
    }
    
    public boolean validarADN(String cadenaADN) {
        resetADN();
        // Passem la cadena a majúscules per evitar errors.
        cadenaADN=cadenaADN.toUpperCase();
        boolean cadenaADNValida = true;
        // Guardem les bases d'ADN de la seqüència.
        int index = 0;
        
        // Sol1. Convertir la cadena en un array
        // de carácters.
        char[] caractersADN = cadenaADN.toCharArray();
        
        for (char c : caractersADN) {
            index++;
            // Caso 1 Verificar si el carácter es uno de
            // los que puede tener el ADN.
            switch (c) {
                case 'A':
                    basesA ++;
                    break;
                case 'T':
                    basesT ++;
                    break;
                case 'G':
                    basesG ++;
                    break;
                case 'C':
                    basesC ++;
                    // Caso 2
                    // Si el carácter no esta dentro del ADN.
                    break;
                default:
                    cadenaADNValida = false;
                    // A JUnit no li agrada aquest mètode.
                    // resultadoValidacionCadena(index);
                }
            }
        return cadenaADNValida;
    }

    /** 
     * Método para mostrar el resultado de validación de una cadena
     * ADN o ARN (sacado por refracción)
     * @param index 
     */
    private void resultadoValidacionCadena(int index) {
        System.out.println("Error. Secuencia no válida.");
        System.out.println("En la posición " +
                index + " hay un carácter que no es válido.");
        System.exit(0);
    }
    
    
    public boolean validarARN(String cadenaARN) {
        resetADN();
        boolean cadenaARNValida = false;
        // Guardem les bases d'ADN de la seqüència.
        int index = 0;
        // Passem la cadena a majúscules per evitar errors.
        cadenaARN=cadenaARN.toUpperCase();
        
        // Sol1. Convertir la cadena en un array
        // de carácters.
        char[] caractersADN = cadenaARN.toCharArray();
        
        for (char c : caractersADN) {
            index++;
            // Caso 1 Verificar si el carácter es uno de
            // los que puede tener el ADN.
            switch (c) {
                case 'A':
                    basesA ++;
                    break;
                case 'U':
                    basesU_ARN ++;
                    break;
                case 'G':
                    basesG ++;
                    break;
                case 'C':
                    basesC ++;
                    // Caso 2
                    // Si el carácter no esta dentro del ADN.
                    break;
                default:
                     cadenaARNValida = false;
                    // A JUnit no li agrada aquest mètode.
                    // resultadoValidacionCadena(index);
                }
            }
        return cadenaARNValida;
    }
    
    /**
     * Funcio que agafa l'atribut ADN i el converteix amb una cadena ARN.
     * @param cadenaADN, String cadena ADN.
     * @return ARN, String cadena ARN.
     */
    public String convertADNtoARN(String cadenaADN) {
        String cadenaARN = "";
        /* Primerament validem l'ADN */
        if (validarADN(cadenaADN)) {
            // Té un rendiment relativament bo el mètode.
            cadenaARN = cadenaADN.replaceAll("T","U");
        }
        return cadenaARN;
    }
    
    /**
     * Funcio que agafa l'atribut ADN i el retorna invertit
     *
     * @return ADN invertit.
     */
    public String invertADN(String ADN) {
        StringBuilder builder = new StringBuilder();
        if(validarADN(ADN)) {
            builder = new StringBuilder(ADN);
        }
        return builder.reverse().toString();
    }

    /**
     * Fa recompte de totes les A's i retorna la quantitat
     *
     * @return Numero de adenines acumulades a tota la cadena
     */
    public int numAdenines(String ADN) {
        int a = 0;
        //char[] letter = this.adn.toUpperCase().toCharArray();
        for (int i = 0; i < ADN.length(); i++) {
            if (ADN.toUpperCase().charAt(i) == 'A') {
                a++;
            }
        }
        return a;
    }

    /**
     * Funcio que per obtenir la base més repetida de la cadena ADN.
     *
     * @return La lletra que té mes recompte que la resta
     */
    public String baseADNMesRepetida(String ADN) {
        int max = 0;
        String base;
        int a = basesA;
        int c = basesC;
        int g = basesG;
        int t = basesT;

        if (a > c && a > g && a > t) {
            base = "A";
            max = a;
        } else if (c > a && c > g && c > t) {
            base = "C";
            max = c;
        } else if (g > a && g > c && g > t) {
            base = "G";
            max = g;
        } else {
            base = "T";
            max = t;
        }

        return base;
    }
 /**
     * Funcio que compara el recompte de totes les lletres
     *
     * @return La lletra que té menys recompte que la resta
     * 
     */
    public String minLetter(String ADN) {
        int min = 0;
        String base;
        int a = basesA;
        int c = basesC;
        int g = basesG;
        int t = basesT;

        if (a < c && a < g && a < t) {
            base = "A";
            min = a;
        } else if (c < a && c < g && c < t) {
            base = "C";
            min = c;
        } else if (g < a && g < c && g < t) {
            base = "G";
            min = g;
        } else {
            base = "T";
            min = t;
        }

        return base;
    }
}
