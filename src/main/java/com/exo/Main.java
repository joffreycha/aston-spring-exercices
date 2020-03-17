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
      // Récupération des instances de client
      Client cl1 = (Client) appContext.getBean("client1");
      Client cl2 = (Client) appContext.getBean("client2");
      
      // Récupération des instances d'adresse
      Adresse ad1 = (Adresse) appContext.getBean("adresse1");
      Adresse ad2 = (Adresse) appContext.getBean("adresse2");
      Adresse ad3 = (Adresse) appContext.getBean("adresse3");
      
      // Affichage
      Main.LOG.debug(cl1.toString());
      Main.LOG.debug(cl2.toString());
      Main.LOG.debug(ad1.toString());
      Main.LOG.debug(ad2.toString());
      Main.LOG.debug(ad3.toString());
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