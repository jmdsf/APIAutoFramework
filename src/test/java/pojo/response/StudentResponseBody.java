package pojo.response;

import java.util.List;

public class StudentResponseBody {

    private boolean success;
    private String message;
    private int error_code;
    private List<StudentData> data;

    public StudentResponseBody() {
    }

    public StudentResponseBody(boolean success, String message, int error_code, List<StudentData> StudentData) {
        this.success = success;
        this.message = message;
        this.error_code = error_code;
        this.data = StudentData;
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

    public List<StudentData> getData() {
        return data;
    }

    public void setData(List<StudentData> StudentData) {
        this.data = StudentData;
    }
}
