/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.CLIENT;

import INTERFACES.DocumentService;
import INTERFACES.NiveauService;
import INTERFACES.SemestreService;
import INTERFACES.TopicService;
import MODELS.Document;
import MODELS.Niveau;
import MODELS.Semestre;
import MODELS.Topic;
import SERVICES.DocumentServiceImp;
import SERVICES.NiveauServiceImp;
import SERVICES.SemestreServiceImp;
import SERVICES.TopicServiceImp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Dorra
 */
public class AjoutDocumentsController implements Initializable {

    @FXML
    private AnchorPane aanchorpane2_d;
    @FXML
    private AnchorPane aanchorpane3_d;
    @FXML
    private AnchorPane aanchorpane4_d;
    @FXML
    private ScrollPane ascrollpane_d;
    @FXML
    private GridPane agridpane_d;
    @FXML
    private AnchorPane aanchorpane5_d;
    @FXML
    private Button order_receiptBtn;
    @FXML
    private ComboBox<Niveau> aniveau_d;
    @FXML
    private ComboBox<Topic> atopic_d;
    @FXML
    private ComboBox<String> atype_d;
    @FXML
    private TextField anomdoc_d;
    @FXML
    private ComboBox<Semestre> asemestre_d;
    @FXML
    private Separator aseparator_d;
Alert alert;
    
    private NiveauService niveauService=new NiveauServiceImp();
    private SemestreService semestreService=new SemestreServiceImp();
    private TopicService topicService=new TopicServiceImp();
    private DocumentService documentService=new DocumentServiceImp();
    @FXML
    private ImageView adocImage_d;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    this.initializeCards();
      this.initCombobox();
      
    }    

   

    @FXML
    private void aajouter_d(ActionEvent event) {
     
       if (adocImage_d.getImage() == null ||   anomdoc_d.getText().isEmpty() || atype_d.getSelectionModel().isEmpty()||aniveau_d.getSelectionModel().isEmpty()||asemestre_d.getSelectionModel().isEmpty()|| atopic_d.getSelectionModel().isEmpty()) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Attention !");
    alert.setContentText("Veuillez remplir tous les champs.");
    alert.showAndWait();
    return;
}

   Document d= new Document();
      d.setDocumentCreationDate(new Date());
      d.setDocumentImage(adocImage_d.getImage().impl_getUrl());
      d.setDocumentType((String) atype_d.getSelectionModel().getSelectedItem());
      d.setIdNiveau((Niveau) aniveau_d.getSelectionModel().getSelectedItem()) ;
      d.setIdSemestre((Semestre) asemestre_d.getSelectionModel().getSelectedItem());
      d.setDocumentName((String)anomdoc_d.getText());
      d.setDocumentUrl("");
      d.setIdTopic((Topic) atopic_d.getSelectionModel().getSelectedItem());
     Document savedDoc=documentService.addDocument(d);
     
     if(savedDoc!=null){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Succès");
    alert.setHeaderText("Bienvenue");
    alert.setContentText("Le produit a été ajouté avec succès !");
    alert.showAndWait();
    this.onDestroy();
    this.initializeCards();
     }   
     
     
     
  
    }

    @FXML
    private void atélécharger_d(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Choisir une image");
// Définir les filtres pour n'afficher que les fichiers image
fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
);

// Ouvrir la boîte de dialogue de sélection de fichier
File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

