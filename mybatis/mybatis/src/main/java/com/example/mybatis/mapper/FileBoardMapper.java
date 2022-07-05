package com.example.mybatis.mapper;

import com.example.mybatis.vo.FileBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileBoardMapper {
    List<FileBoardVO> getFileBoardList();

    FileBoardVO getFileBoard(int b_no);

    int insertFileBoard(FileBoardVO fileBoardVO);

    int updateFileBoard(FileBoardVO fileBoardVO);

    int deleteFileBoard(int b_no);

}
