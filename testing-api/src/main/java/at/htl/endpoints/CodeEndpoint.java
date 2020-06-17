package at.htl.endpoints;

import io.quarkus.launcher.shaded.org.slf4j.Logger;
import io.quarkus.launcher.shaded.org.slf4j.LoggerFactory;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/code")
public class CodeEndpoint {

    private final Logger log = LoggerFactory.getLogger(CodeEndpoint.class);

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) {

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        // depends on form eg. name="uploadedFile"
        List<InputPart> inputParts = uploadForm.get("uploadedFile");

        String fileName = FileGenerator.uploadFile("../src/main/java/at/htl/examples/", inputParts);
        log.info("Uploaded " + fileName);

        return Response.ok("Uploaded "+fileName).build();
    }
}
