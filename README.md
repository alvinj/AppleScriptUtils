AppleScriptUtils Project
========================

This is a collection of AppleScript utilities I've developed.

They mostly involve using the "say" command, though I have other
utlities I'll port over at some time that can run other types of
AppleScript commands as well.

`speak` Methods
---------------

The AppleScriptUtils object has `speak` methods that work like this:

    AppleScriptUtils.speak("Hello, Al")
    AppleScriptUtils.speak("Hello, world", VICKI)

    
`exec` Methods
--------------

I just added two `exec` methods that can be invoked like this:

    val command = """display notification "Hello, world" sound name "Purr" """
    AppleScriptUtils.exec(command) 

and this:

    val cmd = Seq(
        "tell app \"iTunes\"", 
        "activate",
        "set sound volume to 40", 
        "set EQ enabled to true",
        "play",
        "end tell")
    AppleScriptUtils.exec(cmd)




~ Alvin Alexander
http://alvinalexander.com

