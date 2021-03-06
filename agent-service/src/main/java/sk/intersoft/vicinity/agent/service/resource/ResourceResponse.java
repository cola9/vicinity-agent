package sk.intersoft.vicinity.agent.service.resource;

import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ResourceResponse {
    public static final String STATUS = "status";
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String REASON = "reason";
    public static final String DATA = "data";

    public static JSONObject success(Object result){
        JSONObject response = new JSONObject();
        response.put(STATUS, SUCCESS);
        response.put(DATA, result);
        return response;
    }


    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    public static JSONObject failure(Exception exception){
        JSONObject response = new JSONObject();
        response.put(STATUS, FAILURE);
        response.put(REASON, exception.getMessage());
        return response;
    }

    public static JSONObject failure(Object result){
        JSONObject response = new JSONObject();
        response.put(STATUS, FAILURE);
        response.put(REASON, result);
        return response;
    }
}
