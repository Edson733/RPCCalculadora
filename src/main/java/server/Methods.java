package server;

public class Methods {
    private String operacion;
    private double num1;
    private double num2;
    private double resultado;

    public Methods() {
    }

    public Methods(String operacion, double num1, double num2, double resultado) {
        this.operacion = operacion;
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
    }

    public double Suma(double num1, double num2){
        return (num1 + num2);
    }

    public double Resta(double num1, double num2){
        return (num1 - num2);
    }

    public double Multiplicacion(double num1, double num2){
        return (num1 * num2);
    }

    public double Division(double num1, double num2){
        if(num2 != 0){
            return (num1 / num2);
        } else {
            System.err.println("\nLa división entre 0 es una indeterminación");
            return 0;
        }
    }

    public double Potencia(double num1, double num2){
        return (Math.pow(num1, num2));
    }

    public double Raiz(double num1, double num2){
        return (Math.pow(num1, 1/num2));
    }

    public boolean guardarOperaciones(String operacion, String num1, String num2, double resultado){
        DaoCalculadora daoCalculadora = new DaoCalculadora();
        return daoCalculadora.guardarOperaciones(operacion, num1, num1, resultado);
    }
}
