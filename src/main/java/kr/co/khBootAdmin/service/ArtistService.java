package kr.co.khBootAdmin.service;

import kr.co.khBootAdmin.mapper.AdminMapper;
import kr.co.khBootAdmin.model.vo.ArtistVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ArtistService {
    private final AdminMapper adminMapper;
    public List<ArtistVO> followCount(ArtistVO artistVO){

        return adminMapper.followCount( artistVO );
    }
}
