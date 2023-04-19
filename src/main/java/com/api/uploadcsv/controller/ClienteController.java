package com.api.uploadcsv.controller;

import com.api.uploadcsv.dtos.ClienteDto;
import com.api.uploadcsv.model.ClienteModel;
import com.api.uploadcsv.service.ClienteService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/projeto")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDto clienteDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @PostMapping(value ="/registro-csv")
    public void registroCsv() throws IOException, CsvException {
        clienteService.cadastrarCsv();
        ResponseEntity.status(HttpStatus.OK).body(clienteService.findALl());
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findALl());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserCliente (@PathVariable(value = "id") Long id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserCliente (@PathVariable(value = "id") Long id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserCliente (@PathVariable(value = "id") Long id,
                                                     @RequestBody ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        var clienteModel = clienteModelOptional.get();
        clienteModel.setNomeCompleto(clienteDto.getNomeCompleto());
        clienteModel.setNomeSocial(clienteDto.getNomeSocial());
        clienteModel.setDataNascimento(clienteDto.getDataNascimento());
        clienteModel.setCodigo(clienteDto.getCodigo());
        clienteModel.setSexo(clienteDto.getSexo());
        clienteModel.setEmail(clienteDto.getEmail());
        clienteModel.setEstado(clienteDto.getEstado());
        clienteModel.setMunicipio(clienteDto.getMunicipio());
        clienteModel.setQtdAcessos(clienteDto.getQtdAcessos());
        clienteModel.setStatusCurso(clienteDto.getCursoStatus());
        clienteModel.setDataVinculo(clienteDto.getDataVinculo());

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }

}
