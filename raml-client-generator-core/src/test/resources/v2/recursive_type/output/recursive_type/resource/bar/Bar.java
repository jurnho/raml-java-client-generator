
package recursive_type.resource.bar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import recursive_type.exceptions.LocationsException;
import recursive_type.responses.LocationsResponse;

public class Bar {

    private String _baseUrl;
    private Client _client;

    public Bar() {
        _baseUrl = null;
        _client = null;
    }

    public Bar(String baseUrl, Client _client) {
        _baseUrl = (baseUrl +"/bar");
        this._client = _client;
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    /**
     * SomeDescriptionValue
     * 
     */
    public LocationsResponse<recursive_type.model.Foo> get() {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.method("GET");
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new LocationsException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase(), response.getStringHeaders(), response);
        }
        LocationsResponse<recursive_type.model.Foo> apiResponse = new LocationsResponse<recursive_type.model.Foo>(response.readEntity(recursive_type.model.Foo.class), response.getStringHeaders(), response);
        return apiResponse;
    }

}
