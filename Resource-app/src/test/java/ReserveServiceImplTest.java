
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.business.implementation.ReserveBusinessImpl;
import com.example.demo.model.Reserve;
import com.example.demo.services.implementation.ReserveServiceImpl;

public class ReserveServiceImplTest {

    @Mock
    private ReserveBusinessImpl reserveBusiness;

    @InjectMocks
    private ReserveServiceImpl reserveService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateReserve() throws Exception {
        Reserve reserve = new Reserve();
        Reserve createdReserve = new Reserve();
        
        when(reserveBusiness.createReserve(reserve)).thenReturn(createdReserve);
        
        ResponseEntity<Reserve> response = reserveService.createReserve(reserve);
        
        assertNotNull(response);
        assertEquals(response.getBody(), createdReserve);
    }

    @Test
    public void testGetReserves() throws Exception {
        List<Reserve> reserveList = Arrays.asList(new Reserve(), new Reserve());
        
        when(reserveBusiness.getReserveList(any())).thenReturn(reserveList);
        
        ResponseEntity<List<Reserve>> response = reserveService.getReserves("classroomId", "resourceId", "reservedById", "startDate", "endDate");
        
        assertNotNull(response);
        assertEquals(response.getBody(), reserveList);
    }

    @Test
    public void testGetReserveById() throws Exception {
        Reserve reserve = new Reserve();
        
        when(reserveBusiness.getReserveById("id")).thenReturn(reserve);
        
        ResponseEntity<Reserve> response = reserveService.getReserveById("id");
        
        assertNotNull(response);
        assertEquals(response.getBody(), reserve);
    }

    @Test
    public void testRegisterDevolution() throws Exception {
        Reserve reserve = new Reserve();
        
        when(reserveBusiness.registerDevolution("id")).thenReturn(reserve);
        
        ResponseEntity<Reserve> response = reserveService.registerDevolution("id");
        
        assertNotNull(response);
        assertEquals(response.getBody(), reserve);
    }
}
