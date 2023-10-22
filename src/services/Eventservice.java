/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;
import models.Participation;
import models.User;
import util.Myconnection;


/**
 *
 * @author Mekni
 */
public class Eventservice {
    
    Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    
    //Add 1
  
    
    //Add 2
 public void ajouterEvent(Event event, User user) {
    String req = "INSERT INTO `event` (`nomEvent`, `dateDebutEvent`, `Durée`, `LieuEvent`, `PrixTicket`, `nbmaxParticipant`, `typeEvent`, `descriptionEvent`, `image`,`iduser`) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, event.getNomEvent());
        ps.setDate(2, new java.sql.Date(event.getDateDebutEvent().getTime()));
        ps.setString(3, event.getDurée());
        ps.setString(4, event.getLieuEvent());
        ps.setDouble(5, event.getPrixTicket());
        ps.setInt(6, event.getNbmaxParticipant());
        ps.setString(7, event.getTypeEvent());
        ps.setString(8, event.getDescriptionEvent());
        ps.setString(9, event.getImage());
       ps.setInt(10, event.getUser().getIduser()); 

        ps.executeUpdate();
        System.out.println("Event ajouté avec succès !");

        // Associez l'utilisateur à l'événement en définissant l'utilisateur pour cet événement
       
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}

 
 
 
 
 
 
 
public void ajouterEvent1(Event event) {
    String req = "INSERT INTO `event` (`nomEvent`, `dateDebutEvent`, `Durée`, `LieuEvent`, `PrixTicket`, `nbmaxParticipant`, `typeEvent`, `descriptionEvent`, `image`, `iduser`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, event.getNomEvent());
        ps.setDate(2, new java.sql.Date(event.getDateDebutEvent().getTime()));
        ps.setString(3, event.getDurée());
        ps.setString(4, event.getLieuEvent());
        ps.setDouble(5, event.getPrixTicket());
        ps.setInt(6, event.getNbmaxParticipant());
        ps.setString(7, event.getTypeEvent());
        ps.setString(8, event.getDescriptionEvent());
        ps.setString(9, event.getImage());
        ps.setInt(10, event.getUser().getIduser()); // Utilisez getId() pour obtenir l'ID de l'utilisateur

        ps.executeUpdate();
        System.out.println("Event ajouté avec succès !");
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}

 
 
 
 
 
 
 
 
 
 
 


    //           Event event = new Event(); 
//            event.setIdEvent((rs.getInt(1)));
//            event.setLieuEvent(rs.getString("LieuEvent"));
//            event.setDateDebutEvent(rs.getDate("dateDebutEvent"));
//            event.setDateFinEvent(rs.getDate("dateFinEvent"));
//            event.setNbmaxParticipant(rs.getString("nbmaxParticipant"));
//            event.setPrixTicket(rs.getString("PrixTicket"));
//            event.setNomEvent(rs.getString("nomEvent"));
//            event.setTypeEvent(rs.getString("typeEvent"));
//            event.setDescriptionEvent(rs.getString("descriptionEvent"));
    
  
  public void ajouterEvent2(Event event) {
    String req = "INSERT INTO `event` (`nomEvent`, `dateDebutEvent`, `Durée`, `LieuEvent`, `PrixTicket`, `nbmaxParticipant`, `typeEvent`, `descriptionEvent`, `image`, `iduser`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, event.getNomEvent());
        ps.setDate(2, new java.sql.Date(event.getDateDebutEvent().getTime()));
        ps.setString(3, event.getDurée());
        ps.setString(4, event.getLieuEvent());
        ps.setDouble(5, event.getPrixTicket());
        ps.setInt(6, event.getNbmaxParticipant());
        ps.setString(7, event.getTypeEvent());
        ps.setString(8, event.getDescriptionEvent());
        ps.setString(9, event.getImage());
        ps.setInt(10, event.getUser().getIduser()); // Utilisez getId() pour obtenir l'ID de l'utilisateur

        ps.executeUpdate();
        System.out.println("Event ajouté avec succès !");
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}

