
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

import com.example.demo.business.implementation.ResourceBusinessImp;
import com.example.demo.model.Resource;
import com.example.demo.services.implementation.ResourceServiceImpl;

class ResourceServiceImplTest {

    @InjectMocks
    private ResourceServiceImpl resourceService;

    @Mock
    private ResourceBusinessImp resourceBusiness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateResource() throws Exception {
        Resource resource = new Resource();
        resource.setId("1");
        resource.setName("Test Resource");

        when(resourceBusiness.createResource(resource)).thenReturn(resource);

        ResponseEntity<Resource> response = resourceService.createResource(resource);

        assertNotNull(response);
        assertEquals("Test Resource", response.getBody().getName());
        verify(resourceBusiness, times(1)).createResource(resource);
    }

    @Test
    void testGetResources() throws Exception {
        Resource resource1 = new Resource();
        resource1.setId("1");
        resource1.setName("Test Resource 1");

        Resource resource2 = new Resource();
        resource2.setId("2");
        resource2.setName("Test Resource 2");

        List<Resource> resourceList = Arrays.asList(resource1, resource2);

        when(resourceBusiness.getResourceList()).thenReturn(resourceList);

        ResponseEntity<List<Resource>> response = resourceService.getResources();

        assertNotNull(response);
        assertEquals(2, response.getBody().size());
        verify(resourceBusiness, times(1)).getResourceList();
    }

    @Test
    void testGetResourceById() throws Exception {
        Resource resource = new Resource();
        resource.setId("1");
        resource.setName("Test Resource");

        when(resourceBusiness.getResourceById("1")).thenReturn(resource);

        ResponseEntity<Resource> response = resourceService.getResourceById("1");

        assertNotNull(response);
        assertEquals("Test Resource", response.getBody().getName());
        verify(resourceBusiness, times(1)).getResourceById("1");
    }
}
