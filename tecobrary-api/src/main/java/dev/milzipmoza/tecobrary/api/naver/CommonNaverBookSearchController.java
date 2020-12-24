package dev.milzipmoza.tecobrary.api.naver;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.naver.dto.NaverBookSearchRequest;
import dev.milzipmoza.tecobrary.api.naver.dto.NaverBookSearchResponse;
import dev.milzipmoza.tecobrary.api.naver.facade.NaverBookSearchFacade;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.NAVER_API_BOOK_SEARCH_SUCCESS;

@RestController
public class CommonNaverBookSearchController {

    private final NaverBookSearchFacade naverBookSearchFacade;

    public CommonNaverBookSearchController(NaverBookSearchFacade naverBookSearchFacade) {
        this.naverBookSearchFacade = naverBookSearchFacade;
    }

    @GetMapping({
            "/admin/naver-api/books",
            "/web/naver-api/books"
    })
    public ApiResponse<NaverBookSearchResponse> search(NaverBookSearchRequest request) {
        List<NaverBookSearchItemDto> bookItems = naverBookSearchFacade.searchBooks(request.getKeyword(), request.getPage(), request.getSize());
        return ApiResponse.ok(NAVER_API_BOOK_SEARCH_SUCCESS, new NaverBookSearchResponse(bookItems));
    }
}
