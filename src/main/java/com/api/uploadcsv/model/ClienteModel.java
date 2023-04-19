package com.api.uploadcsv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "nomeCompleto")
    private String nomeCompleto;
    @Column(name = "nomeSocial")
    private String nomeSocial;
    @Column(name = "dataNascimento")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private String estado;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "qtdAcessos")
    private int qtdAcessos;
    @Column(name = "statusCurso")
    private String statusCurso;
    @Column(name = "dataVinculo")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataVinculo;

    public ClienteModel(long id, String nomeCompleto, String nomeSocial, LocalDate dataNascimento, int codigo, String sexo, String email, String estado, String municipio, int qtdAcessos, String statusCurso, LocalDate dataVinculo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.dataNascimento = dataNascimento;
        this.codigo = codigo;
        this.sexo = sexo;
        this.email = email;
        this.estado = estado;
        this.municipio = municipio;
        this.qtdAcessos = qtdAcessos;
        this.statusCurso = statusCurso;
        this.dataVinculo = dataVinculo;
    }

    public ClienteModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(String statusCurso) {
        this.statusCurso = statusCurso;
    }

    public LocalDate getDataVinculo() {
        return dataVinculo;
    }

    public void setDataVinculo(LocalDate dataVinculo) {
        this.dataVinculo = dataVinculo;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", codigo=" + codigo +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", qtdAcessos=" + qtdAcessos +
                ", statusCurso='" + statusCurso + '\'' +
                ", dataVinculo=" + dataVinculo +
                '}';
    }

}
