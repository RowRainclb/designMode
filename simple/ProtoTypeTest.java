package com.example.demo.prototype.simple;



import java.util.ArrayList;
import java.util.List;

public class ProtoTypeTest {
    public static void main(String[] args) {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setName("clb");
        prototypeA.setAge(11);

        List hobbit = new ArrayList<String>();
        prototypeA.setHobbis(hobbit);

        Client client = new Client( );
        PrototypeA prototypeA1 = (PrototypeA) client.clone(prototypeA);

        System.out.println(prototypeA.getHobbis() == prototypeA1.getHobbis());
    }
}
