package ru.razum0ff.sqlpostgrestest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.razum0ff.sqlpostgrestest.service.TestService;

@RestController
@RequestMapping("/test")
public class MyTableApi {

    final
    TestService testService;

    public MyTableApi(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/getValuesByKod")
    public String getValuesByKod(
            @RequestParam(name = "kod") Short kod
            ){
        return testService.getValuesByKod(kod);
    }
}
