package login.example.loginReg.payload.response;

public class Loginmsg {
    String message;
    Boolean status;

    public Loginmsg(String message) {
        this.message = message;
    }

    public Loginmsg(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loginmsg{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
