package ru.razum0ff.sqlpostgrestest.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import ru.razum0ff.sqlpostgrestest.entity.MyTableEntity;
import ru.razum0ff.sqlpostgrestest.repository.MyTableRepository;

import java.util.Set;

@Service
public class MyTableService {

    final
    MyTableRepository myTableRepository;

    public MyTableService(MyTableRepository myTableRepository) {
        this.myTableRepository = myTableRepository;
    }

    public String getValuesByKod(Short kod){
        Set<MyTableEntity> entities = myTableRepository.getValuesByKod(kod);

        JsonArray jsonArray = new JsonArray();
        for (MyTableEntity entity : entities){
            JsonObject object = new JsonObject();
            object.addProperty("name", entity.getName());
            object.addProperty("kodGG", entity.getKodGG());
            object.addProperty("email", entity.getEmail());
            object.addProperty("city", entity.getCity());
            jsonArray.add(object);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonArray);
    }
}
