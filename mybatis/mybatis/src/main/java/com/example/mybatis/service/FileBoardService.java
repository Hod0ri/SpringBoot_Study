package com.example.mybatis.service;

import com.example.mybatis.vo.FileBoardVO;

import java.util.List;

public interface FileBoardService {
    List<FileBoardVO> getFileBoardList();

    FileBoardVO getFileBoard(int b_no);

    int insertFileBoard(FileBoardVO fileBoardVO);

    int updateFileBoard(FileBoardVO fileBoardVO);

    int deleteFileBoard(int b_no);
}
