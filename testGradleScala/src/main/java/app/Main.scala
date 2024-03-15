package app;

import io.circe.jawn.decode
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.scene.control.Label
import javafx.stage.Stage
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import pureconfig.{ConfigReader, ConfigSource}
import pureconfig.generic.auto.*

import java.net.URL


case class Chat(id: Integer, name: String)

class Main extends Application {

    override def start(primaryStage: Stage) :Unit = {
        val loader:FXMLLoader = new FXMLLoader();
        val xmlUrl:URL = getClass().getResource("/chatStage.fxml");
        loader.setLocation(xmlUrl);
        val root:Parent = loader.load();
       
        var req:RestTemplate = new RestTemplate();
        val response:String = req.getForObject(
                "http://localhost:8050/getChats",
                 classOf[String]
        );
        val chats = decode[java.util.ArrayList[Chat]](response).getOrElse(throw new Exception("not parsed"));
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        


    }
}



 