package app


import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory
import pureconfig.*
import pureconfig.generic.auto.*




object Main {



  def main(args:Array[String]):Unit = {

    var rootBehavior = Behaviors.setup[Nothing]({context=>{
         context.setLoggerName("loggerChat")
         Behaviors.same
    }})
    ActorSystem[Nothing](rootBehavior,"ChatServer")
    val chatConfig = ConfigFactory.load("chat.conf");
    System.out.println(chatConfig.getInt("chat-config.port"));
    //Http().newServerAt()

  }
}
