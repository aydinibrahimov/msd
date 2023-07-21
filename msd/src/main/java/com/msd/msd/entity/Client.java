package com.msd.msd.entity;


import jakarta.persistence.*;
import jakarta.security.auth.message.AuthException;
import jakarta.security.auth.message.MessageInfo;
import jakarta.security.auth.message.config.ClientAuthConfig;
import jakarta.security.auth.message.config.ClientAuthContext;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "client")
@Data
public class Client implements ClientAuthConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "client")
    @ToString.Exclude
    List<Invoice> invoices;


    @Override
    public ClientAuthContext getAuthContext(String s, Subject subject, Map<String, Object> map) throws AuthException {
        return null;
    }

    @Override
    public String getMessageLayer() {
        return null;
    }

    @Override
    public String getAppContext() {
        return null;
    }

    @Override
    public String getAuthContextID(MessageInfo messageInfo) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public boolean isProtected() {
        return false;
    }
}
