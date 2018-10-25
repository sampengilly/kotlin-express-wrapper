package express

import kotlin.js.Json

@JsModule("express")
external class Express {
    fun get(route: String, callback: (req: Request, res: Response) -> Unit)
    fun listen(port: Int, callbacl: (Unit) -> Unit)
}

@JsName("Request")
open external class JsRequest {
    val baseUrl: String
    val body: Any

    @JsName("query")
    val queryJson: Json
}

class Request : JsRequest() {
    val query: Map<String, String>
        get() = emptyMap()
}

external class Response {
    fun send(data: String)
}