import java.util.Scanner;

/**
 * La clase Peon representa un peón en el juego de ajedrez, que implementa la
 * interfaz Movimiento. Un peón puede avanzar en línea recta o comer de manera diagonal.
 * No se permite que el peón retroceda en el juego.
 */
public class Peon implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor para crear un nuevo Peon con una posición específica y un color.
     *
     * @param x La coordenada X inicial del peón.
     * @param y La coordenada Y inicial del peón.
     * @param color El color del peón ("blanco" o "negro").
     */
    public Peon(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Obtiene la coordenada X actual del peón.
     *
     * @return La coordenada X del peón.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la coordenada X del peón.
     *
     * @param x La nueva coordenada X del peón.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada Y actual del peón.
     *
     * @return La coordenada Y del peón.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada Y del peón.
     *
     * @param y La nueva coordenada Y del peón.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Avanza el peón en el tablero según el número de casillas indicadas.
     * El peón puede moverse hasta dos casillas en su primer movimiento y una
     * casilla en movimientos posteriores. Si el camino está bloqueado, el peón
     * no podrá avanzar.
     *
     * @param tablero El tablero de ajedrez representado como un arreglo bidimensional de objetos Movimiento.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);  

        System.out.print("¿Cuántas casillas deseas avanzar? ");
        int casillas = sc.nextInt();  
        System.out.print("¿Cuál es el turno del peón seleccionado? (1 o 2): ");
        int turno = sc.nextInt();

        int x1 = x; // Posición futura

        if (color.equals("blanco")) {
            if (tablero[x+1][y] != null) {
                System.out.println("Hay jaque, no puedes avanzar.");
                return;
            }
        } else {
            if (tablero[x-1][y] != null) {
                System.out.println("Hay jaque, no puedes avanzar.");
                return;
            }
        }

        if (turno == 1) {
            if ((casillas <= 2 && x == 1) || (casillas <= 2 && x == 6)) { // Movimiento inicial (hasta 2 casillas)
                if (color.equals("blanco")) {
                    x1 += casillas; // Mover hacia adelante
                } else {
                    x1 -= casillas; // Mover hacia adelante
                }
            } else if (casillas == 1) { // Movimiento normal
                if (color.equals("blanco")) {
                    x1 += 1; // Mover hacia adelante
                } else {
                    x1 -= 1; // Mover hacia adelante
                }
            } else {
                System.out.println("El peón solo puede avanzar una casilla por turno o dos al inicio del turno.");
                return; // Termina el método si no puede avanzar
            }
        } else if (turno == 2) {
            System.out.println("El peón negro solo puede avanzar una casilla.");
            return; // Termina el método si no puede avanzar
        } else {
            System.out.println("Turno inválido.");
            return; // Termina el método si el turno es inválido
        }

        // Verifica si la posición destino está ocupada
        if (tablero[x1][y] != null) {
            System.out.println("No se puede avanzar, la casilla está ocupada.");
            return; // Termina el método si la casilla está ocupada
        }

        // Mover el peón si la casilla está libre
        tablero[x1][y] = this;  // Coloca el peón en la nueva posición
        tablero[x][y] = null; // Elimina el peón de la posición actual
        this.x = x1; // Actualiza la posición del peón
        System.out.println("Avanzaste " + casillas + " casillas en línea recta.");
    }

    /**
     * Método que indica que el peón no puede retroceder en el tablero.
     *
     * @param tablero El tablero de ajedrez representado como un arreglo bidimensional de objetos Movimiento.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        System.out.println("No puede retroceder.");
    }

    /**
     * Indica que el peón puede comer en el tablero moviéndose en diagonal.
     *
     * @param tablero El tablero de ajedrez representado como un arreglo bidimensional de objetos Movimiento.
     */
    @Override
    public void comer(Movimiento tablero[][]) {
        System.out.println("Come de manera diagonal.");
    }
}
