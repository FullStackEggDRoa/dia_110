/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_extra_1;

import Enumeradores.busquedasLibro;
import Servicios.serviciosAutor;
import Servicios.serviciosCliente;
import Servicios.serviciosEditorial;
import Servicios.serviciosLibro;
import java.util.Scanner;

/**
 *
 * @author droa
 */
public class Ejercicio_Extra_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
       
        serviciosAutor sA = new serviciosAutor();
        serviciosEditorial sE = new serviciosEditorial();
        serviciosLibro sL = new serviciosLibro();
        serviciosCliente sC = new serviciosCliente();
        
        System.out.println("..:: MENU LIBRERIA ::..");
        int opcion=0;
        do {            
            System.out.println("1. Busquedas Libros"); 
            System.out.println("2. Ingresar Autor");
            System.out.println("3. Ingresar Editorial");
            System.out.println("4. Ingresar Libro");
            System.out.println("5. Ingresar Cliente");
            System.out.println("6. Mostrar Autores");
            System.out.println("7. Mostrar Editoriales");
            System.out.println("8. Mostrar Libros");
            System.out.println("9. Mostrar Clientes");
            System.out.println("10. Editar Libro");
            System.out.println("11. Inventario Libros");
            System.out.print("Elija una Opción: ");
            opcion=leer.nextInt();
            
            switch (opcion) {
                case 1:
                    Boolean criterioOk = false;
                    String respuesta = "";
                    String Aux = "";
                    try{
//                        
                        do{
                            System.out.print("Criterio de Busqueda: ["+busquedasLibro.Autor+", "+busquedasLibro.Editorial+", "+busquedasLibro.ISBN+", "+busquedasLibro.Titulo+"]: ");
                            respuesta = leer.next();
                            criterioOk = respuesta.equalsIgnoreCase(busquedasLibro.Autor.toString()) || respuesta.equalsIgnoreCase(busquedasLibro.Editorial.toString())
                                    || respuesta.equalsIgnoreCase(busquedasLibro.ISBN.toString()) || respuesta.equalsIgnoreCase(busquedasLibro.Titulo.toString()); 
                            
                        }while(!criterioOk);
                     
                        switch (respuesta.toUpperCase()) {
                            case "AUTOR":
                                Aux = sL.listarLibrosAutor(sA.buscarAutor()).toString().replace(",", "+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+\n");
                                break;
                            case "EDITORIAL":
                                Aux = sL.listarLibrosEditorial(sE.buscarEditorial()).toString().replace(",", "+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+\n");    
                                break;
                            case "ISBN":
                                System.out.print("Ingrese ISBN (Sin Guiones): ");
                                Aux = sL.listarLibrosIsbn(leer.nextLong()).toString().replace(",", "+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+\n");
                                break;
                            case "TITULO":
                                System.out.print("Ingrese Titulo (Palabra Clave): ");
                                Aux = sL.listarLibrosTitulo(leer.next()).toString().replace(",", "+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+\n");
                                break;
                            default:    
                                throw new AssertionError();
                        }
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                        System.out.println("|Codigo|        Titulo del Libro       |    ISBN del Libro   |             Autor             |            Editorial          | Año |");
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));  
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                
                
                case 2:
                    try{
                        sA.crearAutor();
                    }catch (Exception e) {
                        //e.printStackTrace();
                        //System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        sE.crearEditorial();
                    }catch (Exception e) {
                        //e.printStackTrace();
                        //System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;    
                case 4:
                    try{
                        sL.crearLibro();
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        sC.crearCliente();
                    } catch (Exception e) {
                        
                    }
                        
                    break;
                    
                case 6:
                    try{
                        
                        System.out.println("+------+-------------------------------+");
                        System.out.println("|Codigo|       Nombre de Autor         |");
                        System.out.println("+------+-------------------------------+");
                        
                        Aux = sA.listarAutores().toString().replace(",", "+------+-------------------------------+\n");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+------+-------------------------------+");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        
                        System.out.println("+------+-------------------------------+");
                        System.out.println("|Codigo|      Nombre de Editorial      |");
                        System.out.println("+------+-------------------------------+");
                        
                        Aux = sE.listarEditoriales().toString().replace(",", "+------+-------------------------------+\n");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+------+-------------------------------+");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;    
                case 8:
                    try{
                        
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                        System.out.println("|Codigo|        Titulo del Libro       |    ISBN del Libro   |             Autor             |            Editorial          | Año |");
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                        
                        Aux = sL.listarLibros().toString().replace(",", "+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+\n");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+------+-------------------------------+---------------------+-------------------------------+-------------------------------+-----+");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 9:
                    try{
                        
                        System.out.println("+------+------------+----------------------+----------------------+---------------+");
                        System.out.println("|Codigo|  Documento |        Nombre        |       Apellido       |    Teléfono   |");
                        System.out.println("+------+------------+----------------------+----------------------+---------------+");
                        
                        Aux = sC.listarClientes().toString().replace(",", "+------+------------+----------------------+----------------------+---------------+\n");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+------+------------+----------------------+----------------------+---------------+");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    
                case 10:
                    sL.editarLibro();
                        
                    break;
                case 11:
                    try{
                        System.out.print("Ingrese Codigo Interno Libro: ");
                        int codigoLibro = leer.nextInt();
                        System.out.println("+------+-------------------------------+---------------------+------------+------------------------+----------------------+");
                        System.out.println("|Codigo|        Titulo del Libro       |    ISBN del Libro   | Ejemplares |  Ejemplares Prestados  | Ejemplares Restantes |");
                        System.out.println("+------+-------------------------------+---------------------+------------+------------------------+----------------------+");
                        
                        Aux = sL.listarLibrosInventarios(codigoLibro).get(0).toStringInventario().replace(",", "+------+-------------------------------+---------------------+------------+------------------------+----------------------+\n");
                        String Aux1 = Aux.replace("[", "|");
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+------+-------------------------------+---------------------+------------+------------------------+----------------------+");
                        sL.editarInventarioLibro(codigoLibro);
                    }catch(IndexOutOfBoundsException o){
                        String Aux1 = "| NOTA: No se encontraron libros con esa ID.";
                        System.out.println(Aux1.replace("\n]",""));
                        System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (true);
        
    }
    
}
