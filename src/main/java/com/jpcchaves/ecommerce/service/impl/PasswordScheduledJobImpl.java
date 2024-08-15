package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.Usuario;
import com.jpcchaves.ecommerce.repository.UsuarioRepository;
import com.jpcchaves.ecommerce.service.EmailService;
import com.jpcchaves.ecommerce.service.PasswordScheduledJob;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class PasswordScheduledJobImpl implements PasswordScheduledJob {

//    private static final int TWO_SECONDS_IN_MILLIS = 2000;
//    private static final int ONE_DAY_IN_MILLIS = 86400000;

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public PasswordScheduledJobImpl(UsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    @Override
//    @Scheduled(initialDelay = TWO_SECONDS_IN_MILLIS, fixedDelay = ONE_DAY_IN_MILLIS)
    @Scheduled(cron = "0 0 11 * * *", zone = "America/Sao_Paulo") // Run every day 11 AM
    public void notifyUserChangePassword() throws MessagingException, UnsupportedEncodingException, InterruptedException {

        List<Usuario> usuarioList = usuarioRepository.listUsuarioSenhaVencida();

        for (Usuario usuario : usuarioList) {

            StringBuilder msg = new StringBuilder();

            msg.append("Ola, ").append(usuario.getPessoa().getNome()).append("</br>");
            msg.append("Esta na hora de atualizar a sua senha, ja se passaram 90 dias").append("</br>");
            msg.append("Troque sua senha na Loja Virtual");

            emailService.send("Troca de senha", msg.toString(), usuario.getLogin());

            Thread.sleep(3000);
        }

    }
}
