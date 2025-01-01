package com.utill;


public class SharedContext {
    private static SharedContext instance;

    private String username;
    private String password;
    
    private SharedContext() { }

    public static SharedContext getInstance() {
        if (instance == null) {
            instance = new SharedContext();
        }
        return instance;
    }
    
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
