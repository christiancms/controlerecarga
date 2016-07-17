package br.com.recarga.bean;

import br.com.recarga.bean.Endereco;
import br.com.recarga.bean.OrdemServico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T12:42:47")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile ListAttribute<Pessoa, OrdemServico> servicos;
    public static volatile SingularAttribute<Pessoa, String> telefone;
    public static volatile SingularAttribute<Pessoa, String> tipoPessoa;
    public static volatile SingularAttribute<Pessoa, String> observacao;
    public static volatile SingularAttribute<Pessoa, String> sobrenomeFantasia;
    public static volatile SingularAttribute<Pessoa, String> fisicaJuridica;
    public static volatile SingularAttribute<Pessoa, String> docrgInsest;
    public static volatile SingularAttribute<Pessoa, String> categoria;
    public static volatile SingularAttribute<Pessoa, Date> aniverAbertura;
    public static volatile SingularAttribute<Pessoa, Long> idPessoa;
    public static volatile ListAttribute<Pessoa, Endereco> enderecos;
    public static volatile SingularAttribute<Pessoa, String> nomeRazsoc;
    public static volatile SingularAttribute<Pessoa, String> celular;
    public static volatile SingularAttribute<Pessoa, String> email;

}