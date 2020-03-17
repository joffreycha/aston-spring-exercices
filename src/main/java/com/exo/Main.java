package com.exo;

// Attention aux import, nous sommes en log4j2
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// Import Spring
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public final class Main {
  private final static Logger LOG = LogManager.getLogger();

  public static void main(String[] args) {
    Main.LOG.debug("-- Debut -- ");
    // Declaration du contexte Spring
    ClassPathXmlApplicationContext appContext = null;
    try {
      // Chargement du fichier Spring
      appContext = new ClassPathXmlApplicationContext("classpath:spring/mesBeans.xml");
      // Récupération de notre instance de client
      Client cl1 = (Client) appContext.getBean("client");
      // Affichage
      Main.LOG.debug(cl1.toString());
    } catch (Exception e) {
      Main.LOG.fatal("Erreur", e);
      System.exit(-1);
    } finally {
      // Quoi qu'il arrive fermeture du contexte Spring
      if (appContext != null) {
        appContext.close();
      }
    }
    Main.LOG.debug("-- Fin -- ");
    System.exit(0);
  }
}