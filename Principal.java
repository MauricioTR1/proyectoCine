package interaccion;

import cine.Boleto;
import cine.Combo;
import cine.ComboAmigos;
import cine.ComboFamilia;
import cine.ComboPareja;
import cine.Pelicula;
import cine.Sala;
import dao.DAOCine;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import modelo.ModeloCine;

public class Principal {

    public static Scanner entrada = new Scanner(System.in);
    public static Scanner entradaString = new Scanner(System.in);
    public static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    public static Vector<Sala> salas = new Vector<Sala>();
    public static Vector<Boleto> boletos = new Vector<Boleto>();
    public static Vector<Combo> combos = new Vector<Combo>();
    public static ModeloCine mc;
    public static DAOCine daoc;
    public static void main(String[] args) {
        cargaPeliculasTexto();
        //cargaPersonasObjeto();
        
        int opc = 0;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    int opcP = menuPeliculas();
                    switch (opcP) {
                        case 1:
                            altaPelicula();
                            break;
                        case 2:
                            eliminaPelicula();
                            break;
                        case 3:
                            mostrarCartelera();
                            break;
                    }
                    break;
                case 2:
                    int opcS = menuSala();
                    switch (opcS) {
                        case 1:
                            altaSala();
                            break;
                        case 2:
                            eliminaSala();
                            break;
                        case 3:
                            mostrarAsientosSala();
                            break;
                    }
                    break;
                case 3:
                    int opcB = menuBoletos();
                    switch (opcB) {
                        case 1:
                            altaBoleto();
                            break;
                        case 2:
                            mostrarBoletoSegunPelicula();
                            break;
                        case 3:
                            mostrarCombos();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Adios!");
                    break;
            }
        } while (opc != 4);
        actualizarPeliculasTexto(peliculas);
        //actualizarPersonasObjeto(peliculas);
    }

    public static int menu() {
        System.out.println("MENU DE CINE");
        System.out.println("1. Menu de peliculas");
        System.out.println("2. Menu de salas");
        System.out.println("3. Menu de boletos");
        System.out.println("4. Salir");
        int opc = entrada.nextInt();
        return opc;
    }

    //Menú de película
    public static int menuPeliculas() {
        System.out.println("SUBMENU DE PELICULAS");
        System.out.println("1. Alta pelicula");
        System.out.println("2. Elimina pelicula");
        System.out.println("3. Mostrar cartelera");
        int opcP = entrada.nextInt();
        return opcP;
    }

    public static void altaPelicula() {
        int id;
        String titulo, genero, productor, director, origen, duracion;
        System.out.println("Ingrese el ID");
        id = entrada.nextInt();
        System.out.println("Ingrese el titulo");
        titulo = entradaString.nextLine();
        System.out.println("Ingrese el genero");
        genero = entradaString.nextLine();
        System.out.println("Ingrese el productor");
        productor = entradaString.nextLine();
        System.out.println("Ingrese el director");
        director = entradaString.nextLine();
        System.out.println("Ingrese el origen");
        origen = entradaString.nextLine();
        System.out.println("Ingrese la duracion");
        duracion = entradaString.nextLine();
        peliculas.add(new Pelicula(id, titulo, genero, productor, director, origen, duracion));
    }

    public static void eliminaPelicula() {
        int id;
        System.out.println("Ingrese el ID de la pelicula a eliminar");
        id = entrada.nextInt();
        for (int i = 0; i < peliculas.size(); i++) {
            if (id == peliculas.get(id).getId()) {
                peliculas.get(i).imprimir();
                peliculas.remove(i);
            }
        }
    }

    public static void mostrarCartelera() {
        System.out.println("===CARTELERA===");
        for (int i = 0; i < peliculas.size(); i++) {
            peliculas.get(i).imprimir();
        }
    }

    //Menú de sala
    public static int menuSala() {
        System.out.println("SUBMENU DE SALA");
        System.out.println("1. Alta sala");
        System.out.println("2. Elimina sala");
        System.out.println("3. Mostrar asientos de cualquier sala");
        int opcS = entrada.nextInt();
        return opcS;
    }

    public static void altaSala() {
        int id, filas, columnas, clavePelicula;
        Pelicula pelicula;
        System.out.println("Ingrese el ID");
        id = entrada.nextInt();
        System.out.println("Ingrese la cantidad de filas");
        filas = entrada.nextInt();
        System.out.println("Ingrese la cantidad de columnas");
        columnas = entrada.nextInt();
        System.out.println("Ingrese el ID de la pelicula");
        clavePelicula = entrada.nextInt();
        for (int i = 0; i < peliculas.size(); i++) {
            if (clavePelicula == peliculas.get(i).getId()) {
                pelicula = peliculas.get(i);
                System.out.println("Titulo de la pelicula: " + pelicula.getTitulo());
                salas.addElement(new Sala(id, filas, columnas, pelicula));
                System.out.println("Sala dada de alta");
            }
        }
    }

    public static void eliminaSala() {
        int id;
        System.out.println("Ingrese el ID de la sala a eliminar");
        id = entrada.nextInt();
        for (int i = 0; i < salas.size(); i++) {
            if (id == salas.elementAt(i).getId()) {
                salas.elementAt(i).imprimir();
                salas.remove(i);
            }
        }
    }

    public static void mostrarAsientosSala() {
        int id;
        System.out.println("Ingrese el ID de la sala");
        id = entrada.nextInt();
        for (int i = 0; i < salas.size(); i++) {
            if (id == salas.elementAt(i).getId()) {
                Sala sala;
                sala = salas.elementAt(i);
                System.out.println(sala.imprimeSala());
            }
        }
    }

    //Menú de boletos
    public static int menuBoletos() {
        System.out.println("SUBMENU DE BOLETOS");
        System.out.println("1. Alta boleto");
        System.out.println("2. Mostrar boletos comprados de cualquier pelicula");
        System.out.println("3. Mostrar combos");
        int opcB = entrada.nextInt();
        return opcB;
    }

    public static void altaBoleto() {
        int id, clavePelicula, claveSala;
        String fecha, hora, asiento;
        Pelicula pelicula;
        Sala sala;
        System.out.println("Ingrese ID");
        id = entrada.nextInt();
        System.out.println("Ingrese ID de la pelicula");
        clavePelicula = entrada.nextInt();
        System.out.println("Ingrese la fecha (dd/mm/aaaa)");
        fecha = entradaString.nextLine();
        System.out.println("Ingrese la hora");
        hora = entradaString.nextLine();
        System.out.println("Ingrese ID de la sala");
        claveSala = entrada.nextInt();
        System.out.println("Ingrese los asientos");
        asiento = entradaString.nextLine();
        for (int i = 0; i < peliculas.size(); i++) {
            for (int j = 0; j < salas.size(); j++) {
                if (clavePelicula == peliculas.get(i).getId() && claveSala == salas.elementAt(j).getId()) {
                    pelicula = peliculas.get(i);
                    sala = salas.elementAt(j);
                    System.out.println("Nombre de la pelicula: " + pelicula.getTitulo());
                    System.out.println("Sala: " + sala.getId());
                    sala.comprar(asiento);
                    System.out.println("Ingrese el combo que desee, si no desea un combo escriba 0");
                    System.out.println("1. Combo Amigos");
                    System.out.println("2. Combo Familia");
                    System.out.println("3. Combo Pareja");
                    int claveCombo = entrada.nextInt();
                    if (claveCombo != 0) {
                        switch (claveCombo) {
                            case 1:
                                int refrescos,
                                 dulces;
                                float precio;
                                String tamanioPalomitas;
                                System.out.println("Ingrese la cantidad de refrescos");
                                refrescos = entrada.nextInt();
                                System.out.println("Ingrese la cantidad de dulces");
                                dulces = entrada.nextInt();
                                System.out.println("Ingrese el tamaño de las palomitas");
                                tamanioPalomitas = entradaString.nextLine();
                                System.out.println("Ingrese el precio");
                                precio = entrada.nextFloat();
                                combos.addElement(new ComboAmigos(dulces, id, precio, tamanioPalomitas, refrescos));
                                break;
                            case 2:
                                int crepas,
                                 refrescos_f;
                                float precio_f;
                                String tamanioPalomitas_f;
                                System.out.println("Ingrese la cantidad de crepas");
                                crepas = entrada.nextInt();
                                System.out.println("Ingrese el precio");
                                precio_f = entrada.nextInt();
                                System.out.println("Ingrese el tamaño de las palomitas");
                                tamanioPalomitas_f = entradaString.nextLine();
                                System.out.println("Ingrese la cantidad de refrescos");
                                refrescos_f = entrada.nextInt();
                                combos.addElement(new ComboFamilia(crepas, id, precio_f, tamanioPalomitas_f, refrescos_f));
                                break;
                            case 3:
                                int hotdogs,
                                 refrescos_p;
                                float precio_p;
                                String tamanioPalomitas_p;
                                System.out.println("Ingrese la cantidad de hot dogs");
                                hotdogs = entrada.nextInt();
                                System.out.println("Ingrese el precio");
                                precio_p = entrada.nextFloat();
                                System.out.println("Ingrese el tamaño de las palomitas");
                                tamanioPalomitas_p = entradaString.nextLine();
                                System.out.println("Ingrese la cantidad de refrescos");
                                refrescos_p = entrada.nextInt();
                                combos.addElement(new ComboPareja(hotdogs, id, precio_p, tamanioPalomitas_p, refrescos_p));
                                break;
                            case 0:
                                System.out.println("Sin combo");
                                break;
                        }
                    }
                    boletos.addElement(new Boleto(id, pelicula, fecha, hora, sala, asiento));
                    System.out.println("Boleto dado de alta con exito");
                }
            }
        }
    }

    public static void mostrarBoletoSegunPelicula() {
        int id;
        System.out.println("Ingrese ID de la pelicula");
        id = entrada.nextInt();
        for (int i = 0; i < boletos.size(); i++) {
            if (id == boletos.elementAt(i).getPelicula().getId()) {
                boletos.elementAt(i).imprimir();
            }
        }
        for (int i = 0; i < boletos.size(); i++) {
            for (int j = 0; j < combos.size(); j++) {
                if (boletos.elementAt(i).getId() == combos.elementAt(j).getId() && id == boletos.elementAt(i).getPelicula().getId()) {
                    combos.elementAt(j).imprimir();
                }
            }
        }
    }

    public static void mostrarCombos() {
        System.out.println("Combo Amigos: Incluye dulces");
        System.out.println("Combo Pareja: Incluye hot dogs");
        System.out.println("Combo Familia: Incluye crepas");
    }
    
    public static void cargaPeliculasTexto(){
        mc = new ModeloCine("Peliculas.DAT",'i');
        peliculas = mc.cargaPeliculas();
    }
    
    public static void actualizarPeliculasTexto(ArrayList peliculas){
        mc = new ModeloCine("Peliculas.DAT",'o');
        mc.actualizarPelicula(peliculas);
    }
    
    public static void cargaPersonasObjeto(){
        daoc = new DAOCine("Peliculas.OBJ",'i');
        peliculas = daoc.cargaPelicula();
    }
    
    public static void actualizarPersonasObjeto(ArrayList peliculas){
        daoc = new DAOCine("Peliculas.OBJ",'o');
        daoc.actualizarPelicula(peliculas);
    }
}