  ///// les evenements d un user:::
  public List<Event> afficherEventsByUser(int userId) {
    List<Event> evenements = new ArrayList<>();
    String req = "SELECT * FROM event WHERE iduser = ?"; // Remplacez iduser par le nom réel de la colonne dans votre table

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Event event = new Event(
                rs.getInt("idEvent"),
                rs.getString("nomEvent"),
                rs.getDate("dateDebutEvent"),
                rs.getString("Durée"),
                rs.getString("LieuEvent"),
                rs.getDouble("PrixTicket"),
                rs.getInt("nbmaxParticipant"),
                rs.getString("typeEvent"),
                rs.getString("descriptionEvent"),
                rs.getString("image")
            );

            evenements.add(event);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return evenements;
}
//////////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  
  public List<Event> afficherEventsByUser1(int userId) {
    List<Event> evenements = new ArrayList<>();
    String req = "SELECT * FROM event WHERE iduser = ?"; // Remplacez iduser par le nom réel de la colonne dans votre table

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Event event = new Event(
                rs.getString("nomEvent"),
                rs.getDate("dateDebutEvent"),
                rs.getString("Durée"),
                rs.getString("LieuEvent"),
                rs.getDouble("PrixTicket"),
                rs.getInt("nbmaxParticipant"),
                rs.getString("typeEvent"),
                rs.getString("descriptionEvent"),
                rs.getString("image")
            );

            evenements.add(event);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return evenements;
}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  //avec username 

  
  
  
  
  
  
  
  
  
  
  
  

      
public void deleteEvent(int idEvent) {
    String selectQuery = "SELECT * FROM event WHERE idEvent = ?";
    String deleteQuery = "DELETE FROM event WHERE idEvent = ?";
    
    try {
        // Vérifie si l'événement existe
        PreparedStatement selectStatement = cnx.prepareStatement(selectQuery);
        selectStatement.setInt(1, idEvent);
        ResultSet resultSet = selectStatement.executeQuery();
        
        if (!resultSet.next()) {
            System.out.println("Event with ID " + idEvent + " does not exist.");
            return;
        }

        // Supprime l'événement
        PreparedStatement deleteStatement = cnx.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, idEvent);
        int result = deleteStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Event with ID " + idEvent + " has been deleted successfully!");
        } else {
            System.out.println("Failed to delete event with ID " + idEvent);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}
////////////////////////////////////////
       public void updateEvent(Event updatedEvent) {
    String req = "UPDATE event SET LieuEvent=?, dateDebutEvent=?, Durée=?, nbmaxParticipant=?, PrixTicket=?, nomEvent=?, typeEvent=?, descriptionEvent=?, image=? WHERE idEvent=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setString(1, updatedEvent.getLieuEvent());
        ps.setDate(2, updatedEvent.getDateDebutEvent());
        ps.setString(3, updatedEvent.getDurée());
        ps.setInt(4, updatedEvent.getNbmaxParticipant());
        ps.setDouble(5, updatedEvent.getPrixTicket());
        ps.setString(6, updatedEvent.getNomEvent());
        ps.setString(7, updatedEvent.getTypeEvent());
        ps.setString(8, updatedEvent.getDescriptionEvent());
        ps.setString(9, updatedEvent.getImage());
        ps.setInt(10, updatedEvent.getIdEvent()); // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        
        int res = ps.executeUpdate();

        if (res == 0) {
            System.out.println("L'événement avec l'ID " + updatedEvent.getIdEvent() + " n'existe pas.");
        } else {
            System.out.println("L'événement avec l'ID " + updatedEvent.getIdEvent() + " a été mis à jour avec succès !");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}
///////////////////////////////////////////////////////////////////////////
       
       
       
       
       
       
       public void updateEvent(Event updatedEvent, int userId) {
    String req = "UPDATE event SET LieuEvent=?, dateDebutEvent=?, Durée=?, nbmaxParticipant=?, PrixTicket=?, nomEvent=?, typeEvent=?, descriptionEvent=?, image=? WHERE idEvent=? AND idUser=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setString(1, updatedEvent.getLieuEvent());
        ps.setDate(2, updatedEvent.getDateDebutEvent());
        ps.setString(3, updatedEvent.getDurée());
        ps.setInt(4, updatedEvent.getNbmaxParticipant());
        ps.setDouble(5, updatedEvent.getPrixTicket());
        ps.setString(6, updatedEvent.getNomEvent());
        ps.setString(7, updatedEvent.getTypeEvent());
        ps.setString(8, updatedEvent.getDescriptionEvent());
        ps.setString(9, updatedEvent.getImage());
        ps.setInt(10, updatedEvent.getIdEvent()); 
        ps.setInt(11, userId); // Ajoutez l'ID de l'utilisateur pour vérifier s'il a le droit de mettre à jour

        int res = ps.executeUpdate();

        if (res == 0) {
            System.out.println("L'événement avec l'ID " + updatedEvent.getIdEvent() + " n'existe pas ou vous n'avez pas le droit de le mettre à jour.");
        } else {
            System.out.println("L'événement avec l'ID " + updatedEvent.getIdEvent() + " a été mis à jour avec succès !");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       

// public Event getEventById(int idEvent) {
//        String req = "SELECT * FROM event WHERE idEvent = ?";
//        Event event = null;
//
//        try {
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(1, idEvent);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                // Récupérez les données de l'événement depuis le résultat de la requête
//                String nomEvent = rs.getString("nomEvent");
//                Date dateDebutEvent = rs.getDate("dateDebutEvent");
//                Integer Durée = rs.getInt("Durée");
//                String LieuEvent = rs.getString("LieuEvent");
//                Double PrixTicket = rs.getDouble("PrixTicket");
//                Integer nbmaxParticipant = rs.getInt("nbmaxParticipant");
//                String typeEvent = rs.getString("typeEvent");
//                String descriptionEvent = rs.getString("descriptionEvent");
//                // Récupérez le chemin de l'image
//                String image = rs.getString("image");
//
//                // Créez une instance de la classe Event
//                event = new Event(idEvent, nomEvent, dateDebutEvent, Durée, LieuEvent, PrixTicket, nbmaxParticipant, typeEvent, descriptionEvent, image);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return event;
//    }



          
          
          
public List<List<String>> getEventNamesByUser(int iduser) {
    List<List<String>> eventInfoList = new ArrayList<>();
    String query = "SELECT u.username, e.nomEvent, COUNT(e.idEvent) AS eventCount " +
            "FROM user u " +
            "LEFT JOIN event e ON u.iduser = e.iduser " +
            "WHERE u.iduser = ? " +
            "GROUP BY u.username, e.nomEvent";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, iduser);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String eventName = resultSet.getString("nomEvent");
                int eventCount = resultSet.getInt("eventCount");

                List<String> eventInfo = new ArrayList<>();
                eventInfo.add(username);
                eventInfo.add(eventName);
                eventInfo.add(String.valueOf(eventCount));

                eventInfoList.add(eventInfo);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return eventInfoList;
}

       public List<String> getEventNamesByUser(String username) {
    List<String> eventNames = new ArrayList<>();
    String query = "SELECT e.nomEvent " +
            "FROM user u " +
            "LEFT JOIN event e ON u.iduser = e.iduser " +
            "WHERE u.username = ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setString(1, username);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String eventName = resultSet.getString("nomEvent");
                eventNames.add(eventName);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return eventNames;
}

       
       
//       public List<List<String>> getEventNamesByUser(int iduser) {
//    List<List<String>> eventInfoList = new ArrayList<>();
//    String query = "SELECT u.username, e.nomEvent " +
//            "FROM user u " +
//            "LEFT JOIN event e ON u.iduser = e.iduser " +
//            "WHERE u.iduser = ?";
//
//    try (
//         PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
//        preparedStatement.setInt(1, iduser);
//
//        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//            while (resultSet.next()) {
//                String username = resultSet.getString("username");
//                String eventName = resultSet.getString("nomEvent");
//
//                List<String> eventInfo = new ArrayList<>();
//                eventInfo.add(username);
//                eventInfo.add(eventName);
//
//                eventInfoList.add(eventInfo);
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//    return eventInfoList;
//}

       
       
       
       
       
       
     
      
      
       public Event getEventById(int idEvent) {
        String req = "SELECT * FROM event WHERE idEvent = ?";
     Event event = new Event() ;

        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idEvent);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Récupérez les données de l'événement depuis le résultat de la requête
                String nomEvent = rs.getString("nomEvent");
                Date dateDebutEvent = rs.getDate("dateDebutEvent");
                String Durée = rs.getString("Durée");
                String LieuEvent = rs.getString("LieuEvent");
                Double PrixTicket = rs.getDouble("PrixTicket");
                Integer nbmaxParticipant = rs.getInt("nbmaxParticipant");
                String typeEvent = rs.getString("typeEvent");
                String descriptionEvent = rs.getString("descriptionEvent");
                // Récupérez le chemin de l'image
                String image = rs.getString("image");
               // int iduser = rs.getInt("iduser"); 
                // Créez une instance de la classe Event
                event = new Event(idEvent, nomEvent, dateDebutEvent, Durée, LieuEvent, PrixTicket, nbmaxParticipant, typeEvent, descriptionEvent, image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        return event;
    }


      
      
      
      
      
      public double getPrixTicketById(int eventId) {
    String query = "SELECT prixTicket FROM event WHERE idEvent = ?";

    try (PreparedStatement statement = cnx.prepareStatement(query)) {
        statement.setInt(1, eventId);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            return result.getDouble("prixTicket");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions SQL ici
    }

    // Retournez une valeur par défaut en cas d'erreur
    return 0.0; // Ou une autre valeur appropriée
}

      
      
      
public String getEventNameById(int eventId) {
    String query = "SELECT nomEvent FROM event WHERE idEvent = ?";
    String eventName = "";

    try (PreparedStatement statement = cnx.prepareStatement(query)) {
        statement.setInt(1, eventId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            eventName = rs.getString("nomEvent");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions SQL ici
    }

    return eventName;
}











public List<Event> getEventsByUser(int iduser) {
    List<Event> events = new ArrayList<>();
    String query = "SELECT e.idEvent, e.nomEvent, e.dateDebutEvent, e.Durée, e.LieuEvent, e.PrixTicket, e.nbmaxParticipant, e.typeEvent, e.descriptionEvent " +
            "FROM event e " +
            "WHERE e.iduser = ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, iduser);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = new Event();
                // Vous pouvez ignorer l'ID de l'événement si vous ne souhaitez pas l'afficher
                // event.setIdEvent(resultSet.getInt("idEvent"));
                event.setNomEvent(resultSet.getString("nomEvent"));
                event.setDateDebutEvent(resultSet.getDate("dateDebutEvent"));
                event.setDurée(resultSet.getString("Durée"));
                event.setLieuEvent(resultSet.getString("LieuEvent"));
                event.setPrixTicket(resultSet.getDouble("PrixTicket"));
                event.setNbmaxParticipant(resultSet.getInt("nbmaxParticipant"));
                event.setTypeEvent(resultSet.getString("typeEvent"));
                event.setDescriptionEvent(resultSet.getString("descriptionEvent"));
                events.add(event);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return events;
}















public List<Event> getEventsByUser1(int iduser) {
    List<Event> events = new ArrayList<>();
    String query = "SELECT e.nomEvent " +
            "FROM event e " +
            "WHERE e.iduser = ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, iduser);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Event event = new Event();
                event.setNomEvent(resultSet.getString("nomEvent"));
                events.add(event);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return events;
}















public List<String> getEventNamesByUser1(int iduser) {
    List<String> eventNames = new ArrayList<>();
    String query = "SELECT e.nomEvent " +
            "FROM event e " +
            "WHERE e.iduser = ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setInt(1, iduser);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String eventName = resultSet.getString("nomEvent");
                eventNames.add(eventName);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return eventNames;
}


public int getUserIdByEventId(int eventId) {
    String query = "SELECT iduser FROM event WHERE idEvent = ?";
    int userId = -1; // Utilisez une valeur par défaut appropriée en cas d'erreur

    try (PreparedStatement statement = cnx.prepareStatement(query)) {
        statement.setInt(1, eventId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            userId = rs.getInt("iduser");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions SQL ici
    }

    return userId;
}


}

          
          
          
          
          
          
          
          
          
          
          
          
          
    


        