import java.util.Scanner;

/**
 * La clase Caballo representa la pieza de ajedrez caballo y su movimiento en el tablero.
 * Implementa la interfaz Movimiento, que contiene métodos para moverse, retroceder y comer.
 */
public class Caballo implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor de la clase Caballo que inicializa su posición y color.
     * 
     * @param x     Coordenada x inicial del caballo en el tablero.
     * @param y     Coordenada y inicial del caballo en el tablero.
     * @param color Color del caballo (blanco o negro).
     */
    public Caballo(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mueve el caballo en el tablero según el patrón de movimiento en "L" del caballo
     * en ajedrez, solicitando al usuario las direcciones y asegurándose de que el
     * destino sea válido y libre de obstrucciones.
     *
     * @param tablero Matriz de Movimiento que representa el tablero de juego.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);

        // Primer movimiento (2 casillas en una dirección)
        System.out.println("Elige la dirección inicial para avanzar (arriba, abajo, izquierda, derecha): ");
        String direccion1 = sc.nextLine();

        // Segundo movimiento (1 casilla en la dirección perpendicular)
        System.out.println("Elige la dirección perpendicular para moverte después (izquierda, derecha, arriba, abajo): ");
        String direccion2 = sc.nextLine();

        // Variables para la nueva posición
        int x1 = x;
        int y1 = y;

        // Aplicar el primer movimiento (2 casillas en la dirección indicada)
        if (direccion1.equalsIgnoreCase("arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? 2 : -2);
        } else if (direccion1.equalsIgnoreCase("abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -2 : 2);
        } else if (direccion1.equalsIgnoreCase("izquierda")) {
            y1 += (color.equalsIgnoreCase("blanco") ? 2 : -2);
        } else if (direccion1.equalsIgnoreCase("derecha")) {
            y1 += (color.equalsIgnoreCase("blanco") ? -2 : 2);
        } else {
            System.out.println("Dirección inicial no válida.");
            return;
        }

        // Aplicar el segundo movimiento (1 casilla en la dirección perpendicular)
        if (direccion2.equalsIgnoreCase("arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion2.equalsIgnoreCase("abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else if (direccion2.equalsIgnoreCase("izquierda")) {
            y1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion2.equalsIgnoreCase("derecha")) {
            y1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else {
            System.out.println("Dirección perpendicular no válida.");
            return;
        }

        // Verificar si el movimiento está dentro de los límites del tablero
        if (x1 < 0 || x1 >= tablero.length || y1 < 0 || y1 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verificar si la posición destino está ocupada
        if (tablero[x1][y1] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Mover el caballo si la casilla está libre
        tablero[x1][y1] = this;  // Coloca el caballo en la nueva posición
        tablero[x][y] = null;    // Elimina el caballo de la posición actual
        this.x = x1;             // Actualiza la posición del caballo en x
        this.y = y1;             // Actualiza la posición del caballo en y

        System.out.println("Te moviste en forma de 'L': 2 casillas hacia " + direccion1 + " y 1 casilla hacia " + direccion2);
    }

    /**
     * Retrocede el caballo en el tablero en forma de "L" en la dirección especificada,
     * verificando las obstrucciones y los límites del tablero.
     *
     * @param tablero Matriz de Movimiento que representa el tablero de juego.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);

        // Primer movimiento (2 casillas en una dirección)
        System.out.println("Elige la dirección inicial para retroceder (arriba, abajo, izquierda, derecha): ");
        String direccion1 = sc.nextLine();

        // Segundo movimiento (1 casilla en la dirección perpendicular)
        System.out.println("Elige la dirección perpendicular para moverte después (izquierda, derecha, arriba, abajo): ");
        String direccion2 = sc.nextLine();

        // Variables para la nueva posición
        int x2 = x;
        int y2 = y;

        // Aplicar el primer movimiento (2 casillas en la dirección indicada)
        if (direccion1.equalsIgnoreCase("arriba")) {
            x2 += (color.equalsIgnoreCase("blanco") ? 2 : -2);
        } else if (direccion1.equalsIgnoreCase("abajo")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -2 : 2);
        } else if (direccion1.equalsIgnoreCase("izquierda")) {
            y2 += (color.equalsIgnoreCase("blanco") ? 2 : -2);
        } else if (direccion1.equalsIgnoreCase("derecha")) {
            y2 += (color.equalsIgnoreCase("blanco") ? -2 : 2);
        } else {
            System.out.println("Dirección inicial no válida.");
            return;
        }

        // Aplicar el segundo movimiento (1 casilla en la dirección perpendicular)
        if (direccion2.equalsIgnoreCase("arriba")) {
            x2 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion2.equalsIgnoreCase("abajo")) {
            x2 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else if (direccion2.equalsIgnoreCase("izquierda")) {
            y2 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion2.equalsIgnoreCase("derecha")) {
            y2 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else {
            System.out.println("Dirección perpendicular no válida.");
            return;
        }

        // Verificar si el movimiento está dentro de los límites del tablero
        if (x2 < 0 || x2 >= tablero.length || y2 < 0 || y2 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verificar si la posición destino está ocupada
        if (tablero[x2][y2] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Mover el caballo si la casilla está libre
        tablero[x2][y2] = this;  // Coloca el caballo en la nueva posición
        tablero[x][y] = null;    // Elimina el caballo de la posición actual
        this.x = x2;             // Actualiza la posición del caballo en x
        this.y = y2;             // Actualiza la posición del caballo en y

        System.out.println("Te moviste en forma de 'L': 2 casillas hacia " + direccion1 + " y 1 casilla hacia " + direccion2);
    }

    /**
     * Imprime una descripción de la capacidad de captura del caballo en la casilla final
     * de su movimiento en forma de "L".
     *
     * @param tablero Matriz de Movimiento que representa el tablero de juego.
     */
    @Override
    public void comer(Movimiento tablero[][]) {
        System.out.println("El caballo come en la última casilla de su movimiento en 'L'.");
    }

    /**
     * Método auxiliar para validar si las direcciones ingresadas son perpendiculares.
     *
     * @param dir1 Primera dirección de movimiento (arriba, abajo, izquierda, derecha).
     * @param dir2 Segunda dirección de movimiento (debe ser perpendicular a dir1).
     * @return true si las direcciones son perpendiculares, false en caso contrario.
     */
    private boolean esMovimientoValido(String dir1, String dir2) {
        // Verifica que la primera y la segunda dirección sean perpend
                // Verifica que la primera y la segunda dirección sean perpendiculares
        if ((dir1.equals("arriba") || dir1.equals("abajo")) && (dir2.equals("izquierda") || dir2.equals("derecha"))) {
            return true;
        } else if ((dir1.equals("izquierda") || dir1.equals("derecha")) && (dir2.equals("arriba") || dir2.equals("abajo"))) {
            return true;
        } else {
            return false;  // Si no son perpendiculares, el movimiento no es válido
        }
    }
}