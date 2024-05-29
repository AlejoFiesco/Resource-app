

import com.example.demo.business.implementation.ClassroomBusinessImp;
import com.example.demo.model.Classroom;
import com.example.demo.services.implementation.ClassroomServiceImp;
import com.example.demo.utilities.responses.CustomResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClassroomServiceImpTest {

    @InjectMocks
    ClassroomServiceImp classroomService;

    @Mock
    ClassroomBusinessImp classroomBusiness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateClassroom() throws Exception {
        Classroom classroom = new Classroom();
        when(classroomBusiness.createClassroom(classroom)).thenReturn(classroom);

        ResponseEntity<Classroom> response = classroomService.createClassroom(classroom);

        assertEquals(CustomResponse.buildResponse(classroom), response);
        verify(classroomBusiness, times(1)).createClassroom(classroom);
    }

    @Test
    void testGetClassroom() throws Exception {
        List<Classroom> classroomList = Arrays.asList(new Classroom(), new Classroom());
        when(classroomBusiness.getClassroomList()).thenReturn(classroomList);

        ResponseEntity<List<Classroom>> response = classroomService.getClassroom();

        assertEquals(CustomResponse.buildResponse(classroomList), response);
        verify(classroomBusiness, times(1)).getClassroomList();
    }

    @Test
    void testGetClassroomById() throws Exception {
        String classroomId = "1";
        Classroom classroom = new Classroom();
        when(classroomBusiness.getClassroomById(classroomId)).thenReturn(classroom);

        ResponseEntity<Classroom> response = classroomService.getClassroomById(classroomId);

        assertEquals(CustomResponse.buildResponse(classroom), response);
        verify(classroomBusiness, times(1)).getClassroomById(classroomId);
    }
}
