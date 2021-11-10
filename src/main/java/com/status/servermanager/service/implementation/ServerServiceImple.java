package com.status.servermanager.service.implementation;

import com.status.servermanager.enumeration.Status;
import com.status.servermanager.model.Server;
import com.status.servermanager.repository.ServerRepository;
import com.status.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import static com.status.servermanager.enumeration.Status.SERVER_DOWN;
import static com.status.servermanager.enumeration.Status.SERVER_UP;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImple implements ServerService {

    private final ServerRepository repository;

    @Override
    public Server create(Server server) {
        log.info("Salvando Servidor: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return repository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Verificando Servidor IP: {}", ipAddress);
        Server server = repository.findByIpAddress(ipAddress);

        /*Pega o IP pelo nome e depois verifica se o mesmo esta respondendo ao Ping em seguida ele salva
        * na base de dados o status do servidor */
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        repository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String setServerImageUrl() {
        return null;
    }
}
