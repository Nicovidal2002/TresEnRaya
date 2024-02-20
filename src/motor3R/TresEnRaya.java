package motor3R;
import java.util.Random;


public class TresEnRaya {


    private char HUMANO;
    private char MAQUINA;
    private char LIBRE='_';
    char tabla[][] = new char[3][3];


    boolean partidaFinalizada=false;
    char ganador='E';


    public TresEnRaya(char humano, char maquina){
        this.HUMANO=humano;
        this.MAQUINA=maquina;
        for (int fila=0; fila<3; fila++){
            for (int columna=0; columna<3; columna++){
                tabla[fila][columna]=LIBRE;
            }
        }
    }
   
    private char[][] tablero = {
        {'_','_','_'},
        {'_','_','_'},
        {'_','_','_'}
    };

    public char[][] getTablero(){
        return tablero;
    }

    public boolean jugar(int fila, int columna, char caracterJugador){
        fila = fila -1;
        columna = columna -1;
        char carcaterMaquina = (caracterJugador==HUMANO)?MAQUINA:HUMANO;

        if(fila < 0 || fila > 2 || columna < 0 || columna > 2){
            System.out.println("Posición no válida");
            return false;
        }

        if (tablero[fila][columna] != LIBRE) {
            System.out.println("Posición ocupada");
            return false;
        }

        tablero[fila][columna] = caracterJugador;
        return true;

    }

    public boolean hayGanador(char caracterJugador){
        for (int i=0; i<3; i++){
            if (tablero[i][0] == caracterJugador && tablero[i][1] == caracterJugador && tablero[i][2] == caracterJugador){
                return true;
            }
            if (tablero[0][i] == caracterJugador && tablero[1][i] == caracterJugador && tablero[2][i] == caracterJugador){
                return true;
            }
        }
        if (tablero[0][0] == caracterJugador && tablero[1][1] == caracterJugador && tablero[2][2] == caracterJugador){
            return true;
        }
        if (tablero[0][2] == caracterJugador && tablero[1][1] == caracterJugador && tablero[2][0] == caracterJugador){
            return true;
        }
        return false;
    }

    public boolean tableroLleno(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (tablero[i][j] == LIBRE){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean jugadaValida(int fila, int columna){
        fila = fila -1;
        columna = columna -1;
        if(fila < 0 || fila > 2 || columna < 0 || columna > 2){
            return false;
        }

        if(getTablero()[fila][columna] != '_'){
            return false;
        }
        return true;
    }
}
