import java.net._
import java.io._
import scala.io._
import com.mongodb.casbah.Imports._
object HTTPServer {

	def main(args : Array[String]) = {}
		val server = new ServerSocket(9998)
		val mongoClient = MongoClient("localhost",27017)
		val db = mongoClient("test")
		println(db.collectionNames)
		println("done")
		while(true) {

			val s = server.accept()
			val in = new BufferedSource(s.getInputStream)
			val out = new PrintStream(s.getOutputStream)

			val msg = in.next()
			println("Received : " + msg)

			out.println("HI! MSg : " + msg)
			out.flush()
			s.close()
	}
}
