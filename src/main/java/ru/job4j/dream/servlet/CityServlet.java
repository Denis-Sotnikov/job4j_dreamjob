package ru.job4j.dream.servlet;

import org.json.simple.JSONObject;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/plain");
//        System.out.println("here");
//        resp.setCharacterEncoding("UTF-8");
//        Collection<City> cities = PsqlStore.instOf().findAllCities();
//        JSONObject jsonObject = new JSONObject();
//        for (City city : cities) {
//            jsonObject.put(city.getId(), city.getName());
//        }
//        for (City c : cities) {
//            System.out.println(c.getName());
//        }
//        PrintWriter writer = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(),
//                StandardCharsets.UTF_8), true);
//        writer.println(jsonObject);
//        writer.flush();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Map<Integer, String> cities = PsqlStore.instOf().findAllCitiesMap();
        JSONObject jsonObject = new JSONObject(cities);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(),
                StandardCharsets.UTF_8), true);
        writer.println(jsonObject);
        writer.flush();

    }
}