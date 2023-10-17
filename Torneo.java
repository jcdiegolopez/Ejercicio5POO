import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;

public class Torneo{

    public static void main(String[] args){
        ArrayList<Jugador> jugadores = null;
        Scanner myScanner = new Scanner(System.in);
        boolean running = true;

            while(running){
                try {
                    jugadores = loadData();
                }catch (Exception e){
                    System.out.println("No se ha logrado cargar la informacion: "+e.getMessage());
                }
                if(jugadores != null){
                System.out.println("1. Ingresar nuevo jugador");
                System.out.println("2. Top 3 Mejores liberos");
                System.out.println("3. Cantidad de pasadores con mas de 80% de efectividad");
                System.out.println("4. Mostrar jugadores");
                System.out.println("5. Salir");
                System.out.println("Ingrese lo que desea hacer: ");

                int opt = myScanner.nextInt();

                switch (opt) {
                    case 1:
                        try {
                            jugadores.add(newPlayer(myScanner,jugadores));
                            System.out.println("Se ha añadido el nuevo jugador");
                            updateData(jugadores);
                        } catch (Exception e) {
                            System.out.println("No se ha añadido el jugador" + e.getMessage());
                        }
                    break;
                    case 2:
                        ArrayList<Integer> porcetages = new ArrayList<Integer>();
                        ArrayList<Libero> liberos = new ArrayList<Libero>();
                        for (Jugador jugador : jugadores) {
                            if(jugador instanceof Libero){
                            Libero ju = (Libero) jugador;
                                porcetages.add(ju.calcEfectividad());
                                liberos.add(ju);
                            }
                        }
                        Collections.sort(porcetages,Collections.reverseOrder());
                        System.out.println("Top 3 Liberos");
                        int x = 1;
                        for (int i = 0 ; i < 3  ; i++) {
                            System.out.println(x + ". "+ liberos.get(i));
                            x++;
                        }
                        break;
                    case 3:
                    int cont = 0;
                        for (Jugador jugador : jugadores) {
                            if(jugador instanceof Pasador){
                            Pasador ju = (Pasador) jugador;
                                if(ju.calcEfectividad()>80){
                                    cont++;
                                }
                            }
                        }
                        System.out.println("La cantidad de pasadores con mas de 80% de efectivad es: "+cont);
                        break;
                    case 4:
                        for(Jugador jugador : jugadores){
                            System.out.println(jugador.toString());
                        }
                        break;    
                    case 5:
                        try {
                            updateData(jugadores);
                        } catch (Exception e) {
                            System.out.println("No se ha atualizado la informacion: " + e.getMessage());
                        }
                        
                        running = false;
                        System.out.println("Saliendo del programa");
                        break;
                
                    default:
                        System.out.println("No es una opcion valida");
                        break;
                }
            }
            }

            myScanner.close();
    }


    public static Jugador newPlayer(Scanner myScanner, ArrayList<Jugador> jugadores) throws Exception{
        try{
        System.out.println("1. Libero");
        System.out.println("2. Pasador");
        System.out.println("3. Auxiliar");
        System.out.println("Elija el jugador de preferencia: ");
        int opt = myScanner.nextInt();


        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = myScanner.next();
        System.out.println("Ingrese el pais del juagdor: ");
        String pais = myScanner.next();
        System.out.println("Ingrese la cantidad de errores del jugador: ");
        int errores = myScanner.nextInt();
        System.out.println("Ingrese la cantidad de aces del jugador: ");
        int aces = myScanner.nextInt();
        System.out.println("Ingrese la cantidad de servicios del jugador: ");
        int servicios = myScanner.nextInt();

        switch (opt) {
            case 1:
                System.out.println("Ingrese la cantidad de recibos efectivos del jugador: ");
                int recibosE = myScanner.nextInt();
                return new Libero(nombre,pais, errores,aces,servicios,recibosE);
            case 2:
                System.out.println("Ingrese la cantidad de pases del jugador: ");
                int pases = myScanner.nextInt();
                System.out.println("Ingrese la cantidad de fintas del jugador: ");
                int fintas = myScanner.nextInt();
                return new Pasador(nombre,pais, errores,aces,servicios,pases,fintas);
            case 3:
                System.out.println("Ingrese la cantidad de ataques del jugador: ");
                int ataques = myScanner.nextInt();
                System.out.println("Ingrese la cantidad de bloqueos efectivos del jugador: ");
                int bloqueosE = myScanner.nextInt();
                System.out.println("Ingrese la cantidad de bloqueos fallidos del jugador: ");
                int bloqueosF = myScanner.nextInt();
                return new Auxiliar(nombre,pais, errores,aces,servicios,ataques,bloqueosE,bloqueosF);
        
            default:
                throw new Exception("No es una opcion valida");        
        }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }   
    }

