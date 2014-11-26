package com.proint1.udea.notificaciones;

import java.io.File;
import java.io.Serializable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que encapsula el envio de un correo en formato HTMl, para incluir
 * adjuntos y contenido html
 */
public class EMailHtml implements Serializable {

  private static final Logger LOGGER = LoggerFactory.getLogger(EMailHtml.class);

  /** serialVersionUID */
  private static final long serialVersionUID = 3232851751545279316L;

  /** Adress to */
  private InternetAddress[] adressesTo;

  /** Adress CC */
  private InternetAddress[] adressesCc;

  /** Adress Bcc */
  private InternetAddress[] adressesBcc;

  /** Variables */
  private Properties props = new Properties();

  /** From del message */
  private String from;

  /** Çontenido del mensaje */
  private String content;

  /** Sujeto de mensaje */
  private String subject = "";

  /** MultiPart para crear mensajes compuestos */
  private MimeMultipart multipart = new MimeMultipart("related");

  /** usuario que logea el servidor de correo */
  private String emailUser;

  /** Passwordel del email user para autenticación del servidor de correo */
  private String passwordEmail;

  /**
   * Constructor
   * 
   * @param host nombre del servidor de correo
   * @param user usuario de correo
   * @param password password del usuario
   */
  public EMailHtml(String subject, String menssage) {
    try {
      props = new Properties();
      props.setProperty("mail.transport.protocol", "smtp");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.host", "smtp.gmail.com");
      emailUser = "thomassantos840@gmail.com";
      props.setProperty("mail.user", emailUser);
      passwordEmail = "facebook2014";
      props.setProperty("mail.password", passwordEmail);
      props.setProperty("mail.smtp.port", "587");
      props.setProperty("mail.smtp.auth", "true");
      this.subject = subject;
      this.from = "thomassantos840@gmail.com";
      this.content = menssage;
    } catch (Exception e) {
      LOGGER.error("PropiedadNoEncontradaException ", e);
    }
  }

  /**
   * Añade el contenido base al multipart
   * 
   * @throws MessagingException
   * 
   * @throws Exception Excepcion levantada en caso de error
   */
  public void addContentToMultipart() throws MessagingException {
    // first part (the html)
    BodyPart messageBodyPart = new MimeBodyPart();
    String htmlText = this.getContent();
    messageBodyPart.setContent(htmlText, "text/html");
    // add it
    this.multipart.addBodyPart(messageBodyPart);
  }

  /**
   * Añade el contenido base al multipart
   * 
   * @param htmlText contenido html que se muestra en el mensaje de correo
   * @throws MessagingException
   * @throws Exception Excepcion levantada en caso de error
   */
  public void addContent(String htmlText) throws MessagingException {
    // first part (the html)
    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(htmlText, "text/html");
    // add it
    this.multipart.addBodyPart(messageBodyPart);
  }

  /**
   * Añade al mensaje un cid:name utilizado para guardar las imagenes referenciadas en el HTML de la forma
   * <img src=cid:name />
   * 
   * @param cidname identificador que se le da a la imagen. suele ser un string generado aleatoriamente.
   * @param pathname ruta del fichero que almacena la imagen
   * @throws MessagingException
   * @throws Exception excepcion levantada en caso de error
   */
  public void addCID(String cidname, String pathname) throws MessagingException {
    DataSource fds = new FileDataSource(pathname);
    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setDataHandler(new DataHandler(fds));
    messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
    this.multipart.addBodyPart(messageBodyPart);
  }

  /**
   * Añade un attachement al mensaje de email
   * 
   * @param pathname ruta del fichero
   * @throws MessagingException
   * @throws Exception excepcion levantada en caso de error
   */
  public void addAttach(String pathname) throws MessagingException {
    File file = new File(pathname);
    BodyPart messageBodyPart = new MimeBodyPart();
    DataSource ds = new FileDataSource(file);
    messageBodyPart.setDataHandler(new DataHandler(ds));
    messageBodyPart.setFileName(file.getName());
    messageBodyPart.setDisposition(Part.ATTACHMENT);
    this.multipart.addBodyPart(messageBodyPart);
  }

  /**
   * Operación final de envio sea con documentos o sin ellos
   * 
   * @throws MessagingException
   * 
   * @throws Exception
   */
  public void sendMessage() throws MessagingException {
    sendMultipart();
  }

  /**
   * Envia un correo multipart
   * 
   * @throws MessagingException
   * @throws Exception Excepcion levantada en caso de error
   */
  private void sendMultipart() throws MessagingException {
    Session mailSession = Session.getDefaultInstance(this.props, null);
    mailSession.setDebug(true);
    Transport transport = mailSession.getTransport();
    MimeMessage message = new MimeMessage(mailSession);

    // Agregar sujeto
    message.setSubject(this.getSubject());
    // Agregrar el from
    message.setFrom(new InternetAddress(this.getFrom()));

    // Agregar destinatiarios
    if (adressesTo != null && adressesTo.length > 0) {
      message.addRecipients(Message.RecipientType.TO, adressesTo);
    }
    if (adressesCc != null && adressesCc.length > 0) {
      message.addRecipients(Message.RecipientType.CC, adressesCc);
    }
    if (adressesBcc != null && adressesBcc.length > 0) {
      message.addRecipients(Message.RecipientType.BCC, adressesBcc);
    }

    // put everything together
    message.setContent(multipart);
    transport.connect(emailUser, passwordEmail);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * @return the adressesTo
   */
  public InternetAddress[] getAdressesTo() {
    return adressesTo;
  }

  /**
   * @param adressesTo the adressesTo to set
   */
  public void setAdressesTo(InternetAddress[] adressesTo) {
    this.adressesTo = adressesTo;
  }

  /**
   * @return the adressesCc
   */
  public InternetAddress[] getAdressesCc() {
    return adressesCc;
  }

  /**
   * @param adressesCc the adressesCc to set
   */
  public void setAdressesCc(InternetAddress[] adressesCc) {
    this.adressesCc = adressesCc;
  }

  /**
   * @return the adressesBcc
   */
  public InternetAddress[] getAdressesBcc() {
    return adressesBcc;
  }

  /**
   * @param adressesBcc the adressesBcc to set
   */
  public void setAdressesBcc(InternetAddress[] adressesBcc) {
    this.adressesBcc = adressesBcc;
  }
}
