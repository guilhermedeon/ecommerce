package com.g11.ecommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JsonService {

    private final ObjectWriter ow;

    public JsonService(){
        this.ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }

    public String toJson(Object object) throws JsonProcessingException {
        return ow.writeValueAsString(object);
    }

    public String toJson(List<Object> objectList) throws JsonProcessingException {
        StringBuilder xstring = new StringBuilder();
        for (Object object : objectList){
            String json = this.toJson(object);
            xstring.append(json);
        }
        return xstring.toString();
    }
}




