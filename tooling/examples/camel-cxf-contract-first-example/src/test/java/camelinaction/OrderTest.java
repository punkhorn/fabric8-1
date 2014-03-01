package camelinaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

public class OrderTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/camel-route.xml";
    }

    @Test
    public void testOrderOk() throws Exception {
        List<Object> params = new ArrayList<Object>();
        params.add("motor");
        params.add(1);
        params.add("honda");
        
        String reply = template.requestBody("cxf:bean:orderEndpoint", params, String.class);
        assertEquals("OK", reply);
    }
}