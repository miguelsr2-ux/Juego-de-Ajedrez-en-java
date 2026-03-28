import java.util.Scanner;

/**
 * La clase {@code Alfil} representa la pieza de ajedrez "Alfil", la cual se mueve en diagonal en el tablero.
 * Implementa la interfaz {@code Movimiento} para definir el comportamiento específico del movimiento del Alfil.
 */
public class Alfil implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor de la clase {@code Alfil}.
     * 
     * @param x     La posición inicial en el eje X del tablero.
     * @param y     La posición inicial en el eje Y del tablero.
     * @param color El color del alfil ("blanco" o "negro").
     */
    public Alfil(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Obtiene la posición actual del Alfil en el eje X.
     * 
     * @return La posición en el eje X.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la posición del Alfil en el eje X.
     * 
     * @param x La nueva posición en el eje X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la posición actual del Alfil en el eje Y.
     * 
     * @return La posición en el eje Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la posición del Alfil en el eje Y.
     * 
     * @param y La nueva posición en el eje Y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mueve el Alfil en una dirección diagonal especificada por el usuario y una cantidad de casillas.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas casillas deseas avanzar?");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Elige la dirección diagonal (izquierda-arriba, izquierda-abajo, derecha-arriba, derecha-abajo):");
        String direccion = sc.nextLine();

        int x1 = x;
        int y1 = y;

        // Determina la nueva posición según la dirección y la cantidad de casillas
        if (direccion.equalsIgnoreCase("izquierda-arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("izquierda-abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("derecha-arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("derecha-abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else {
            System.out.println("Dirección inválida.");
            return;
        }

        // Verifica que el movimiento esté dentro de los límites del tablero
        if (x1 < 0 || x1 >= tablero.length || y1 < 0 || y1 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verifica si la posición destino está ocupada
        if (tablero[x1][y1] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Realiza el movimiento si la casilla está libre
        tablero[x1][y1] = this;
        tablero[x][y] = null;
        this.x = x1;
        this.y = y1;

        System.out.println("Te has movido " + casillas + " casillas hacia " + direccion);
    }

    /**
     * Retrocede el Alfil en una dirección diagonal especificada por el usuario y una cantidad de casillas.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas casillas deseas avanzar?");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Elige la dirección diagonal (izquierda-arriba, izquierda-abajo, derecha-arriba, derecha-abajo):");
        String direccion = sc.nextLine();

        int x2 = x;
        int y2 = y;

        // Determina la nueva posición según la dirección y la cantidad de casillas
        if (direccion.equalsIgnoreCase("izquierda-arriba")) {
            x2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("izquierda-abajo")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("derecha-arriba")) {
            x2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("derecha-abajo")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else {
            System.out.println("Dirección inválida.");
            return;
        }

        // Verifica que el movimiento esté dentro de los límites del tablero
        if (x2 < 0 || x2 >= tablero.length || y2 < 0 || y2 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verifica si la posición destino está ocupada
        if (tablero[x2][y2] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Realiza el movimiento si la casilla está libre
        tablero[x2][y2] = this;
        tablero[x][y] = null;
        this.x = x2;
        this.y = y2;

        System.out.println("Te has movido " + casillas + " casillas hacia " + direccion);
    }

    /**
     * Indica que el Alfil solo puede capturar piezas en una casilla diagonal adyacente a su posición final.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    public void comer(Movimiento tablero[][]) {
        System.out.println("Solo puede comer en casilla diagonal donde termine su recorrido.");
    }
}
