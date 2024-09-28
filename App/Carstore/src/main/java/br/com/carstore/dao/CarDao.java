package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDao {

        public void createCar(Car car){

            String SQL = "INSERT INTO CAR (NAME, COLOR) VALUES (?, ?)";

            try {

               Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

                System.out.println("Sucesso ao se conectar com o banco de dados!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(2, car.getColor());
                preparedStatement.setString(1, car.getName());


                preparedStatement.execute();

                System.out.println("Sucesso ao inserir o carro no DB!");

            }catch (Exception e){

                System.out.println("Falha ao gravar carro no DB: " + e.getMessage());
            }

        }
}
