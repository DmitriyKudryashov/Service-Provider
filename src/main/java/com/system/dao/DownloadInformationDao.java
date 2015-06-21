package com.system.dao;

import com.system.domain.DownloadInformation;

import java.util.List;

/**
 * Created by home on 21.06.15.
 */


public interface DownloadInformationDao {

    public void add(DownloadInformation downloadInformation);
    public void update();

    public List<DownloadInformation> gets();

}
