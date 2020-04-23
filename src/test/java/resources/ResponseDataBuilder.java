package resources;

import pojo.response.SuccessResponseBody;

public class ResponseDataBuilder {

    public static SuccessResponseBody SuccessResponse(){
        SuccessResponseBody successResponse = new SuccessResponseBody();
        successResponse.setData(null);
        successResponse.setMessage("Success");
        successResponse.setError_code(200);
        successResponse.setSuccess(true);
        return successResponse;
    }
}
