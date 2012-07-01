package com.alvinalexander.applescript

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

/**
 * Use the methods as static methods to "say" things using
 * AppleScript on a Mac.
 */
object AppleScriptUtils {

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
    val thingToSay = "say %s using %s".format(sentence, voice)
    try {
      getScriptEngine.eval(thingToSay)
    } catch {
      case e: ScriptException => // TODO
    }
  }

  def getScriptEngine: ScriptEngine = {
    val mgr = new ScriptEngineManager
    return mgr.getEngineByName("AppleScript")
  }

}

