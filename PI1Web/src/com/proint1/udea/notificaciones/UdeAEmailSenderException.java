package com.proint1.udea.notificaciones;

/**
 * Excepción para el envio de correo del sistema
 * 
 * @author jcardona
 * @since 14/08/2014
 */
public class UdeAEmailSenderException extends Exception {

     /** serialVersionUID **/
     private static final long serialVersionUID = -5065358045964398865L;

     /**
      * 
      */
     public UdeAEmailSenderException() {
          super();
     }

     /**
      * @param message
      * @param cause
      * @param enableSuppression
      * @param writableStackTrace
      */
     public UdeAEmailSenderException(String message, Throwable cause,
               boolean enableSuppression, boolean writableStackTrace) {
          super(message, cause, enableSuppression, writableStackTrace);
     }

     /**
      * @param message
      * @param cause
      */
     public UdeAEmailSenderException(String message, Throwable cause) {
          super(message, cause);
     }

     /**
      * @param message
      */
     public UdeAEmailSenderException(String message) {
          super(message);
     }

     /**
      * @param cause
      */
     public UdeAEmailSenderException(Throwable cause) {
          super(cause);
     }

}
