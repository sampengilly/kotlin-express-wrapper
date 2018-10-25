package express

import kotlinx.serialization.Mapper
import kotlinx.serialization.json.JSON
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
    val headers: Json

    @JsName("query")
    val queryJsonString: String
}

class Request : JsRequest() {
    val query: Map<String, Any>
        get() = JSON.parse(queryJsonString)
}

external class Response {
    fun send(data: String)
}