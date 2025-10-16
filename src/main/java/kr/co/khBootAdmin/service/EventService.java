package kr.co.khBootAdmin.service;

import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.EventDetailResponse;
import kr.co.khBootAdmin.model.payload.request.EventRequest;
import kr.co.khBootAdmin.model.vo.SearchHelper;

import java.util.HashMap;

public interface EventService {

    HashMap<String, Object> selectEvent(SearchHelper searchHelper);

    EventDetailResponse selectEventDetail(Long eventId);

    void eventSave(EventRequest request, CustomUserDetails user);

    void deleteEvent(Long eventId);
}

