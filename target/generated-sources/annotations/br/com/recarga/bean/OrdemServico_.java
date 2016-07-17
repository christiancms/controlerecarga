package br.com.recarga.bean;

import br.com.recarga.bean.Pessoa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T12:42:47")
@StaticMetamodel(OrdemServico.class)
public class OrdemServico_ { 

    public static volatile SingularAttribute<OrdemServico, String> marca;
    public static volatile SingularAttribute<OrdemServico, String> defeito;
    public static volatile SingularAttribute<OrdemServico, String> solucao;
    public static volatile SingularAttribute<OrdemServico, Pessoa> pessoa;
    public static volatile SingularAttribute<OrdemServico, Date> dataEntrada;
    public static volatile SingularAttribute<OrdemServico, String> equipamento;
    public static volatile SingularAttribute<OrdemServico, String> acessorios;
    public static volatile SingularAttribute<OrdemServico, Long> idOrdServico;

}