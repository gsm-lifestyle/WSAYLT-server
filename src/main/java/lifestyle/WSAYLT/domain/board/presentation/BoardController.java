package lifestyle.WSAYLT.domain.board.presentation;


import lifestyle.WSAYLT.domain.board.presentation.dto.request.BoardRequest;
import lifestyle.WSAYLT.domain.board.service.InsertHeartService;
import lifestyle.WSAYLT.domain.board.service.WriteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final WriteBoardService writeBoardService;
    private final InsertHeartService heartInsertService;

    @PostMapping
    public void write(@RequestBody @Valid BoardRequest boardRequest){
        writeBoardService.execute(boardRequest);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Void> insert(@PathVariable("id") Long id){
        heartInsertService.execute(id);
        return ResponseEntity.ok().build();
    }
}
