
package sub_resource_on_same_line.resource.projects.rename;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import sub_resource_on_same_line.exceptions.DesignCenterProjectsServicewithsubresourceonsamelineException;
import sub_resource_on_same_line.responses.DesignCenterProjectsServicewithsubresourceonsamelineResponse;

public class Rename {

    private String _baseUrl;
    private Client _client;

    public Rename() {
        _baseUrl = null;
        _client = null;
    }

    public Rename(String baseUrl, Client _client) {
        _baseUrl = (baseUrl +"/rename");
        this._client = _client;
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    /**
     * Rename a project
     * 
     */
    public DesignCenterProjectsServicewithsubresourceonsamelineResponse<Void> put(Object body) {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.method("PUT", Entity.json(body));
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new DesignCenterProjectsServicewithsubresourceonsamelineException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase(), response.getStringHeaders(), response);
        }
        DesignCenterProjectsServicewithsubresourceonsamelineResponse<Void> apiResponse = new DesignCenterProjectsServicewithsubresourceonsamelineResponse<Void>(null, response.getStringHeaders(), response);
        return apiResponse;
    }

}
