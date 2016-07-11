/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maicon
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long idPessoa;
    @Column(name = "nome_razsoc")
    private String nomeRazsoc;
    @Column(name = "sobrenome_fantasia")
    private String sobrenomeFantasia;
    @Column(name = "aniver_abertura")
    @Temporal(TemporalType.DATE)
    private Date aniverAbertura;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "tipo_pessoa", length = 1)
    private String tipoPessoa; // Pessoa Física ou Pessoa Jurídica
    @Column(name = "fisica_juridica")
    private String fisicaJuridica;
    @Column(name = "docrg_insest")
    private String docrgInsest;
    @Column(name = "categoria", length = 1)
    private String categoria; // Cliente, Fornecedor, Transportadora, Outros
    @Column(name = "observacao", length = 500)
    private String observacao;
    //---------------- Endereço ----------------
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "pessoa")
    private List<OrdemServico> servicos;
    

    private static final long serialVersionUID = 1L;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomeRazsoc() {
        return nomeRazsoc;
    }

    public void setNomeRazsoc(String nomeRazsoc) {
        this.nomeRazsoc = nomeRazsoc;
    }

    public String getSobrenomeFantasia() {
        return sobrenomeFantasia;
    }

    public void setSobrenomeFantasia(String sobrenomeFantasia) {
        this.sobrenomeFantasia = sobrenomeFantasia;
    }

    public Date getAniverAbertura() {
        return aniverAbertura;
    }

    public void setAniverAbertura(Date aniverAbertura) {
        this.aniverAbertura = aniverAbertura;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getFisicaJuridica() {
        return fisicaJuridica;
    }

    public void setFisicaJuridica(String fisicaJuridica) {
        this.fisicaJuridica = fisicaJuridica;
    }

    public String getDocrgInsest() {
        return docrgInsest;
    }

    public void setDocrgInsest(String docrgInsest) {
        this.docrgInsest = docrgInsest;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<OrdemServico> getServicos() {
        return servicos;
    }

    public void setServicos(List<OrdemServico> servicos) {
        this.servicos = servicos;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
