package org.zerock.guestbook.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService service;

//    @Test
//    public void testRegister() {
//
//        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
//                .title("방명록 테스트 0601...")
//                .content("Sample Content...")
//                .writer("user0")
//                .build();
//
//        System.out.println(service.register(guestbookDTO));
//
//    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV:" +resultDTO.isPrev());
        System.out.println("Next:" +resultDTO.isNext());
        System.out.println("Total:" +resultDTO.getTotalPage());

        System.out.println("-------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }

        System.out.println("=========================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
