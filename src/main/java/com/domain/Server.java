package com.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String serverName;
    private String serverAddress;
    //private String version;

    public Server(String serverName, String serverAddress) {
        this.serverName = serverName;
        this.serverAddress = serverAddress;
    }

    public Server() {
    }


    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerAdress() {
        return serverAddress;
    }

    public void setServerAdress(String serverAdress) {
        this.serverAddress = serverAdress;
    }

   /* public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }*/



    /*URL obj;

    {
        try {
            obj = new URL(serverAddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    HttpURLConnection connection;
    {
        try {
            connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String vers = response.toString()
                    .substring(response.toString()
                                    .indexOf("<version>")+9,
                    response.toString()
                            .indexOf("/version"));
            setVersion(vers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



}