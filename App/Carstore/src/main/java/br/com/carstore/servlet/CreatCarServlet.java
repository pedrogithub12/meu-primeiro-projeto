package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-car")
public class CreatCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("car-name");

       String color = req.getParameter("color");

       Car car = new Car();
       car.setName(name);

       car.setColor(color);

        CarDao carDao = new CarDao();
        carDao.createCar(car);


        req.getRequestDispatcher("index.html").forward(req, resp);


    }
}
