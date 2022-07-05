package com.example.mybatis.service;

import com.example.mybatis.mapper.FileBoardMapper;
import com.example.mybatis.vo.FileBoardVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FileBoardServiceImp implements FileBoardService {

    @Autowired
    FileBoardMapper fileBoardMapper;

    @Override
    public List<FileBoardVO> getFileBoardList() {
        return fileBoardMapper.getFileBoardList();
    }

    @Override
    public FileBoardVO getFileBoard(int b_no) {
        return fileBoardMapper.getFileBoard(b_no);
    }

    @Override
    public int insertFileBoard(FileBoardVO fileBoardVO) {
        return fileBoardMapper.insertFileBoard(fileBoardVO);
    }

    @Override
    public int updateFileBoard(FileBoardVO fileBoardVO) {
        return fileBoardMapper.updateFileBoard(fileBoardVO);
    }

    @Override
    public int deleteFileBoard(int b_no) {
        return fileBoardMapper.deleteFileBoard(b_no);
    }
}

