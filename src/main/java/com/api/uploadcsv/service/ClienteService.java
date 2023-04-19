package com.api.uploadcsv.service;

import com.api.uploadcsv.model.ClienteModel;
import com.api.uploadcsv.repository.ClienteRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findALl() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(Long id) {
        return clienteRepository.findById(id);
    }
    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }

    public void update(ClienteModel clienteModel) {

    }

    public void cadastrarCsv() throws IOException, CsvException {


        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("d/MM/yyyy");

        Reader reader = Files.newBufferedReader(Paths.get("usuarios.csv"));

        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> linhas = csvReader.readAll();

        for (String[] coluna : linhas){

            var clienteModel = new ClienteModel();
            clienteModel.setNomeCompleto(coluna[0]);
            System.out.println(coluna[0]);
            clienteModel.setNomeSocial(coluna[1]);

            if (coluna[2].isEmpty() || coluna[2] == null) {
                clienteModel.setDataNascimento(null);
            }
            else {
                clienteModel.setDataNascimento(LocalDate.parse(coluna[2],formatoData));
            }

            clienteModel.setCodigo(parseInt(coluna[3],10));
            clienteModel.setSexo(coluna[4]);
            clienteModel.setEmail(coluna[5]);
            clienteModel.setEstado(coluna[6]);
            clienteModel.setMunicipio(coluna[7]);
            clienteModel.setQtdAcessos(parseInt(coluna[8],10));
            clienteModel.setStatusCurso(coluna[9]);

            if (coluna[10].isEmpty() || coluna[10] == null) {
                clienteModel.setDataVinculo(null);
            }
            else {
                clienteModel.setDataVinculo(LocalDate.parse(coluna[10],formatoData));
            }

            clienteRepository.saveAndFlush(clienteModel);
        }

    }

}
