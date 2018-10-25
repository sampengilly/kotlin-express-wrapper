import express.Express

fun main(args: Array<String>) {
    val express = Express()

    express.get("/echo") { req, res ->
        res.send("Echo")
    }

    express.listen(3000) { console.log("listening on port 3000") }
}