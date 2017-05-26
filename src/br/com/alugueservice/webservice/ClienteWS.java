package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.ClienteController;
import br.com.alugueservice.dto.ClienteDTO;
import br.com.alugueservice.model.Cliente;

@Path("/Cliente")
public class ClienteWS
{
    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public ClienteDTO cadastrar(Cliente pCliente)
    {
        ClienteDTO tDto = ClienteController.cadastrar(pCliente);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO recuperar(@PathParam("id") int pId)
    {
        ClienteDTO tDto = ClienteController.recuperar(pId);
        // Retornando o resultado
        return tDto;
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO atualizar(Cliente pCliente)
    {
        ClienteDTO tDto = ClienteController.atualizar(pCliente);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO pesquisar()
    {
        ClienteDTO tDto = ClienteController.pesquisar();
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO pesquisarPorNome(@PathParam("nome") String pNome)
    {
        ClienteDTO tDto = ClienteController.pesquisarPorNome(pNome);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO pesquisarPorEmail(@PathParam("email") String pEmail)
    {
        ClienteDTO tDto = ClienteController.pesquisarPorEmail(pEmail);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorCpf/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO pesquisarPorCpf(@PathParam("cpf") String pCpf)
    {
        ClienteDTO tDto = ClienteController.pesquisarPorCpf(pCpf);
        // Retornando o resultado
        return tDto;
    }
}
