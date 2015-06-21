package com.system.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by home on 21.06.15.
 */

@Entity
@Table(name = "user")
public class User {

    private long id;
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Set<DownloadInformation> downloadInformationSet = new HashSet<DownloadInformation>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")

    public Set<DownloadInformation> getDownloadInformationSet(){
        return downloadInformationSet;
    }

    public void setDownloadInformationSet(Set<DownloadInformation> downloadInformationSet){
        this.downloadInformationSet = downloadInformationSet;
    }

    public void addDownloadInformation(DownloadInformation downloadInformation){
        downloadInformation.setUser(this);
        getDownloadInformationSet().add(downloadInformation);
    }

    public void removeDownloadInformation(DownloadInformation downloadInformation){
        getDownloadInformationSet().remove(downloadInformation);
    }

}
