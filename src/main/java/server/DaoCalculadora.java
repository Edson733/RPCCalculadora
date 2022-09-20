package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoCalculadora {
    public boolean guardarOperaciones(String operacion, String num1, String num2, double resultado){
        boolean result = false;
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement pstm = connection.prepareStatement("insert into operations(`type`, first_number, second_number, result) values (?, ?, ?, ?);");
        ){
            pstm.setString(1, operacion);
            pstm.setString(2, num1);
            pstm.setString(3, num2);
            pstm.setDouble(4, resultado);
            result = pstm.executeUpdate()==1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
