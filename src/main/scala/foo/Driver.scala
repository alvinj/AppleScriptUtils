package foo

import com.alvinalexander.applescript.AppleScriptUtils
import javax.script.ScriptEngineManager
import javax.script.ScriptException

object Driver extends App {

    //System.setProperty("apple.awt.UIElement", "true")
    //System.setProperty("java.awt.headless", "true") 

//    val command = """display notification "Hello, world" sound name "Purr" """
//    try {
//      val exitStatus = AppleScriptUtils.exec(command)
//      println(s"EXIT STATUS: $exitStatus")
//    } catch {
//      case e: ScriptException => println(e)
//    }
    
    val cmd = Seq(
        "tell app \"iTunes\"", 
        "activate",
        "set sound volume to 40", 
        "set EQ enabled to true",
        "play",
        "end tell")
    AppleScriptUtils.exec(cmd)
    
    
    // this works
//    val runtime = Runtime.getRuntime
//    val code = Array("osascript", "-e", "display notification \"Hello, world\" sound name \"default\" ")
//    val process = runtime.exec(code)    
    
    
    // -Dapple.awt.UIElement=true
    //System.setProperty("java.awt.headless", "true") 
}

