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
import java.net.ProtocolException;
import java.net.URL;

@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String serverName;
    private String serverAddress;
    private String version;

    public Server(String serverName, String serverAddress) {
        this.serverName = serverName;
        this.serverAddress = serverAddress;
        try {
            version = this.getVersion();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }
 //Open connection and try to get version from server address

    public String getVersion() throws IOException {
        URL obj;
        String vers = null;

        obj = new URL(serverAddress+"//get_server_info.jsp");
        HttpURLConnection connection;

        connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        vers = response.toString()
                                .substring(response.toString()
                                                .indexOf("<version>")+9,
                                        response.toString()
                                                .indexOf("/version"));
        return vers;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}