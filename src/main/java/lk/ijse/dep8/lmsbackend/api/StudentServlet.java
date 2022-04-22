package lk.ijse.dep8.lmsbackend.api;

import jakarta.json.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import lk.ijse.dep8.lmsbackend.dto.StudentDTO;
import lk.ijse.dep8.lmsbackend.exception.ValidationException;

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

        Jsonb jsonb = JsonbBuilder.create();

        try{
            StudentDTO student = jsonb.fromJson(request.getReader(),new ArrayList<StudentDTO>(){}.getClass().getGenericSuperclass());

            if (student.getName() == null || !student.getName().matches("[A-Za-z]+")){
                throw new ValidationException("Invalid name");
            } else if (student.getEmail() == null || !student.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
                throw new ValidationException("Invalid email");
            } else if (student.getNic() == null || !student.getNic().matches("\\d{9}[Vv]")){
                throw new ValidationException("Invalid nic");
            }

            System.out.println(student);
        } catch (JsonbException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid JSON");
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
