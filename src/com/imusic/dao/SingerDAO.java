package com.imusic.dao;

import com.imusic.bean.Singer;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 *
 * 声明歌手数据操作信息(前三个方法可由管理员调用)
 */
public interface SingerDAO {
    public void addSinger(Singer singer);          // 添加歌手
    public void deleteSinger(Singer singer);       // 删除歌手
    public void updateSinger(Singer singer);       // 更新歌手信息
    public List<Singer> findAllSinger();          // 查找所有的歌手
    public Singer findSingerByID(int singerID);    // 根据SingerID查找歌手
    // 根据后续业务，可能需要 findSingerByName(String singerName);
}
