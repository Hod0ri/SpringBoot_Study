import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setName("김민식");
        user.setAge(25);

        Car k5 = new Car();
        k5.setCarNumber("47허 1233");
        k5.setName("K5");
        k5.setType("중형차");

        Car k3 = new Car();
        k3.setCarNumber("27허 3323");
        k3.setName("K3");
        k3.setType("소형차");

        List<Car> carlist = Arrays.asList(k5, k3);
        user.setCars(carlist);

        System.out.println(user.toString());

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode)cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode)jsonNode;

        objectNode.put("name", "김민수");
        objectNode.put("age", 23);

        System.out.println(objectNode.toPrettyString());
    }
}
