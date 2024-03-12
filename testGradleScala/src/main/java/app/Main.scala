package app;

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.scene.control.Label
import javafx.stage.Stage
import pureconfig.{ConfigReader, ConfigSource}
import pureconfig.generic.auto._

import java.net.URL



class Main extends Application {

    override def start(primaryStage: Stage) :Unit = {
        val loader:FXMLLoader = new FXMLLoader();
        val xmlUrl:URL = getClass().getResource("/chatStage.fxml");
        loader.setLocation(xmlUrl);
        val root:Parent = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        


    }
}



 