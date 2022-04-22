package lk.ijse.dep8.lmsbackend.api;

import jakarta.json.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType() == null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            return;
        }

//        BufferedReader reader = request.getReader();
//        StringBuilder sb = new StringBuilder();
//        reader.lines().forEach(line-> sb.append(line + "\n"));
//        System.out.println(sb.toString());

        /*JsonReader jsonReader = Json.createReader(request.getReader());
        JsonArray array = jsonReader.readArray();
        for (int i = 0; i < array.size(); i++) {
            JsonObject elm1 = array.getJsonObject(i);
            System.out.println(elm1.getString("id"));
            System.out.println(elm1.getString("name"));
        }*/

        /*response.setContentType("application/json");
        JsonWriter jsonWriter = Json.createWriter(response.getWriter());
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("id","C005");
        objectBuilder.add("name", "Ruwan");
        JsonObject obj = objectBuilder.build();
        jsonWriter.writeObject(obj);*/

        /*response.setContentType("application/json");
        JsonWriter jsonWriter = Json.createWriter(response.getWriter());
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(10);
        arrayBuilder.add(false);
        arrayBuilder.add(Json.createArrayBuilder().add(10).add(20).build());
        arrayBuilder.add(Json.createObjectBuilder().add("id","S002").add("name","Saman"));
        arrayBuilder.add(Json.createObjectBuilder().add("id","S009").add("name","Kusum"));

        JsonArray jsonArray = arrayBuilder.build();
        jsonWriter.writeArray(jsonArray);*/

       /* Jsonb jsonb = JsonbBuilder.create();
        List<Customer> customerList = jsonb.fromJson(request.getReader(),new ArrayList<Customer>(){}.getClass().getGenericSuperclass());

        customerList.forEach(System.out::println);

        List<Customer> anotherCustomerList = new ArrayList<>();
        anotherCustomerList.add(new Customer("C001","Nuwan","Galle"));
        anotherCustomerList.add(new Customer("C002","Saman","Colombo"));
        anotherCustomerList.add(new Customer("C002","Saman","Colombo"));
        anotherCustomerList.add(new Customer("C002","Saman","Colombo"));
        anotherCustomerList.add(new Customer("C002","Saman","Colombo"));
        anotherCustomerList.add(new Customer("C002","Saman","Colombo"));

        response.setContentType("application/json");
        jsonb.toJson(anotherCustomerList,response.getWriter());*/

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
