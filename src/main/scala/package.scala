package com.alvinalexander

package object applescript {

  // most human
  val ALEX       = "ALEX"

  // good female voices
  val AGNES       = "AGNES"
  val KATHY       = "KATHY"
  val PRINCESS    = "PRINESS"
  val VICKI       = "VICKI"        // also good
  val VICTORIA    = "VICTORIA"

  // good male voices
  val BRUCE       = "BRUCE"
  val FRED        = "FRED"
  val JUNIOR      = "JUNIOR"
  val RALPH       = "RALPH"

  // other voices
  val ALBERT      = "ALBERT"
  val BAD_NEWS    = "BAD NEWS"
  val BAHH        = "BAHH"
  val BELLS       = "BELLS"
  val BOING       = "BOING"
  val BUBBLES     = "BUBBLES"
  val CELLOS      = "CELLOS"
  val DERANGED    = "DERANGED"
  val GOOD_NEWS   = "GOOD NEWS"
  val HYSTERICAL  = "HYSTERICAL"
  val PIPE_ORGAN  = "PIPE ORGAN"
  val TRINOIDS    = "TRINOIDS"
  val WHISPER     = "WHISPER"
  val ZARVOX      = "ZARVOX"
  
  val VOICES = Array(ALEX, AGNES, KATHY, PRINCESS, VICKI, VICTORIA, BRUCE, FRED, JUNIOR,
                     RALPH, ALBERT, BAD_NEWS, BAHH, BELLS, BOING, BUBBLES, CELLOS, DERANGED,
                     GOOD_NEWS, HYSTERICAL, PIPE_ORGAN, TRINOIDS, WHISPER, ZARVOX)
  
  def isValidVoice(desiredVoice: String): Boolean = {
    for (voice <- VOICES) {
      if (voice.equals(desiredVoice)) true
    }
    false
  }


}


