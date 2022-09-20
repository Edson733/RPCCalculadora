package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.Methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String opcion = "", num1 = "", num2 = "";
        Methods salvar = new Methods();
        boolean result;
        do{
            System.out.println("***********CALCULADORA***********");
            System.out.println("    1.- Suma");
            System.out.println("    2.- Resta");
            System.out.println("    3.- Multiplicacion");
            System.out.println("    4.- Division");
            System.out.println("    5.- Exponente");
            System.out.println("    6.- Raiz");
            System.out.println("    7.- Historial de Operaciones");
            System.out.println("    8.- Salir");
            System.out.print("Escoge la opcion que desees: ");
            opcion = teclado.next();
            if (isNumber(opcion)){
                switch (Integer.parseInt(opcion)){
                    case 1:
                        //Suma
                        System.out.println("\n*****SUMA*****");
                        do{
                            System.out.print("Coloca el 1er numero: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                                break;
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca el 2do numero: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                                break;
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesSuma = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseSuma = (Double) client.execute("Methods.Suma", variablesSuma);
                        System.out.println("\nEl Resultado de la Suma es: " + responseSuma);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseSuma);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 2:
                        //Resta
                        System.out.println("\n*****RESTA*****");
                        do{
                            System.out.print("Coloca el 1er numero: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                                break;
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca el 2do numero: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                                break;
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesResta = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseResta = (Double) client.execute("Methods.Resta", variablesResta);
                        System.out.println("\nEl Resultado de la Resta es: " + responseResta);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseResta);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 3:
                        //Multiplicacion
                        System.out.println("\n*****MULTIPLICACION*****");
                        do{
                            System.out.print("Coloca el 1er numero: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca el 2do numero: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesMultiplicacion = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseMultiplicacion = (Double) client.execute("Methods.Multiplicacion", variablesMultiplicacion);
                        System.out.println("\nEl Resultado de la Multiplicacion es: " + responseMultiplicacion);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseMultiplicacion);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 4:
                        //Division
                        System.out.println("\n*****DIVISION*****");
                        do{
                            System.out.print("Coloca el 1er numero: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca el 2do numero: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesDivision = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseDivision = (Double) client.execute("Methods.Division", variablesDivision);
                        System.out.println("\nEl Resultado de la Division es: " + responseDivision);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseDivision);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 5:
                        //Potencia
                        System.out.println("\n*****POTENCIA*****");
                        do{
                            System.out.print("Coloca la base: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca el exponente: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesExponente = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseExponente = (Double) client.execute("Methods.Potencia", variablesExponente);
                        System.out.println("\nEl Resultado de la Potencia es: " + responseExponente);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseExponente);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 6:
                        //Raiz
                        System.out.println("\n*****RAIZ*****");
                        do{
                            System.out.print("Coloca la base: ");
                            num1 = teclado.next();
                            if (!isNumber(num1)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num1));
                        do{
                            System.out.print("Coloca la raiz: ");
                            num2 = teclado.next();
                            if (!isNumber(num2)){
                                System.err.println("\nERROR, INGRESE UN VALOR NUMERICO");
                            }
                        }while(!isNumber(num2));
                        //Llamada al servicio web
                        Object[] variablesRaiz = {Double.parseDouble(num1), Double.parseDouble(num2)};
                        Double responseRaiz = (Double) client.execute("Methods.Raiz", variablesRaiz);
                        System.out.println("\nEl Resultado de la Raiz es: " + responseRaiz);
                        result = salvar.guardarOperaciones("Suma", num1, num2, responseRaiz);
                        if (result != false){
                            System.out.println("Registro Correctamente");
                        }else{
                            System.out.println("Registro Incorrectamente");
                        }
                        break;
                    case 7:
                        //Historial de Operaciones
                        System.out.println("\n*****HISTORIAL DE OPERACIONES*****");
                        System.out.println("Mi inteligencia no dio para mas, asi que no pude realizar esta parte. Gracias");
                        break;
                    case 8:
                        System.err.println("Usted a SALIDO");
                        break;
                    default:
                        System.err.println("LA OPCION QUE ESCOGIO ES INCORRECTA");
                        break;
                }
            }else{
                System.err.println("INGRESA UN VALOR VALIDO");
            }
        }while(!opcion.equals("8"));
    }

    public static boolean isNumber(String number){
        try{
            int num = Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDouble(String number){
        try{
            double num = Double.parseDouble(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
