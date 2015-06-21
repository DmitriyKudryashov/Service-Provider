package com.system.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by home on 21.06.15.
 */

@Entity
@Table(name = "download_information")
public class DownloadInformation {

    private long id;
    private Date downloadStart;
    private Date downloadEnd;
    private long resultByte;

    public DownloadInformation(){}

    public DownloadInformation(Date downloadStart, Date downloadEnd, long resultByte) {
        this.downloadStart = downloadStart;
        this.downloadEnd = downloadEnd;
        this.resultByte = resultByte;
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

    @Column(name = "download_start")
    public Date getDownloadStart() {
        return downloadStart;
    }

    public void setDownloadStart(Date downloadStart) {
        this.downloadStart = downloadStart;
    }

    @Column(name = "download_end")
    public Date getDownloadEnd() {
        return downloadEnd;
    }

    public void setDownloadEnd(Date downloadEnd) {
        this.downloadEnd = downloadEnd;
    }

    @Column(name = "result_byte")
    public long getResultByte() {
        return resultByte;
    }

    public void setResultByte(long resultByte) {
        this.resultByte = resultByte;
    }

    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
