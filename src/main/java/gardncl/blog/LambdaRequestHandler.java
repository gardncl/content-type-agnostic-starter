package gardncl.blog;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.JsonObject;
import gardncl.blog.services.PercentEncodingParseService;

import java.util.Map;

public class LambdaRequestHandler implements RequestHandler<Map<String,Object>, String> {

    public String handleRequest(Map<String, Object> stringObjectMap, Context context) {

        //RETRIEVE CONTENT FROM THE JSON OBJECT THAT ORIGINAL CONTENT IS MAPPED TO INSIDE OF API GATEWAY
        String rawInput = stringObjectMap.get("payload").toString();

        //USE CUSTOM PARSE SERVICE TO TURN THAT DATA INTO A JSON OBJECT
        JsonObject parsedObject = PercentEncodingParseService.percentEncodingToJson(rawInput);

        //RETURN NEWLY CREATE JSON OBJECT
        return parsedObject.toString();
    }
}
