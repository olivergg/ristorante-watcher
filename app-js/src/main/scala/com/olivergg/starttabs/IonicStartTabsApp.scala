package com.olivergg.starttabs

import scala.scalajs.js.JSConverters.array2JSRichGenTrav
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import com.greencatsoft.angularjs.Module
import com.olivergg.starttabs.controller.DashController
import com.olivergg.starttabs.controller.FriendsController
import com.olivergg.starttabs.controller.FriendDetailController
import com.olivergg.starttabs.controller.AccountController
import com.greencatsoft.angularjs.Angular
import com.olivergg.starttabs.service.BetterHttpServiceFactory
import com.olivergg.starttabs.controller.ChatsController
import com.olivergg.starttabs.controller.ChatDetailController

/**
 * The main entry point of the application. The main method is called thanks to the Scala.js autogenerated launcher.
 * See the "XXXXXX-launcher.js" file in Index.scala
 */
@JSExport("IonicStartTabsApp")
object IonicStartTabsApp extends JSApp {
  override def main(): Unit = {
    println("start main")

    // angular.module is a global place for creating, registering and retrieving Angular modules
    // 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
    // the 2nd parameter is an array of 'requires'
    // 'starter.controllers' is defined in controllers below
    val module = Angular.module("starter", Array("ionic", "starter.controllers", "ngCordova"))
    module.run(PlatformInitializer)
    module.config(StateConfig)
    module.factory(BetterHttpServiceFactory)

    val controllers = Angular.module("starter.controllers", Array.empty[String])
    controllers.controller(DashController)
    controllers.controller(FriendsController)
    controllers.controller(FriendDetailController)
    controllers.controller(AccountController)
    controllers.controller(ChatsController)
    controllers.controller(ChatDetailController)
    

    println("end main")

  }
}
