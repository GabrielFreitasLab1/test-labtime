package com.api.uploadcsv.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.text.DateFormat;
import java.time.LocalDate;

public class ClienteDto {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String nomeSocial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotBlank
    private int codigo;
    @Size(max = 1)
    private String sexo;
    @NotBlank
    private String email;
    private String estado;
    private String municipio;
    @NotBlank
    private int qtdAcessos;
    private String cursoStatus;
    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVinculo;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getQtdAcessos() {
        return qtdAcessos;
    }

    public void setQtdAcessos(int qtdAcessos) {
        this.qtdAcessos = qtdAcessos;
    }

    public String getCursoStatus() {
        return cursoStatus;
    }

    public void setCursoStatus(String cursoStatus) {
        this.cursoStatus = cursoStatus;
    }

    public LocalDate getDataVinculo() {
        return dataVinculo;
    }

    public void setDataVinculo(LocalDate dataVinculo) {
        this.dataVinculo = dataVinculo;
    }
}
