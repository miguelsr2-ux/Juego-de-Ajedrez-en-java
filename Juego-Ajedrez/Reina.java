import java.util.Scanner;

/**
 * La clase {@code Reina} representa la pieza de ajedrez "Reina". Implementa la interfaz {@code Movimiento}
 * para definir el comportamiento específico del movimiento de la reina.
 */
public class Reina implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor de la clase {@code Reina}.
     *
     * @param x     La posición inicial en el eje X del tablero.
     * @param y     La posición inicial en el eje Y del tablero.
     * @param color El color de la reina ("blanco" o "negro").
     */
    public Reina(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Obtiene la posición actual de la reina en el eje X.
     *
     * @return La posición en el eje X.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la posición de la reina en el eje X.
     *
     * @param x La nueva posición en el eje X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la posición actual de la reina en el eje Y.
     *
     * @return La posición en el eje Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la posición de la reina en el eje Y.
     *
     * @param y La nueva posición en el eje Y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mueve la reina en una dirección especificada por el usuario y una cantidad de casillas.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántas casillas deseas avanzar? ");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Elige la dirección en la que deseas avanzar (arriba, abajo, izquierda, derecha, diagonal arriba-izquierda, diagonal arriba-derecha, diagonal abajo-izquierda, diagonal abajo-derecha): ");
        String direccion = sc.nextLine();

        int x1 = x;
        int y1 = y;

        // Determina la nueva posición según la dirección y la cantidad de casillas
        if (direccion.equalsIgnoreCase("arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("izquierda")) {
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("derecha")) {
            y1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-izquierda")) {
            x1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-derecha")) {
            x1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-izquierda")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-derecha")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -casillas : -casillas);
            y1 += (color.equalsIgnoreCase("blanco") ? casillas : casillas);
        } else {
            System.out.println("Dirección no válida.");
            return;
        }

        if (x1 < 0 || x1 >= tablero.length || y1 < 0 || y1 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        if (tablero[x1][y1] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        tablero[x1][y1] = this;
        tablero[x][y] = null;
        this.x = x1;
        this.y = y1;

        System.out.println("Te has movido " + casillas + " casillas hacia " + direccion);
    }

    /**
     * Retrocede la reina en una dirección especificada por el usuario y una cantidad de casillas.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántas casillas deseas avanzar? ");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.println("Elige la dirección en la que deseas avanzar (arriba, abajo, izquierda, derecha, diagonal arriba-izquierda, diagonal arriba-derecha, diagonal abajo-izquierda, diagonal abajo-derecha): ");
        String direccion = sc.nextLine();

        int x2 = x;
        int y2 = y;

        if (direccion.equalsIgnoreCase("arriba")) {
            x2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("abajo")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("izquierda")) {
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("derecha")) {
            y2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-izquierda")) {
            x2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-derecha")) {
            x2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-izquierda")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -casillas : casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : -casillas);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-derecha")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -casillas : -casillas);
            y2 += (color.equalsIgnoreCase("blanco") ? casillas : casillas);
        } else {
            System.out.println("Dirección no válida.");
            return;
        }

        if (x2 < 0 || x2 >= tablero.length || y2 < 0 || y2 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        if (tablero[x2][y2] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        tablero[x2][y2] = this;
        tablero[x][y] = null;
        this.x = x2;
        this.y = y2;

        System.out.println("Te has movido " + casillas + " casillas hacia " + direccion);
    }

    /**
     * Indica que la reina puede capturar piezas en cualquier dirección.
     * 
     * @param tablero El tablero de ajedrez representado como una matriz de objetos {@code Movimiento}.
     */
    @Override
    public void comer(Movimiento tablero[][]) {
        System.out.println("Come donde esté una pieza en cualquier dirección.");
    }
}
