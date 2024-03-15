package controller

import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.server.Directives.{complete, path}
import net.liftweb.json.DefaultFormats
import net.liftweb.json._
import net.liftweb.json.Serialization.write

implicit val formats:DefaultFormats = DefaultFormats


case class Chat(id:Integer, name:String)

object Chat {

   def createRoutes():Route= {
     path("/chats") {
       Directives.get{
         val chats: List[Chat] = List.apply(Chat(1, "test1"), Chat(2, "test2"))
         complete(write(chats))
       }
     }
   }


}
