package ru.razum0ff.sqlpostgrestest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.razum0ff.sqlpostgrestest.service.MyTableService;

@RestController
@RequestMapping("/test")
public class MyTableApi {

    final
    MyTableService myTableService;

    public MyTableApi(MyTableService myTableService) {
        this.myTableService = myTableService;
    }

    @GetMapping("/getValuesByKod")
    public String getValuesByKod(
            @RequestParam(name = "kod") Short kod
    ){
        return myTableService.getValuesByKod(kod);
    }
}
