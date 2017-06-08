package br.com.alugueservice.pwai.email.send;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.alugueservice.model.Cliente;

public class SendMail1
{

    public Boolean enviarEmail(Cliente cliente)
    {
        if (cliente.getEmail().length() == 0)
        {
            return false;
        }

        String tSenha = obterSenha();
        String tServidor = "smtp.gmail.com";
        String tPorta = "465";
        String tUsuario = "contato.alugueservice@gmail.com";
        String tDestino = cliente.getEmail();
        String tOrigem = "contato.alugueservice@gmail.com";

        Properties tPropriedades = new Properties();
        tPropriedades.put("mail.smtp.host", tServidor);
        tPropriedades.put("mail.smtp.port", tPorta);
        tPropriedades.put("mail.smtp.user", tUsuario);
        tPropriedades.put("mail.smtp.auth", "true");
        tPropriedades.put("mail.smtp.debug", "true");
        tPropriedades.put("mail.smtp.socketFactory.port", tPorta);
        tPropriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        tPropriedades.put("mail.smtp.socketFactory.fallback", "false");

        // Obtendo o objeto Session
        Session tSessao = Session.getInstance(tPropriedades, new Autenticador(tUsuario, tSenha));

        try
        {
            // Criando a mensagem
            Message tMensagem = new MimeMessage(tSessao);

            // Configurando a mensagem.
            tMensagem.setFrom(new InternetAddress(tOrigem));
            tMensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tDestino));
            tMensagem.setSubject("AlugueService");
            tMensagem.setText("Olá " + cliente.getNome() + " " + cliente.getSobrenome()
                            + " seja bem vindo a AlugueService, siga nosso twitter @alugueservice para acompanhar as novidades.");

            // Enviando a mensagem
            Transport.send(tMensagem);
            return true;
        }
        catch (MessagingException tExcept)
        {
            return false;
        }
    }

    private static String obterSenha()
    {

        return "alugueService_1";
    }

    private static class Autenticador extends Authenticator
    {
        private String mUsuario;
        private String mSenha;

        public Autenticador(String pUsuario, String pSenha)
        {
            super();
            mUsuario = pUsuario;
            mSenha = pSenha;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(mUsuario, mSenha);
        }
    }
}
