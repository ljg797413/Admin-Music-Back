package kr.co.khBootAdmin.controller.cmmon;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.khBootAdmin.annotation.CurrentUser;
import kr.co.khBootAdmin.event.OnUserLogoutSuccessEvent;
import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.payload.request.LogOutRequest;
import kr.co.khBootAdmin.model.payload.response.ApiResponse;
import kr.co.khBootAdmin.model.payload.response.UserResponse;
import kr.co.khBootAdmin.model.vo.CommentReportVO;
import kr.co.khBootAdmin.model.vo.UserRoleVO;
import kr.co.khBootAdmin.service.CommentReportService;
import kr.co.khBootAdmin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CommentReportService commentReportService;
    /**
     * 현재 사용자의 프로필 리턴
     * @param currentUser
     * @return
     */
    @GetMapping("/me")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SYSTEM')")
    @ApiOperation(value = "사용자 정보 확인")
    @ApiImplicitParam(name = "currentUser", value = "사용자 정보", dataType = "CustomUserDetails", dataTypeClass = CustomUserDetails.class, required = true)
    public ResponseEntity<?> getUserProfile(@CurrentUser CustomUserDetails currentUser) {
        UserResponse userResponse = new UserResponse(currentUser.getUsername(), currentUser.getEmail(), currentUser.getRoles());
        return ResponseEntity.ok(userResponse);
    }

    /**
     * 로그아웃
     * @param customUserDetails
     * @param logOutRequest
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation(value = "로그아웃", notes = "로그아웃하면 로그아웃된 토큰을 별도로 저장해서 관리한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentUser", value = "사용자 정보", dataType = "CustomUserDetails", dataTypeClass = CustomUserDetails.class, required = true),
            @ApiImplicitParam(name = "logOutRequest", value = "로그아웃 VO", dataType = "LogOutRequest", dataTypeClass = LogOutRequest.class, required = true)
    })
    public ResponseEntity<?> logoutUser(@CurrentUser CustomUserDetails customUserDetails,
                                     @Valid @RequestBody LogOutRequest logOutRequest) {
        log.info(customUserDetails.toString());
        log.info(logOutRequest.toString());
        userService.logoutUser(customUserDetails, logOutRequest);
        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();

        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(customUserDetails.getEmail(), credentials.toString(), logOutRequest);
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        return ResponseEntity.ok(new ApiResponse(true, "로그아웃 되었습니다."));
    }

    /**
     * 전체 사용자 목록 조회 (JSON 반환)
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SYSTEM')")
    @ApiOperation(value = "전체 사용자 목록 조회", notes = "관리자 또는 시스템 권한만 접근 가능")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUserList());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/reported-comments")
    public ResponseEntity<List<CommentReportVO>> getReportedComments() {
        log.info("신고 정보 데이터 오는지 확인");
        List<CommentReportVO> reports = commentReportService.getReportedComments();
        log.info("reports 값 : " + reports);
        return ResponseEntity.ok(reports);
    }

    @PutMapping("/active/{userId}")
    public ResponseEntity<?> activeUser(@PathVariable Long userId) {
        userService.activeUserById(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deactive/{userId}")
    public ResponseEntity<?> deActiveUser(@PathVariable Long userId) {
        userService.deActiveUserById(userId);
        return ResponseEntity.ok().build();
    }

    //



    @GetMapping("/search")
    public ResponseEntity<List<UserRoleVO>> searchUsers(@RequestParam(value = "keyword", required = false) String keyword) {
        List<UserRoleVO> users = userService.searchUsers(keyword);
        log.info(users.toString());
        return ResponseEntity.ok(users);
    }

}
