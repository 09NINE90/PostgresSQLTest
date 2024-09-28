package ru.razum0ff.sqlpostgrestest.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import ru.razum0ff.sqlpostgrestest.entity.MyTableEntity;
import ru.razum0ff.sqlpostgrestest.repository.MyTableRepository;
import ru.razum0ff.sqlpostgrestest.repository.NameIdRepository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TestService {
    private final ConcurrentHashMap<Short, String> cache = new ConcurrentHashMap<>();
    final MyTableRepository myTableRepository;
    final NameIdRepository nameIdRepository;

    public TestService(MyTableRepository myTableRepository, NameIdRepository nameIdRepository) {
        this.myTableRepository = myTableRepository;
        this.nameIdRepository = nameIdRepository;
    }

    public String getValuesByKod(Short kod){
        long startTime = System.currentTimeMillis();
        String cachedValue = cache.get(kod);
        if (cachedValue != null) {
            System.out.println("Получено из кэша");
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Время выполнения: " + executionTime + " миллисекунд");
            return cachedValue;
        }
        Set<MyTableEntity> entities = myTableRepository.getValuesByKod(kod);
        String name = nameIdRepository.getNameByKod(kod);
        JsonArray jsonArray = new JsonArray();
        for (MyTableEntity entity : entities){
            JsonObject object = new JsonObject();
            object.addProperty("name", entity.getName());
            object.addProperty("age", entity.getAge());
            object.addProperty("nameBank", name);
            object.addProperty("kodGG", entity.getKodGG());
            object.addProperty("email", entity.getEmail());
            object.addProperty("city", entity.getCity());
            object.addProperty("dateWrite", String.valueOf(entity.getDateWrite()));
            jsonArray.add(object);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        /* Добавляем в кэш */
        cache.put(kod, gson.toJson(jsonArray));
        System.out.println("Время выполнения: " + executionTime + " миллисекунд");
        return gson.toJson(jsonArray);
    }
}
