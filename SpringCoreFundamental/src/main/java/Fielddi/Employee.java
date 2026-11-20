
package org.example.Fielddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    private Address address;

    public void getEmpAddress() {
        address.displayAddress();
    }
}
