/**
 * @author Grupo Databased
 * @see https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 */
package databased.vista;

import java.util.ArrayList;

public class ColoresConsola {
    protected ArrayList<String> colores;

    public ColoresConsola() {
        this.colores = new ArrayList<>();
        colores.add("\033[0m");         //  0 - Text Reset
                        // Regular colors
        colores.add("\033[0;30m");      //  1 - Black
        colores.add("\033[0;31m");      //  2 - Red
        colores.add("\033[0;32m");      //  3 - Green
        colores.add("\033[0;33m");  	//  4 - Yellow
        colores.add("\033[0;34m");    	//  5 - Blue
        colores.add("\033[0;35m");  	//  6 - Purple
        colores.add("\033[0;36m");    	//  7 - Cyan
        colores.add("\033[0;37m");   	//  8 - White
                        // Bold
        colores.add("\033[1;30m");  	//  9 - Black
        colores.add("\033[1;31m");		// 10 - Red
        colores.add("\033[1;32m");  	// 11 - Green
        colores.add("\033[1;33m"); 		// 12 - Yellow
        colores.add("\033[1;34m");   	// 13 - Blue
        colores.add("\033[1;35m"); 		// 14 - Purple
        colores.add("\033[1;36m");   	// 15 - Cyan
        colores.add("\033[1;37m");  	// 16 - White
                        // Underline
        colores.add("\033[4;30m");  	// 17 - Black
        colores.add("\033[4;31m");    	// 18 - Red
        colores.add("\033[4;32m");  	// 19 - Green
        colores.add("\033[4;33m"); 		// 20 - Yellow
        colores.add("\033[4;34m");   	// 21 - Blue
        colores.add("\033[4;35m"); 		// 22 - Purple
        colores.add("\033[4;36m");   	// 23 - Cyan
        colores.add("\033[4;37m");  	// 24 - White
                        // Background
        colores.add("\033[40m");  		// 25 - Black
        colores.add("\033[41m");    	// 26 - Red
        colores.add("\033[42m");  		// 27 - Green
        colores.add("\033[43m"); 		// 28 - Yellow
        colores.add("\033[44m");   		// 29 - Blue
        colores.add("\033[45m"); 		// 30 - Purple
        colores.add("\033[46m");   		// 31 - Cyan
        colores.add("\033[47m");  		// 32 - White
                        // High Intensity
        colores.add("\033[0;90m");   	// 33 - Black
        colores.add("\033[0;91m");   	// 34 - Red
        colores.add("\033[0;92m");   	// 35 - Green
        colores.add("\033[0;93m");   	// 36 - Yellow
        colores.add("\033[0;94m");   	// 37 - Blue
        colores.add("\033[0;95m");   	// 38 - Purple
        colores.add("\033[0;96m");   	// 39 - Cyan
        colores.add("\033[0;97m");   	// 40 - White
                        // Bold High Intensity
        colores.add("\033[1;90m");   	// 41 - Black
        colores.add("\033[1;91m");   	// 42 - Red
        colores.add("\033[1;92m");   	// 43 - Green
        colores.add("\033[1;93m");   	// 44 - Yellow
        colores.add("\033[1;94m");   	// 45 - Blue
        colores.add("\033[1;95m");   	// 46 - Purple
        colores.add("\033[1;96m");   	// 47 - Cyan
        colores.add("\033[1;97m");   	// 48 - White
                        // High Intensity backgrounds
        colores.add("\033[0;100m");   	// 49 - Black
        colores.add("\033[0;101m");   	// 50 - Red
        colores.add("\033[0;102m");   	// 51 - Green
        colores.add("\033[0;103m");   	// 52 - Yellow
        colores.add("\033[0;104m");   	// 53 - Blue
        colores.add("\033[0;105m");   	// 54 - Purple
        colores.add("\033[0;106m");   	// 55 - Cyan
        colores.add("\033[0;107m");   	// 56 - White
                        // Italic
        colores.add("\033[3m");			// 57 - Italic
    }

    /**
     * Método que devuelve un String pasado por parámetro en el color de consola escogido mediante la posición del array
     * @author Grupo Databased
     * @param texto Texto a colorear por consola
     * @param color Posición del color escogido en el array de colores
     * @return String con el texto formateado para ser coloreado en la consola
     */
    public String consola(String texto, int color) {
        return colores.get(color) + texto + colores.get(0);
    }

    /**
     * Método sobrecargado que devuelve un String pasado por parámetro en la combinación de colores de consola escogidos mediante las posiciones del array
     * @author Grupo Databased
     * @param texto Texto a colorear por consola
     * @param color1 Posición del color 1 escogido en el array de colores
     * @param color2 Posición del color 2 escogido en el array de colores
     * @return String con el texto formateado para ser coloreado en la consola
     */
    public String consola(String texto, int color1, int color2) {
        return colores.get(color1) + colores.get(color2) + texto + colores.get(0) + colores.get(0);
    }
}