if (imageFile != null) {
    // Load the selected image and set it to the ImageView
    Image image = new Image(imageFile.toURI().toString());
    adocImage_d.setImage(image);
}}
    
    
    
    private void initCombobox(){
          ObservableList<Semestre> semestres=FXCollections.observableArrayList( semestreService.getAllSemestres());
      ObservableList<Topic> topics=FXCollections.observableArrayList( topicService.getAllTopics());
      ObservableList<Niveau> niveaus= FXCollections.observableArrayList(niveauService.getAllNiveaus());
      ObservableList<String> types=  FXCollections.observableArrayList();
      types.add("TD");
       types.add("Devoirs");
      types.add("Corrige TD");
      types.add("Cours");

      aniveau_d.setConverter(new StringConverter<Niveau>() {
    @Override
    public String toString(Niveau niveau) {
        return niveau.getNiveauName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Niveau fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});
      atopic_d.setConverter(new StringConverter<Topic>() {
    @Override
    public String toString(Topic topic) {
        return topic.getTopicName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Topic fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});
      asemestre_d.setConverter(new StringConverter<Semestre>() {
    @Override
    public String toString(Semestre semestre) {
        return semestre.getSemestreName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Semestre fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});

      aniveau_d.setItems( niveaus);
      atopic_d.setItems(topics);
      asemestre_d.setItems(semestres);
      atype_d.setItems( types);
    }
    
    private void onDestroy(){
       anomdoc_d.setText("");
       atype_d.setValue("");
       aniveau_d.setValue(null);
       asemestre_d.setValue(null);
       atopic_d.setValue(null);
       adocImage_d.setImage(null);
       agridpane_d.getChildren().clear();

    }
    
     public void initializeCards() {
 // TODO
        try{
            List<Document>  document= documentService.getAllDocuments();
            int row = 0 ;
            int column = 1;
            for(int i = 0 ; i<document.size();i++){
               

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/CardDoc.fxml"));
                AnchorPane pane = loader.load();
                CardDocController controller = loader.getController();
                controller.setDocument(document.get(i));
                controller.getCard_moreInfo_D().setVisible(false);
                controller.getCard_updateinfo_D1().setVisible(true);
                agridpane_d.add(pane,column,row);
                column+=1;
                if(column>2){
                    column = 1;
                    row +=1 ;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(AffichageDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
        }    }    

    
     Document docToUpdate=new Document();
      public void setDocument(Document d){
      // docToUpdate=d;
      

    }

    @FXML
    private void amodif_d(ActionEvent event) {
        docToUpdate.setDocumentCreationDate(new Date());
      docToUpdate.setDocumentImage(adocImage_d.getImage().impl_getUrl());
      docToUpdate.setDocumentType((String) atype_d.getSelectionModel().getSelectedItem());
      docToUpdate.setIdNiveau((Niveau) aniveau_d.getSelectionModel().getSelectedItem()) ;
      docToUpdate.setIdSemestre((Semestre) asemestre_d.getSelectionModel().getSelectedItem());
      docToUpdate.setDocumentName((String)anomdoc_d.getText());
      docToUpdate.setDocumentUrl("");
      docToUpdate.setIdTopic((Topic) atopic_d.getSelectionModel().getSelectedItem());
        System.out.println(docToUpdate.toString());
        if (adocImage_d.getImage() == null ||   anomdoc_d.getText().isEmpty() || atype_d.getSelectionModel().getSelectedItem()==null||aniveau_d.getSelectionModel().getSelectedItem()==null||asemestre_d.getSelectionModel().getSelectedItem()==null|| atopic_d.getSelectionModel().getSelectedItem()==null) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Attention !");
    alert.setContentText("Veuillez remplir tous les champs.");
    alert.showAndWait();
    return;
}

      
      docToUpdate.setDocumentCreationDate(new Date());
      docToUpdate.setDocumentImage(adocImage_d.getImage().impl_getUrl());
      docToUpdate.setDocumentType((String) atype_d.getSelectionModel().getSelectedItem());
      docToUpdate.setIdNiveau((Niveau) aniveau_d.getSelectionModel().getSelectedItem()) ;
      docToUpdate.setIdSemestre((Semestre) asemestre_d.getSelectionModel().getSelectedItem());
      docToUpdate.setDocumentName((String)anomdoc_d.getText());
      docToUpdate.setDocumentUrl("");
      docToUpdate.setIdTopic((Topic) atopic_d.getSelectionModel().getSelectedItem());
     Document savedDoc=documentService.updateDocument(docToUpdate);
     
     if(savedDoc!=null){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Succès");
    alert.setHeaderText("Bienvenue");
    alert.setContentText("Le produit a été ajouté avec succès !");
    alert.showAndWait();
    this.onDestroy();
    this.initializeCards();
     }    
    }

    @FXML
    private void areloadmodif_d(ActionEvent event) {
         docToUpdate=CardDocController.getDoctomodif();
        System.err.println(docToUpdate.toString());
         anomdoc_d.setText(docToUpdate.getDocumentName());
       atype_d.setValue(docToUpdate.getDocumentType());
       aniveau_d.setValue(niveauService.getNiveauById(docToUpdate.getIdNiveau().getIdNiveau()));
       asemestre_d.setValue(semestreService.getSemestreById(docToUpdate.getIdSemestre().getIdSemestre()));
       atopic_d.setValue(topicService.getTopicById(docToUpdate.getIdTopic().getIdTopic()));
       Image image = new Image(docToUpdate.getDocumentImage());
       adocImage_d.setImage(image);
    }

    @FXML
    private void adeletePopUp_d(ActionEvent event) {
       
    if (docToUpdate == null) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please select the item first");
        alert.showAndWait();
    } else {
        int id = docToUpdate.getIdDoc();
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Service ID: " + id);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                documentService.DeleteDocument(id);
               // System.out.println("louay hna");
              this.onDestroy();
              this.initializeCards();
                // TO CLEAR ALL FIELDS

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
     
}