    public static ArrayList<Jugador> loadData() throws Exception{
        try{
            ArrayList<Jugador> jugatemp = new ArrayList<Jugador>();  
            Scanner scanner = new Scanner(new File("libero.csv"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split("\\,");
                jugatemp.add(new Libero(valores[0],valores[1],Integer.parseInt(valores[2]),Integer.parseInt(valores[3]),Integer.parseInt(valores[4]),Integer.parseInt(valores[5]))); 
            }
            scanner = new Scanner(new File("pasador.csv"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split("\\,");
                jugatemp.add(new Pasador(valores[0],valores[1],Integer.parseInt(valores[2]),Integer.parseInt(valores[3]),Integer.parseInt(valores[4]),Integer.parseInt(valores[5]),Integer.parseInt(valores[6]))); 
            }
            scanner = new Scanner(new File("auxiliar.csv"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split("\\,");
                jugatemp.add(new Auxiliar(valores[0],valores[1],Integer.parseInt(valores[2]),Integer.parseInt(valores[3]),Integer.parseInt(valores[4]),Integer.parseInt(valores[5]),Integer.parseInt(valores[6]),Integer.parseInt(valores[7]))); 
            }
            return jugatemp;
        }catch(Exception e){
            throw new Exception(e);
        }

    }

    public static void updateData(ArrayList<Jugador> jugadores)throws Exception{
        try(FileWriter escritor = new FileWriter("libero.csv")){
            for (Jugador juga : jugadores) {
                if(juga instanceof Libero){
                    Libero jugador = (Libero)juga;
                    escritor.append(jugador.getNombre()+","+jugador.getPais()+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getAces())+","+String.valueOf(jugador.getServicios())+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getRecibosE()));
                    escritor.append("\n");
                }
                    
                }
            }
        catch (IOException e){
            throw new Exception(e);
        }
        try(FileWriter escritor = new FileWriter("pasador.csv")){
            for (Jugador juga : jugadores) {
                if(juga instanceof Pasador){
                    Pasador jugador = (Pasador)juga;
                    escritor.append(jugador.getNombre()+","+jugador.getPais()+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getAces())+","+String.valueOf(jugador.getServicios())+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getPases())+","+String.valueOf(jugador.getFintas()));
                    escritor.append("\n");
                }
                    
                }
            }
        catch (IOException e){
            throw new Exception(e);
        }
        try(FileWriter escritor = new FileWriter("auxiliar.csv")){
            for (Jugador juga : jugadores) {
                if(juga instanceof Auxiliar){
                    Auxiliar jugador = (Auxiliar)juga;
                    escritor.append(jugador.getNombre()+","+jugador.getPais()+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getAces())+","+String.valueOf(jugador.getServicios())+","+String.valueOf(jugador.getErrores())+","+String.valueOf(jugador.getAtaques())+","+String.valueOf(jugador.getBloqueosE())+","+String.valueOf(jugador.getBloqueosF()));
                    escritor.append("\n");
                }
                    
                }
            }
        catch (IOException e){
            throw new Exception(e);
        }
        
            
    }
}