package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.ConfiguracaoController;
import br.com.alugueservice.dto.ConfiguracaoDTO;
import br.com.alugueservice.model.Configuracao;
@Path("/Configuracao")
public class ConfiguracaoWS
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ConfiguracaoDTO cadastrar(Configuracao pConfiguracao)
    {
        ConfiguracaoDTO tDto = ConfiguracaoController.cadastrar(pConfiguracao);

        // Retornando o resultado
        return tDto;
    }

    @POST
    @Path("/Cadastrar2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Configuracao cadastrar2(Configuracao pConfiguracao)
    {
        ConfiguracaoDTO tDto = ConfiguracaoController.cadastrar(pConfiguracao);
        // Retornando o resultado
        return tDto.getConfiguracao();
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ConfiguracaoDTO recuperar(@PathParam("id") int pId)
    {
        ConfiguracaoDTO tDto = ConfiguracaoController.recuperar(pId);
        // Retornando o resultado
       return tDto;
    }

    @GET
    @Path("/Pesquisar/")
    @Produces(MediaType.APPLICATION_JSON)
    public ConfiguracaoDTO pesquisar()
    {
        ConfiguracaoDTO tDto = ConfiguracaoController.pesquisar();
        // Retornando o resultado
       return tDto;
    }

    @GET
    @Path("/PesquisarUltimo/")
    @Produces(MediaType.APPLICATION_JSON)
    public ConfiguracaoDTO pesquisarUltimo()
    {
        ConfiguracaoDTO tDto = ConfiguracaoController.pesquisarUltimo();
        // Retornando o resultado
       return tDto;
    }
}
