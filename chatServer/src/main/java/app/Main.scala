package app

import pureconfig.ConfigSource

case class ChatConfig(val host: String, val port: Integer);

object Main {
  def main(arg:Array[String]):Unit = {
   // val config = ConfigSource.default.at("chat-config").load[ChatConfig]
  }
}
