package pojo.response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class SuccessResponseBody {

    private boolean success;
    private String message;
    private int error_code;
    private List<UserData> data;

    public SuccessResponseBody() {
    }

    public SuccessResponseBody(boolean success, String message, int error_code, List<UserData> UserData) {
        this.success = success;
        this.message = message;
        this.error_code = error_code;
        this.data = UserData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> UserData) {
        this.data = UserData;
    }

    @Override
    public boolean equals(Object o){

        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        SuccessResponseBody response = (SuccessResponseBody) o;
        return success == response.success &&
                message.equals(response.message) &&
                error_code == response.error_code &&
                data == response.data;
    }

}