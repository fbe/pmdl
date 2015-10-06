package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer

/**
 * Created by becker on 10/6/15.
 */

trait RawParser[PARSETYPE] {
  def parse(bytes: ByteBuffer): PARSETYPE
}
