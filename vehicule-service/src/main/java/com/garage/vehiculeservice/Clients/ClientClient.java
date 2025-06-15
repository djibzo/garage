package com.garage.vehiculeservice.Clients;

import org.springframework.web.bind.annotation.PathVariable;

public interface ClientClient {
    void getClientById(@PathVariable("id") Long id);
}
