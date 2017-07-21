package com.imusic.dao;

import com.imusic.bean.Album;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 *
 * 声明专辑相关操作（可由管理员进行添加，因为是歌手专辑）
 */
public interface AlbumDAO {

    public void addAlbum(Album album);          // 添加专辑
    public void deleteAlbum(Album album);       // 删除专辑
    public void updateAlbum(Album album);       // 更新专辑
    public List<Album> findAllAlbum();          // 查找所有的专辑
    public Album findAlbumByID(int albumID);    // 根据albumID查找专辑
    // 根据后续业务，可能需要 findAlbumByName(String albumName);
}
