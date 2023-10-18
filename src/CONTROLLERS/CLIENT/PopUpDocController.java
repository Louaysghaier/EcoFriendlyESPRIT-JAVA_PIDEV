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
import MODELS.CurrentDocument;
import MODELS.Document;
import SERVICES.DocumentServiceImp;
import SERVICES.NiveauServiceImp;
import SERVICES.SemestreServiceImp;
import SERVICES.TopicServiceImp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dorra
 */
public class PopUpDocController implements Initializable {

    @FXML
    private AnchorPane anchorpanedownload_d;
    @FXML
    private Label nomdoc_d;
    @FXML
    private Label semestre_d;
    @FXML
    private Label level_d;
    @FXML
    private Label topic_d;
    @FXML
    private Label type_d;
    @FXML
    private ImageView imageviewuplo_d;
    private  static Document doctomodif=new Document();

    private NiveauService niveauService=new NiveauServiceImp();
    private SemestreService semestreService=new SemestreServiceImp();
    private TopicService topicService=new TopicServiceImp();
    private DocumentService documentService=new DocumentServiceImp();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(CurrentDocument.getDocument());
if(CurrentDocument.getDocument()!=null){
     doctomodif=CurrentDocument.getDocument();
                Document docToUpdate=doctomodif;

            nomdoc_d.setText(docToUpdate.getDocumentName());
       type_d.setText(docToUpdate.getDocumentType());
       level_d.setText(niveauService.getNiveauById(docToUpdate.getIdNiveau().getIdNiveau()).getNiveauName());
       semestre_d.setText(semestreService.getSemestreById(docToUpdate.getIdSemestre().getIdSemestre()).getSemestreName());
       topic_d.setText(topicService.getTopicById(docToUpdate.getIdTopic().getIdTopic()).getTopicName());
       Image image = new Image(docToUpdate.getDocumentImage());
       imageviewuplo_d.setImage(image);  
}
      }    

    @FXML
    private void retour_d(ActionEvent event) {
    }

    @FXML
    private void rloadAffichage_d(ActionEvent event) {
    }

    @FXML
    private void upload_d(ActionEvent event) {
                System.out.println(CurrentDocument.getDocument());

    }
    
    public void setDocument(Document d){
       
    }
}