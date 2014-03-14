package com.alvinalexander.applescript

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

/**
 * Use the methods as static methods to "say" things using
 * AppleScript on a Mac.
 */
object AppleScriptUtils {

  /**
   * Use this method to execute a simple AppleScript command, i.e., a command
   * you can pass in as a simple string, like these:
   * 
   * """display notification "Hello, world" sound name "Purr" """
   * "tell app \"Firefox\" to launch"
   * "tell application \"Finder\" to activate"
   * "tell app \"iTunes\" to play"
   * "tell app \"iTunes\" to playpause"
   * "say \"Good morning Al.\" using \"Victoria\""
   * 
   * String applescriptCommand =  "tell app \"iTunes\"\n" + 
                               "activate\n" +
                               "set sound volume to 40\n" + 
                               "set EQ enabled to true\n" +
                               "play\n" +
                               "end tell";
   * 
   * Note: I get a long error when trying to use the Scala "!" approach. Error is:
   * 
   * Error loading /Library/ScriptingAdditions/Adobe Unit Types.osax/Contents/MacOS/Adobe Unit Types:
   * dlopen(/Library/ScriptingAdditions/Adobe Unit Types.osax/Contents/MacOS/Adobe Unit Types, 262): 
   * no suitable image found.  Did find:
   * /Library/ScriptingAdditions/Adobe Unit Types.osax/Contents/MacOS/Adobe Unit Types: 
   * no matching architecture in universal wrapper osascript: 
   * OpenScripting.framework - scripting addition "/Library/ScriptingAdditions/Adobe Unit Types.osax" 
   * declares no loadable handlers.
   */
  def exec(command: String) {
//      import sys.process._
//      val cmdSeq = Seq("osascript", "-e", command)
//      val exitStatus = cmdSeq.!
//      exitStatus
    val runtime = Runtime.getRuntime
    val code = Array("osascript", "-e", command)
    val process = runtime.exec(code)
    // can't do this; it tries to get the exit status before the command is finished running
    //process.exitValue
  }

  /**
   * Pass in a Seq[String], like this:
   * 
   *   val cmd = Seq(
   *      "tell app \"iTunes\"", 
   *      "activate",
   *      "set sound volume to 40", 
   *      "set EQ enabled to true",
   *      "play",
   *      "end tell")
   *   AppleScriptUtils.exec(cmd)
   * 
   * This method adds a "\n" to the end of each String in the Seq.
   * 
   */
  def exec(commandSeq: Seq[String]) {
    val command = commandSeq.mkString("\n")
    val runtime = Runtime.getRuntime
    val code = Array("osascript", "-e", command)
    val process = runtime.exec(code)
    // can't do this; it tries to get the exit status before the command is finished running
    //process.exitValue
  }

  /**
   * TODO implement this
   */
  def execInBackground(command: String) {}

  def speak(sentence: String) {
    val thingToSay = "say \"" + sentence + "\""
    try {
      getScriptEngine.eval(thingToSay)
    } catch {
      case e: ScriptException => // TODO
    }
  }

  def speak(sentence: String, voice: String)
  {
    val thingToSay = "say \"%s\" using \"%s\"".format(sentence, voice)
    try {
      getScriptEngine.eval(thingToSay)
    } catch {
      case e: ScriptException => // TODO
    }
  }

  def getScriptEngine: ScriptEngine = {
    val mgr = new ScriptEngineManager
    mgr.getEngineByName("AppleScript")
  }

}

