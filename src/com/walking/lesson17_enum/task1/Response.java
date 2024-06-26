package com.walking.lesson17_enum.task1;

public enum Response {
    Hi("Hi","Hello"),
    Bye("Bye","Good bye"),
    How("How are you","How are your doing"),
    Unknown("","Unknown message");
    private String request;
    private String response;
    Response(String request, String response){
        this.request=request;
        this.response=response;
    }
    public static Response findResponse(String request){
        for (Response x:Response.values()){
            if (x.request.equals(request))
                return x;
        }
        return Unknown;
    }
    public String getResponse(){
        return response;
    }
}
