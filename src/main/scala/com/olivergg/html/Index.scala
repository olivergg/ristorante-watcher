package com.olivergg.html

import com.olivergg.ionic.IonicHtmlTags._
import scalatags.Text.all._
import scalatags.Text.tags2.{ title => htitle }

class Index {
  def output(optMode: String, moduleName:String): String = {
    //TODO : the javascript file base name should be computed from the sbt name project.
    val jsFileBaseName = s"js/$moduleName"
    val optModeSuffix = optMode match {
      case "fastOpt" => "fastopt.js"
      case "fullOpt" => "opt.js"
    }
    html(
      head(
        meta(charset := "utf-8"),
        meta(name := "viewport", content := "initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width"),
        htitle("some title"),
        link(href := "lib/ionic/css/ionic.min.css", rel := "stylesheet"),
        link(href := "css/style.css", rel := "stylesheet"),
        // ionic/angularjs is included in the bundled jsdeps created by scala-js. 
        //See the webjar dependencies in the build.sbt to add more javascript dependencies
        script(src := s"js/$moduleName-jsdeps.js")(" "),
        // cordova script (this will be a 404 during development)
        script(src := "cordova.js")(" "),
        // your app's js
        script(src := s"js/$moduleName-$optModeSuffix")(" "),
        script(src := s"js/$moduleName-launcher.js")(" ")

      ),
      body(ngApp := "starter", animation := "slide-left-right-ios7")(
        ionNavBar(cls := "bar-stable bar-positive nav-title-slide-ios7")(
          ionNavBackButton(cls := "button-icon icon  ion-ios7-arrow-back")("Back")
        ),
        /**
         * The views will be rendered in the <ion-nav-view> directive below
         * Templates are in the /templates folder (but you could also
         * have templates inline in this html file if you'd like).
         */
        ionNavView()
      )
    ).toString()
  }
}