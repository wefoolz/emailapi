package com.email.model;

public class EmailRequest {

    private String from;
    private String apppassword;
    private String to;
    private String subject;
    private String message;


    public EmailRequest() {
    }

    public EmailRequest(String to, String subject, String message, String from, String apppassword) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.from=from;
        this.apppassword = apppassword;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getApppassword() {
        return apppassword;
    }
    public void setApppassword(String apppassword) {
        this.apppassword = apppassword;
    }
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
