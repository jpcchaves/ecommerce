package com.jpcchaves.ecommerce.utils;

public class EmailTemplateUtil {

  public static String buildConfirmationEmail(
      String name,
      String email,
      String password
  ) {
    StringBuilder html = new StringBuilder();

    html.append("<html>")
        .append("<head>")
        .append("<title>Confirmação de Cadastro</title>")
        .append("<style>")
        .append("body { font-family: Arial, sans-serif; }")
        .append(".container { max-width: 600px; margin: 0 auto; padding: " +
                    "20px; border: 1px solid #ccc; border-radius: 10px; }")
        .append(".header { text-align: center; }")
        .append(".content { margin-top: 20px; }")
        .append(".footer { margin-top: 30px; text-align: center; color: #888;" +
                    " font-size: 12px; }")
        .append("</style>")
        .append("</head>")
        .append("<body>")
        .append("<div class=\"container\">")
        .append("<div class=\"header\">")
        .append("<h1>Bem-vindo, ")
        .append(name)
        .append("!</h1>")
        .append("</div>")
        .append("<div class=\"content\">")
        .append("<p>Obrigado por se cadastrar em nosso site. Estamos felizes " +
                    "em tê-lo conosco.</p>")
        .append("<br />")
        .append("<p>Dados para acessar:</p>")
        .append("<p>Login: <b>")
        .append(email)
        .append("</b></p>")
        .append("<p>Senha: <b>")
        .append(password)
        .append("</b></p>")
        .append("</div>")
        .append("<div class=\"footer\">")
        .append("<p>Se você não se cadastrou em nosso site, por favor ignore " +
                    "este e-mail.</p>")
        .append("</div>")
        .append("</div>")
        .append("</body>")
        .append("</html>");

    return html.toString();
  }
}
