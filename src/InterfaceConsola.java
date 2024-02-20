import motor3R.TresEnRaya;
import java.util.Scanner;


public class InterfaceConsola {
        public static void imprimirTablero(char[][] tablero) {
            for (int fila=0; fila<3; fila++){
                for (int columna=0; columna<3; columna++){
                    System.out.print(tablero[fila][columna]+" ");
                    if(columna<2){
                        System.out.print("| ");
                    }
                }
                System.out.println();
                }
            }       
        


        public static void main(String[] args) throws InterruptedException {
            Scanner sc = new Scanner(System.in);
            char humano = 'X';
            char maquina = 'O';
            int ganadasHumano = 0;
            int ganadasMaquina = 0; 

            TresEnRaya juego = new TresEnRaya(humano, maquina);

            System.out.println("Bienvenido al tres en raya");
            System.out.println("este es eñ tablero");

            imprimirTablero(juego.getTablero());

            System.out.println("las casillas estan numeradas de la siguiente forma");
            System.out.println("el jugador humano es X y el jugador maquina es O" );
            System.out.println("comienza el jugador humano");

            for(int i=0; i<9; i++){
                int fila;
                int columna;
                boolean jugadaValida = false;
                do{
                    System.out.println("Ingrese la fila");
                    fila = sc.nextInt();
                    System.out.println("Ingrese la columna");
                    columna = sc.nextInt();
                    jugadaValida = juego.jugar(fila, columna, humano);
                    if(!jugadaValida){
                        System.out.println("Jugada no válida");
                    }
                }while(!jugadaValida);
                imprimirTablero(juego.getTablero());
                if(juego.hayGanador(humano)){
                    System.out.println("Ganaste");
                    ganadasHumano++;
                    break;
                }
                if(i<8){
                    System.out.println("Turno de la máquina");
                    Thread.sleep(1000);
                    do{
                        fila = (int)(Math.random()*3)+1;
                        columna = (int)(Math.random()*3)+1;
                        jugadaValida = juego.jugar(fila, columna, maquina);
                    }while(!jugadaValida);
                    imprimirTablero(juego.getTablero());
                    if(juego.hayGanador(maquina)){
                        System.out.println("Ganó la máquina");
                        ganadasMaquina++;
                        break;
                    }
                }
            }
        }

        private static boolean tableroLleno(){
            return false;
        }
    } 


