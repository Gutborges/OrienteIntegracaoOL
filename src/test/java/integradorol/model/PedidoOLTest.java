package integradorol.model;

import integradorol.commons.BaseTest;
import br.com.orientefarma.integradorol.dao.PedidoOLDAO;
import br.com.orientefarma.integradorol.dao.vo.PedidoOLVO;
import br.com.orientefarma.integradorol.model.ItemPedidoOL;
import br.com.orientefarma.integradorol.model.PedidoOL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PedidoOLTest extends BaseTest {
    @Mock
    private PedidoOLDAO pedidoOLDAOMock;
    @Mock
    private PedidoOLVO pedidoOLVOMock;
    @Mock
    private ItemPedidoOL itemPedidoOLMock;
    @InjectMocks
    private PedidoOL pedidoOL;

    @SuppressWarnings({"JUnitMalformedDeclaration", "resource"})
    @BeforeAll
    void setupAll(){
        MockitoAnnotations.openMocks(this);
        super.mockarAtributoPrivado(pedidoOL, "pedidoOLDAO", pedidoOLDAOMock);
    }

    @Test
    void primeiro(){
        System.out.printf("ola" + pedidoOL.toString());
    }

}
