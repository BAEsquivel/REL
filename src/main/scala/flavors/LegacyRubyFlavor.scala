package fr.splayce.rel.flavors

import fr.splayce.rel._
import util.{Flavor, Rewriter}


/** Legacy Ruby <= 1․8 flavor, which does not support Unicode (at all) nor LookBehind.
 *
 *  For a wider support, it is recommended to use PCRE regexes instead,
 *  with [[http://www.geocities.jp/kosako3/oniguruma/ Oniguruma]],
 *  which supports LookBehind and Unicode when the `/u` flag is specified.
 *  Ruby 1.9 uses Oniguruma by default, Ruby 1.8 can be recompiled to use it.
 *
 *  This flavor:
 *  - removes Unicode variants in `Τ` / `LineTerminator`
 *  - convert possessive quantifiers to greedy in atomic groups
 *  - throws an error when using unsupported features:
 *    - LookBehind
 *    - Unicode categories
 *
 *  @see [[fr.splayce.rel.flavors.PossessiveToAtomic]]
 *  @see [[http://www.regular-expressions.info/ruby.html Ruby 1.8 regex flavor]],
 *       [[http://www.regular-expressions.info/unicode8bit.html Mixing Unicode and 8-bit Character Codes]]
 *  @todo add endianness/charset variations that translate Unicode into multibytes
 */
object LegacyRubyFlavor
extends Flavor("Legacy Ruby")
with StripGroupNames
with PossessiveToAtomic
with NoUnicodeSupport
with NoLookBehindSupport
