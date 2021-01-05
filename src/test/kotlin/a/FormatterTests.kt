package a

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class FormatterTests {

  @Test
  fun test1() {
    val formatter = Formatter()
    val includedFlags = Formatter.FULL_STOP or Formatter.UPPERCASE
    val excludedFlag = Formatter.REVERSE
    val excludedFlag2 = Formatter.NONE
    formatter.setFlags(includedFlags)

    assertTrue { formatter.hasFlags(includedFlags) }
    assertFalse { formatter.hasFlags(excludedFlag) }
    assertFalse { formatter.hasFlags(excludedFlag2) }
  }

  @Test
  fun test2() {
    val formatter = Formatter()
    assertFalse { formatter.hasFlags(Formatter.UPPERCASE) }
    assertTrue { formatter.format("Hello") == "Hello" }
  }

  @Test
  fun test3() {
    val formatter = Formatter()

    val flagThatWillNotBeRemoved = Formatter.UPPERCASE
    val flagThatWillBeRemoved = Formatter.FULL_STOP

    formatter.setFlags(flagThatWillBeRemoved or flagThatWillNotBeRemoved)

    assertTrue { formatter.hasFlags(flagThatWillBeRemoved or flagThatWillNotBeRemoved) }

    formatter.removeFlags(flagThatWillBeRemoved)
    assertTrue { formatter.hasFlags(flagThatWillNotBeRemoved) }
    assertFalse { formatter.hasFlags(flagThatWillBeRemoved) }
  }

  @Test
  fun test4() {
    val formatter = Formatter()

    val includedFlags = Formatter.FULL_STOP or Formatter.UPPERCASE
    formatter.setFlags(includedFlags)

    val formatted = formatter.format("Hello")

    assertTrue { formatted == "HELLO." }
  }

}
