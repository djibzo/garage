package com.garage.clientservice.Services;

import com.garage.clientservice.dto.ClientResponseDTO;
import com.garage.clientservice.dto.CreateClientRequest;
import com.garage.clientservice.Entities.Client;
import com.garage.clientservice.Repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    public ClientResponseDTO createClient(CreateClientRequest request) {
        Client client = toEntity(request);
        return toResponseDTO(clientRepository.save(client));
    }

    public ClientResponseDTO updateClient(Long id, CreateClientRequest request) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) return null;

        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setEmail(request.getEmail());
        client.setTelephone(request.getTelephone());
        client.setPassword(request.getPassword());

        return toResponseDTO(clientRepository.save(client));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    private Client toEntity(CreateClientRequest request) {
        return Client.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .telephone(request.getTelephone())
                .password(request.getPassword())
                .build();
    }

    private ClientResponseDTO toResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .build();
    }
}
