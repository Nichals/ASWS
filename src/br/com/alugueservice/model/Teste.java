package br.com.alugueservice.model;

import br.com.alugueservice.controller.ConfiguracaoController;
import br.com.alugueservice.controller.PreAluguelController;
import br.com.alugueservice.controller.ProdutoController;
import br.com.alugueservice.dto.ConfiguracaoDTO;
import br.com.alugueservice.dto.PreAluguelDTO;
import br.com.alugueservice.dto.ProdutoDTO;
import br.com.alugueservice.util.HibernateUtil;

public class Teste
{

    @SuppressWarnings("unused")
    public static void main(String[] args)
    {

        Configuracao pConfiguracao = new Configuracao();
        PreAluguel preAluguel = new PreAluguel();
        Produto produto = new Produto();
        Produto produto2 = new Produto();
        /*

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        Operador pOperadorCriador = new Operador();
        Operador operador2 = new Operador();



        pOperadorCriador.setCpf("111.111.111-11");
        endereco.setBairro("Bairro operador");
        endereco.setCep("11111-111");
        endereco.setCidade("Cidade operador");
        endereco.setNumero("123");
        endereco.setRua("Rua operador");


        pOperadorCriador.setDataCriacao(636149376000000000L);
        pOperadorCriador.setDataNascimento(629335872000000000L);
        pOperadorCriador.setEmail("teste@teste.com");
        pOperadorCriador.setLogin("admin");
        pOperadorCriador.setSenha("admin");
        pOperadorCriador.setNome("Admin");
        pOperadorCriador.setSobrenome("Admin");
        pOperadorCriador.setNivel(1);
        pOperadorCriador.setCelular("(11)91111-1111");
        pOperadorCriador.setTelefone("(11)1111-1111");
        pOperadorCriador.setEndereco(endereco);
        pOperadorCriador.setOperadorCriador(1);
        pOperadorCriador.setStatus(1);
        HibernateUtil.iniciarSessao();
        OperadorDTO operadorH = OperadorController.cadastrar(pOperadorCriador);
        HibernateUtil.confirmarSessao();

        operador2.setDataCriacao(636149376000000000L);
        operador2.setDataNascimento(629335872000000000L);
        operador2.setEmail("teste@teste.com");
        operador2.setLogin("admin2");
        operador2.setSenha("admin");
        operador2.setNome("Admin");
        operador2.setSobrenome("Admin");
        operador2.setCelular("(11)81111-1112");
        operador2.setTelefone("(11)1111-1112");
        operador2.setEndereco(endereco);
        operador2.setOperadorCriador(1);
        operador2.setNivel(1);
        operador2.setStatus(1);
        operador2.setCpf("111.111.111-12");
        HibernateUtil.iniciarSessao();
        OperadorDTO operadorH2 = OperadorController.cadastrar(operador2);
        HibernateUtil.confirmarSessao();
        System.out.println(operadorH2.getMensagem());
        cliente.setNome("Teste");
        cliente.setSobrenome("Testaldo");
        cliente.setCelular("(11)91111-1113");
        cliente.setTelefone("(111111-1114");
        cliente.setCpf("111.111.121-15");
        cliente.setEmail("cliente@email.com");
        cliente.setStatus(1);
        cliente.setEndereco(endereco);
        cliente.setOperadorCriador(2);
        HibernateUtil.iniciarSessao();
        ClienteDTO clienteHiber = ClienteController.cadastrar(cliente);
        HibernateUtil.confirmarSessao();
*/

        produto.setNome("Terno");
        produto.setDataCriacao(636149376000000000L);
        produto.setGenero("M");
        produto.setStatus(1);
        produto.setTamanho("G");
        produto.setValor((float) 100);
        produto.setQuantidadeAluguel(0);
        produto.setOperadorCriador(2);
        produto2.setNome("Cueca");
        produto2.setQuantidadeAluguel(0);
        produto2.setDataCriacao(636149376000000000L);
        produto2.setGenero("M");
        produto2.setStatus(1);
        produto2.setTamanho("G");
        produto2.setValor((float) 100);
        produto2.setOperadorCriador(2);
        HibernateUtil.iniciarSessao();
        ProdutoDTO produtoHiber = ProdutoController.cadastrar(produto);
        HibernateUtil.confirmarSessao();
        HibernateUtil.iniciarSessao();
        ProdutoDTO produtoHiber2 = ProdutoController.cadastrar(produto2);
        HibernateUtil.confirmarSessao();
        produto2 = produtoHiber2.getProduto();

        pConfiguracao.setContrato("aa");
        pConfiguracao.setCupom((float) 150);
        HibernateUtil.iniciarSessao();
        ConfiguracaoDTO cHiber = ConfiguracaoController.cadastrar(pConfiguracao);
        HibernateUtil.confirmarSessao();

        Cliente clientePreAluguel = new Cliente();
        clientePreAluguel.setIdCliente(2);

        Configuracao configuracaoPreAluguel = new Configuracao();
        configuracaoPreAluguel.setIdConfiguracao(1);

        preAluguel.getListaProdutos().add(produtoHiber.getProduto());
        preAluguel.getListaProdutos().add(produtoHiber2.getProduto());
        preAluguel.setCliente(clientePreAluguel);
        preAluguel.setOperadorCriador(2);
        preAluguel.setConfiguracao(configuracaoPreAluguel);
        preAluguel.setDataPrevista(0);
        preAluguel.setStatusPreAluguel(1);

        float a = 0;
        for (Produto itens : preAluguel.getListaProdutos())
        {
            a += itens.getValor();
        }
        preAluguel.setValorAluguel(a);
        HibernateUtil.iniciarSessao();
        PreAluguelDTO preAluguelH = PreAluguelController.cadastrar(preAluguel);
        HibernateUtil.confirmarSessao();

    }

}
