package com.proint1.udea.notificaciones;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @author jk
 *
 */
public class UdeaEmailService implements Serializable {

  /** serialVersionUID **/
  private static final long serialVersionUID = -3350997266503480906L;

  /**
   * Ruta donde se encuentran ubicadas las plantillas para los correos electrónicos.
   */
  private static final String RUTA_PLANTILLAS = "/";

  /** Codificación por defecto para el correo. */
  private static final String DEFAULT_ENCODING = "ISO-8859-1";

  /** Nombre de la plantilla base para la firma */
  private static final String PLANTILLA_STANDARD_MESSAGE_TEMPLATE = "PlantillaCorreo.html";

  /**
   * Log
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UdeaEmailService.class);

  /**
      * 
      */
  private UdeaEmailService() {

  }

  /**
   * Agregar logo al correo
   * 
   * @param mail
   */
  private static synchronized void addLogo(EMailHtml mail) {
    // CID del logo de la firma
    InputStream inputStream = null;
    FileOutputStream outputStream = null;
    try {

      inputStream = UdeaEmailService.class.getResourceAsStream(RUTA_PLANTILLAS + "UdeA.gif");
      File temporal = File.createTempFile(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(8, 20)), ".tmp");
      outputStream = new FileOutputStream(temporal);
      int read = 0;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, read);
      }
      // Si no esta el archivo se envia sin logo
      if (temporal.exists()) {
        mail.addCID("logoUdeA", temporal.getCanonicalPath());
      }
    } catch (Exception e) {
      LOGGER.error(" Exception sendMessage", e);
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          LOGGER.error("inputStream sendMessage", e);
        }
      }
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          LOGGER.error("IOException sendMessage", e);
        }

      }
    }
  }

  /**
   * Send message
   * 
   * @param subject
   * @param mensaje
   * @param emailsTo
   * @param emailsCc
   * @param emailsBcc
   * @param attachments
   * @throws IOException
   * @throws TemplateException
   * @throws MessagingException
   */
  private static synchronized void sendMessage(String subject, String mensaje, List<String> emailsTo, List<String> emailsCc, List<String> emailsBcc, List<String> attachments) throws IOException, TemplateException, MessagingException {

    String messageSignature = procesarBodyHtml(mensaje, "");

    InternetAddress[] adressesTo = convertAdresss(emailsTo == null ? new ArrayList<String>() : emailsTo);
    InternetAddress[] adressesCc = convertAdresss(emailsCc == null ? new ArrayList<String>() : emailsCc);
    InternetAddress[] adressesBcc = convertAdresss(emailsBcc == null ? new ArrayList<String>() : emailsBcc);

    // Definir el mensaje de email.
    EMailHtml mail = new EMailHtml(subject, mensaje);
    mail.setAdressesTo(adressesTo);
    mail.setAdressesCc(adressesCc);
    mail.setAdressesBcc(adressesBcc);
    // Agregar contenido
    mail.addContent(messageSignature);

    // Agregar Archivos Adjuntos
    if (attachments != null) {
      for (String fileName : attachments) {
        mail.addAttach(fileName);
      }
    }
    addLogo(mail);
    mail.sendMessage();
  }

  /**
   * throwException
   * 
   * @param e
   * @throws UdeAEmailSenderException
   */
  private static synchronized void throwException(Exception e) throws UdeAEmailSenderException {
    if (e instanceof AuthenticationFailedException) {
      // Si falla por error de autenticacion en el servidor de correos.
      throw new UdeAEmailSenderException("Falla por error de autenticación en el servidor de correos. Posible datos de conexión " + "vencidos o cambios en la cuenta de conexión.", e);
    } else if (e instanceof IllegalStateException) {
      // Si falla pero la conexión está establecida
      throw new UdeAEmailSenderException("Falla con conexión está establecida", e);
    } else if (e instanceof SendFailedException) {
      // Si el envio de los correso falla por la inscripcion de
      // direcciones invalidas.
      throw new UdeAEmailSenderException("Falla por inscripción de direcciones invalidas.", e);
    } else if (e instanceof MessagingException) {
      // Si la conexión ha muerto o por alguna razón ya no está
      // conectado
      throw new UdeAEmailSenderException("Falla por conexión perdida", e);
    } else {
      // Si esxiste alguno otro tipo de error.
      throw new UdeAEmailSenderException("Otro tipo de falla de las nombradas en la clase Email.java", e);
    }
  }

  /**
   * Envio de notificaciones
   * @param subject Sujeto del mensaje
   * @param mensaje Mensaje a enviar
   * @param emailsTo lista de destinatarios
   * @param emailsCc Lista de destinatarios CC
   * @param emailsBcc Lista de destinatarios BCC
   * @param attachments Lista de documentos adjuntar
   * @return
   * @throws UdeAEmailSenderException
   */
  public static synchronized boolean sendEmail(String subject, String mensaje, List<String> emailsTo, List<String> emailsCc, List<String> emailsBcc, List<String> attachments) throws UdeAEmailSenderException {

    boolean resultado = true;
    try {
      // Se procesa el mensaje junto con la firma en formato Html
      sendMessage(subject, mensaje, emailsTo, emailsCc, emailsBcc, attachments);
    } catch (Exception e) {
      throwException(e);
    }
    return resultado;
  }

  /**
   * Procesa el cuerpo del mensaje en foprmato html
   * 
   * @param mensaje
   * @param signature
   * @return
   * @throws IOException
   * @throws TemplateException
   */
  private static String procesarBodyHtml(String mensaje, String signature) throws IOException, TemplateException {
    String cuerpoMensaje = ajustarSaltoLinea(mensaje);
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00f1", "&ntilde;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00d1", "&Ntilde;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00e1", "&aacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00e9", "&eacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00ed", "&iacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00f3", "&oacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00fa", "&uacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00c1", "&Aacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00c9", "&Eacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00cd", "&Iacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00d3", "&Oacute;");
    cuerpoMensaje = cuerpoMensaje.replaceAll("\u00da", "&Uacute;");
    if (signature != null) {
      String signatureLinea = ajustarSaltoLinea(signature);
      // Configuración de Freemarker para obtener las plantillas y
      // construir los mensajes.
      BeansWrapper.getDefaultInstance().setExposeFields(true);
      Configuration cfg = new Configuration();
      cfg.setTemplateLoader(new ClassTemplateLoader(UdeaEmailService.class, RUTA_PLANTILLAS));
      cfg.setObjectWrapper(BeansWrapper.getDefaultInstance());
      cfg.setDefaultEncoding(DEFAULT_ENCODING);
      Map<String, Object> parametros = new HashMap<String, Object>();
      parametros.put("body", cuerpoMensaje + "<BR>" + signatureLinea + "</BR>");
      // Se procesa la plantilla ingresandole los parámetros
      // necesarios.
      Template templateMensaje = cfg.getTemplate(PLANTILLA_STANDARD_MESSAGE_TEMPLATE);

      cuerpoMensaje = procesarTemplate(templateMensaje, parametros);
    }
    return cuerpoMensaje;
  }

  /**
   * Ajusta los saltos de linea en html
   * 
   * @param mensaje
   * @return
   */
  private static String ajustarSaltoLinea(String mensaje) {

    return mensaje.replaceAll("\n", "<BR></BR>");
  }

  /**
   * Convierte una lista de correos en un Arregloe de {@link InternetAddress}
   * 
   * @param emailList
   * @return
   * @throws AddressException
   */
  private static InternetAddress[] convertAdresss(List<String> emailList) throws AddressException {

    InternetAddress[] adresses = new InternetAddress[emailList.size()];
    int i = 0;
    while (i < emailList.size()) {
      String address1 = emailList.get(i);
      InternetAddress recipienteTo = new InternetAddress(address1);
      adresses[i] = recipienteTo;
      i++;
    }
    return adresses;
  }

  /**
   * Procesa el template con los parámetros y retorna la cadena final.
   * 
   * @param template template a procesar.
   * @param parametros parámetros para el template.
   * @return string resultante.
   * @throws TemplateException error ocurrido al procesar el template.
   * @throws IOException error ocurrido al procesar el template.
   */
  private static String procesarTemplate(Template template, Map<String, Object> parametros) throws TemplateException, IOException {
    StringWriter out = new StringWriter();
    template.setEncoding(DEFAULT_ENCODING);
    template.process(parametros, out);
    out.flush();
    out.close();
    return out.toString();
  }


  /**
   * Envia un mesaje en un hilo
   * @param subject
   * @param mensaje
   * @param emailsTo
   * @param emailsCc
   * @param emailsBcc
   * @param attachments
   * @return
   * @throws UdeAEmailSenderException
   */
  public static void sendEmailEnHilo(String subject, String mensaje, List<String> emailsTo, List<String> emailsCc, List<String> emailsBcc, List<String> attachments){
    new UdeaEmailService().sendEmailEnHiloInstance(subject, mensaje, emailsTo, emailsCc, emailsBcc, attachments)  ;
  }
  
  
  /**
   * Envia un mensaje en un hilo
   * @param subject
   * @param mensaje
   * @param emailsTo
   * @param emailsCc
   * @param emailsBcc
   * @param attachments
   */
  private void sendEmailEnHiloInstance(String subject, String mensaje, List<String> emailsTo, List<String> emailsCc, List<String> emailsBcc, List<String> attachments) {
    new HiloCorreo(subject, mensaje, emailsTo, emailsCc, emailsBcc, attachments).start();;
  }

  /**
   * Hilo para le manejo de correos
   */
  public class HiloCorreo extends Thread{


    private String subject;
    private String mensaje;
    private List<String> emailsTo;
    private List<String> emailsCc;
    private List<String> emailsBcc;
    private List<String> attachments;

    /**
     * Constructor
     * @param subject
     * @param mensaje
     * @param emailsTo
     * @param emailsCc
     * @param emailsBcc
     * @param attachments
     * @throws UdeAEmailSenderException
     */
    public HiloCorreo(String subject, String mensaje, List<String> emailsTo, List<String> emailsCc, List<String> emailsBcc, List<String> attachments){
      this.subject = subject;
      this.mensaje=mensaje;
      this.emailsTo=emailsTo;
      this.emailsCc=emailsCc;
      this.emailsBcc=emailsBcc;
      this.attachments=attachments;
    }

    @Override
    public synchronized void start() {
      try {
        UdeaEmailService.sendEmail(subject, mensaje, emailsTo, emailsCc, emailsBcc, attachments);
      } catch (UdeAEmailSenderException e) {
        e.printStackTrace();
      }      
    }

  }

}
