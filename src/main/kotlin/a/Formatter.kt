package a


class Formatter {

  /**
   * https://blog.podkalicki.com/bit-level-operations-bit-flags-and-bit-masks/
   */

  companion object {
    const val NONE = 1 shl 0
    const val UPPERCASE = 1 shl 1
    const val FULL_STOP = 1 shl 2
    const val REVERSE = 1 shl 3
  }

  var currentFlags = 0

  fun setFlags(flags: Int) {
    currentFlags = currentFlags or flags
  }

  fun removeFlags(flags: Int) {
    currentFlags = currentFlags and flags.inv()
  }

  fun hasFlags(flags: Int): Boolean {
    return (currentFlags and flags) == flags
  }

  fun toggleFlags(flags: Int) {
    currentFlags = currentFlags xor flags
  }

  fun resetFlags() {
    currentFlags = 0
  }

  fun format(toFormat: String): String {
    var result = toFormat

    if (hasFlags(UPPERCASE)) {
      result = result.toUpperCase()
    }

    if (hasFlags(FULL_STOP)) {
      result += "."
    }

    if (hasFlags(REVERSE)) {
      result = result.reversed()
    }

    return result
  }

}

fun main() {
  val formatter = Formatter()

  val includedFlags = Formatter.FULL_STOP or Formatter.UPPERCASE
  formatter.setFlags(includedFlags)

  val formatted = formatter.format("Hello")

  println(formatted)
}

fun Int.toBinary(): String {
  return Integer.toBinaryString(this)
}
