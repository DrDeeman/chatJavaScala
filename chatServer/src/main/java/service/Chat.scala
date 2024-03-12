package service

import akka.actor.typed.ActorRef
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors


import java.util

object Chat {

    sealed trait ChatCommand
    final case class ProcessMessage(sender: String, content:String) extends ChatCommand
    final case class AddNewUser(ref: ActorRef[String]) extends ChatCommand

    def apply():Behavior[ChatCommand] = Behaviors.setup(_ =>{
        var clients = new util.ArrayList[ActorRef[String]];
        var messageQueue = new java.util.ArrayList[String];
        Behaviors.receive((context, message)=>{
             message match {
                 case ProcessMessage(sender,content)=>{
                     messageQueue.add(content)
                     Behaviors.same
                 }
                 case AddNewUser(ref)=> {
                     clients.add(ref)
                     messageQueue.forEach(m=>ref ! m)
                     Behaviors.same
                 }
             }

        })
    })
}
