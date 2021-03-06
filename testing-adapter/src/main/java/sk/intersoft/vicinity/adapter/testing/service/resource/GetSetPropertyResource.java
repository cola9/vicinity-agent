package sk.intersoft.vicinity.adapter.testing.service.resource;

import org.json.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.io.File;
import java.util.Scanner;

public class GetSetPropertyResource extends ServerResource {

    @Get("json")
    public String getPropertyValue()  {
        try{

            System.out.println("getting property");

            String oid = getAttribute("oid");
            String pid = getAttribute("pid");

            JSONObject out = new JSONObject();
            out.put("echo", "get property");
            out.put("oid", oid);
            out.put("pid", pid);

            return out.toString();
        }
        catch(Exception e){
            return "{}";
        }
    }

    @Put()
    public String setPropertyValue(Representation entity)  {
        try{

            System.out.println("setting property");

            String oid = getAttribute("oid");
            String pid = getAttribute("pid");

            JSONObject input = new JSONObject(entity.getText());

            JSONObject out = new JSONObject();
            out.put("echo", "set property");
            out.put("oid", oid);
            out.put("pid", pid);
            out.put("payload", input);

            return out.toString();
        }
        catch(Exception e){
            return "{}";
        }
    }

}
