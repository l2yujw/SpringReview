package hello.core1.singleton;

import lombok.AccessLevel;
import lombok.Getter;

public class StatefulService {

    @Getter
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;
    }
}
