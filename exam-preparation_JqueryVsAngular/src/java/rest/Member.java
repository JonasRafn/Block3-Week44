package rest;

import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import model.DataFactory;

@Path("members")
public class Member {

    DataFactory df = new DataFactory();

    @Context
    private UriInfo context;

    public Member() {
    }

    @GET
    @Produces("application/json")
    public String getMembersAsJSON() {
        return df.getMembersAsJson();
    }
}
