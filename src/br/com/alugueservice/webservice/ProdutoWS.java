package br.com.alugueservice.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alugueservice.controller.ProdutoController;
import br.com.alugueservice.dto.ProdutoDTO;
import br.com.alugueservice.model.Produto;

@Path("/Produto")
public class ProdutoWS
{

    @POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO cadastrar(Produto pProduto)
    {
        ProdutoDTO tDto = ProdutoController.cadastrar(pProduto);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO recuperar(@PathParam("id") int pId)
    {
        ProdutoDTO tDto = ProdutoController.recuperar(pId);
        // Retornando o resultado
        return tDto;
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO atualizar(Produto pProduto)
    {
        ProdutoDTO tDto = ProdutoController.atualizar(pProduto);
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO pesquisar()
    {
        ProdutoDTO tDto = ProdutoController.pesquisar();
        // Retornando o resultado
        return tDto;
    }

    @GET
    @Path("/PesquisarPorNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO pesquisarPorNome(@PathParam("nome") String pNome)
    {
        ProdutoDTO tDto = ProdutoController.pesquisarPorNome(pNome);
        // Retornando o resultado
        return tDto;
    }

    @PUT
    @Path("/AlterarStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO alterarStatus(Produto pProduto)
    {
        ProdutoDTO tDto = ProdutoController.alterarStatus(pProduto);
        // Retornando o resultado
        return tDto;
    }

}
