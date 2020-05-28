package battery;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class BatteryUnitTest {

    @Test
    public void testCharge() throws InterruptedException {
        Battery cell = new Battery();
        Assert.assertEquals(100f, cell.getChargeLevel(),0);
        Thread.sleep(1000);
        cell.charge();
        Assert.assertEquals(110f, cell.getChargeLevel(),0);
    }

    @Ignore
    @Test
    public void testSetup() throws InterruptedException {
        Battery cell = new Battery();
        Assert.assertEquals(100f, cell.getChargeLevel(),0);
        cell.setUp();
        Thread.sleep(1000);
        Assert.assertEquals(110f, cell.getChargeLevel(),0);
        Thread.sleep(1000);
        Assert.assertEquals(120f, cell.getChargeLevel(),0);
    }
    
    @Test (expected = InsufficientChargeException.class)
    public void testUseWithInsufficientCharge() throws Exception {
        Battery cell = new Battery();
        cell.use(125f);
    }

    @Test
    public void testUse() throws InsufficientChargeException {
        Battery cell = new Battery();
        cell.use(25f);
        Assert.assertEquals(75f, cell.getChargeLevel(),0);
    }

    @Test
    public void testUseMax() throws InsufficientChargeException {
        Battery cell = new Battery();
        cell.use(cell.getChargeLevel());
        Assert.assertEquals(0f, cell.getChargeLevel(),0);
    }

}
